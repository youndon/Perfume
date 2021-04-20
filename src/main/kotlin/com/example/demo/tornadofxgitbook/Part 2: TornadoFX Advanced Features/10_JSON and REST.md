#JSON and REST

##JSON and REST:

`JSON` has become the new standard for data exchange over `HTTP`.
Working with `JSON` with the data types defined in `javax.json` is not hard, but a bit cumbersome.
The TornadoFX `JSON` support comes
in two forms: `Enhancements` to the `javax.json` objects and functions and a specialized `REST` client that does `HTTP` as well as automatic conversion between `JSON` and your domain models.

To facilitate conversion between these `JSON` objects and your model objects, you can choose to implement the interface `JsonModel` and one or both of the functions `updateModel` and `toJSON`.

Later in this chapter we will introduce the `REST` client, but the `JSON` Support can also be used standalone. 
The `REST` client calls certain functions on `JsonModel` objects during the lifecycle of an `HTTP` request.

`updateModel` is called to convert a `JSON` object to your domain model. 
It receives a `JSON` object from which you can update the properties of your model object.

`toJSON` is called to convert your model object to a `JSON` payload. 
It receives a `JsonBuilder` where you can set the values of the model object.

```kotlin
class Person : JsonModel {
    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    val firstNameProperty = SimpleStringProperty()
    var firstName by firstNameProperty

    val lastNameProperty = SimpleStringProperty()
    var lastName by lastNameProperty

    val phones = FXCollections.observableArrayList<Phone>()

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = int("id")
            firstName = string("firstName")
            lastName = string("lastName")
            phones.setAll(getJsonArray("phones").toModel())
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("id", id)
            add("firstName", firstName)
            add("lastName", lastName)
            add("phones", phones.toJSON())
        }
    }
}

class Phone : JsonModel {
    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    val numberProperty = SimpleStringProperty()
    var number by numberProperty

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = int("id")
            number = string("number")
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("id", id)
            add("number", number)
        }
    }
}
```
JsonModel with `getters/setters` and `property()` accessor functions to be `JavaFX` Property compatible

When you implement `JsonModel` you also get the copy function, which creates a copy of your model object.

TornadoFX also comes with special support functions for reading and writing `JSON` properties.
Please see the bottom of `Json.kt` for an exhaustive list.

All the `JSON` retrieval functions accepts a vararg argument for the key in the `JSON` document. 
The first key available in the document will be used to retrieve the value. 
This makes it easier to work with slightly inconsistent `JSON` schemes or can be used as a ternary to provide a fallback value for example.

##Configuring datetime:

The `datetime(key)` function used to retrieve a `LocalDateTime` object from `JSON` will by default expect a value of `"Seconds since epoch"`. 
If your external webservice expects "Milliseconds since epoch" instead,
you can either send `datetime(key, millis = true)` or configure it globally by setting `JsonConfig.DefaultDateTimeMillis = true`.

##Generating JSON objects:

The `JsonBuilder` is an abstraction over `javax.json.JsonObjectBuilder` that supports null values.
Instead of blowing up, it silently dismisses the missing entry, which enables you to build your `JSON` object graph
more fluently without checking for nulls.

##REST Client:

The `REST` Client that makes it easy to perform `JSON` based `REST` calls.
The underlying `HTTP` engine interface has two implementations.
The default uses `HttpURLConnection` and there is also an implementation based on Apache `HttpClient`.
It is easy to extend the `Rest.Engine` to support other http client libraries if needed.

To use the Apache `HttpClient` implementation, simply call `Rest.useApacheHttpClient()` in the init method of your App class and include the `org.apache.httpcomponents:httpclient` dependency in your project descriptor.

##Configuration:

If you mostly access the same api on every call, you can set a base uri so subsequent calls only need to include relative urls.
You can configure the base url anywhere you like, but the init function of your App class is a good place to do it.
```kotlin
class MyApp : App() {
    val api: Rest by inject()

    init {
        api.baseURI = "https://contoso.com/api"
    }
}
```
##Basic operations:

There are convenience functions to perform `GET`, `PUT`, `POST` and `DELETE` operations.
```kotlin
class CustomerController : Controller() {
    val api: Rest by inject()

    fun loadCustomers(): ObservableList<Customer> =
        api.get("customers").list().toModel()
}
```
##CustomerController with loadCustomers call:

So, what exactly is going on in the `loadCustomers` function? First we call `api.get("customers")` which will perform the call and return a `Response` object. 
We then call `Response.list()` which will consume the response and convert it to a `javax.json.JsonArray`.
Lastly, we call the extension function `JsonArray.toModel()` which creates one Customer object per `JsonObject` in the array and calls `JsonModel.updateModel` on it. 
In this example, the type argument is taken from the function return type, but you could also write the above method like this if you prefer:
```kotlin
fun loadCustomers() = api.get("customers").list().toModel<Customer>()
```
How you provide the type argument to the `toModel` function is a matter of taste, so choose the syntax you are most comfortable with.

These functions take an optional parameter with either a `JsonObject` or a `JsonModel` that will be the payload of your request, converted to a `JSON` string.

The following example updates a customer object.
```kotlin
fun updateCustomer(customer: Customer) = api.put("customers/${customer.id}", customer)
```
If the api endpoint returns the customer object to us after save, we would fetch a `JsonObject` by calling `one()` and then `toModel()` to convert it back into our model object.
```kotlin
fun updateCustomer(customer: Customer) =
    api.put("customers/${customer.id}", customer).one().toModel<Customer>()
```
##Query parameters:

Query parameters needs to be `URL` encoded. 
The `Map.queryString` extension value will turn any map into a properly `URL` encoded query string:
```kotlin
val params = mapOf("id" to 1)
api.put("customers${params.queryString}", customer).one().toModel<Customer>()
```
This will call the `URI` `customers?id=1`.

##Error handling:

If an `I/O` error occurs during the processing of the request, the default Error Handler will report the error to the user.
You can of course catch any errors yourself instead.
To handle `HTTP` return codes, you might want to inspect the Response before you convert the result to `JSON`. 
Make sure you always call `consume()` on the response if you don't extract data from it using any of the methods `list()`, `one()`, `text()` or `bytes()`.
```kotlin
fun getCustomer(id: Int): Customer {
    val response = api.get("some/action")

    try {
        if (response.ok())
            return response.one().toModel()
        else if (response.statusCode == 404)
            throw CustomerNotFound()
        else
            throw MyException("getCustomer returned ${response.statusCode} ${response.reason}")
    } finally {
        response.consume()
    }
}
```
Extract status code and reason from `HttpResponse`

`response.ok()` is shorthand for `response.statusCode == 200`.

##Authentication:

Tornado FX makes it very easy to add basic authentication to your api requests:
```kotlin
api.setBasicAuth("username", "password")
```
To configure authentication manually, configure the requestInterceptor of the engine to add custom headers etc to the request. 
For example, this is how the basic authentication is implemented for the `HttpUrlEngine`:
```kotlin
requestInterceptor = { request ->
    val b64 = Base64.getEncoder().encodeToString("$username:$password".toByteArray(UTF_8))
    request.addHeader("Authorization", "Basic $b64")
}
```
For a more advanced example of configuring the underlying client, take a look at how basic authentication is implemented in the `HttpClientEngine.setBasicAuth` function in `Rest.kt`.

##Intercepting calls:

You can for example show a login screen if an `HTTP` call fails with `statusCode 401`:
```kotlin
api.engine.responseInterceptor = { response ->
    if (response.statusCode == 401)
        showLoginScreen("Invalid credentials, please log in again.")
}
```
##Setting timeouts:

You can configure the read timeout for the default provider by using a `requestInterceptor` and casting the request to `HttpURLRequest` before yo operate on it.
```kotlin
api.engine.requestInterceptor = {
    (it as HttpURLRequest).connection.readTimeout = 5000
}
```
You can configure the `connectionTimeout` of the `HTTPUrlConnection` object above in the same way.

##Connect to multiple API's:

You can create multiple instances of the Rest class by subclassing it and configuring each subclass as you wish. 
Injection of subclasses work seamlessly. 
Override the engine property if you want to use another engine than the default.

##Default engine for new Rest instances:

The engine used by a new Rest client is configured with the `engineProvider` of the `Rest` class.
This is what happens when you call `Rest.useApacheHttpClient`:
```kotlin
Rest.engineProvider = { rest -> HttpClientEngine(rest) }
```
The `engineProvider` returns a concrete engine implementation that is given the current `Rest` instance as argument.

You can override the configured engine in a `Rest` instance at any time.

##Proxy:

A proxy can be configured either by implementing an interceptor that augments each call, or, preferably once per Rest client instance:
```kotlin
rest.proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", 8080))
```
##Sequence numbers:

If you do multiple `http` calls they will not be pooled and returned in the order you executed the calls.
Any http request will return as soon as it is available. 
If you want to handle them in sequence, or even discard older results, you can use the `Response.seq` value which will contain a `Long` sequence number.

##Progress indicator:

TornadoFX comes with a `HTTP` `ProgressIndicator` View. 
This view can be embedded in your application and will show you information about ongoing `REST` calls.
Embed the `RestProgressBar` into a `ToolBar` or any other parent container:
```kotlin
toolbar.add(RestProgressBar::class)
```
