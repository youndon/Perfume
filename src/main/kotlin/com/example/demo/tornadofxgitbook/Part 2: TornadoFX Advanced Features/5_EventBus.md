EventBus

An EventBus is a versatile tool with a multitude of use cases. Depending on your coding style and preferences, you might want to reduce coupling between controllers and views by passing messages instead of having hard references to each other. The TornadoFX event bus can make sure that the messages are received on the appropriate thread, without having to do that concurrency house-keeping manually.

People use event buses for many different use cases. TornadoFX does not dictate when or how you should use them, but we want to show you some of the advantages it can provide to you.

Structure of the EventBus
As with any typical event bus implementation, you can fire events as well as subscribe and unsubscribe to events on the bus. You create an event by extending the FXEvent class. In some cases, an event can be just a signal to some other component to trigger something to happen. In other cases, the event can contain data which will be broadcast to the subscribers of this event. Let us look at a couple of event definitions and how to use them.

Picture a UI where the user can click a Button to refresh a list of customers. The View knows nothing of where the data is coming from or how it is produced, but it subscribes to the data events and uses the data once it arrives. Let us create two event classes for this use case.

First we define an event signal type to notify any listeners that we want some customer data:

import tornadofx.EventBus.RunOn.*
​
object CustomerListRequest : FXEvent(BackgroundThread)
This event object is an application-wide object. Because it will never need to contain data, it will simply be broadcast to say that we want the customer list. The RunOn property is set to BackgroundThread, to signal that the receiver of this event should operate off of the JavaFX Application Thread. That means it will be given a background thread by default, so that it can do heavy work without blocking the UI. In the example above, we have added a static import for the RunOn enum, so that we just write BackgroundThread instead of EventBus.RunOn.BackgroundThread. Your IDE will help you to make this import so your code looks cleaner.

A button in the UI can fire this event by using the fire function:

button("Load customers").action {
    fire(CustomerListRequest)
}
A CustomerController might listen for this event, and load the customer list on demand before it fires an event with the actual customer data. First we need to define an event that can contain the customer list:

class CustomerListEvent(val customers: List<Customer>) : FXEvent()
This event is a class rather than an object, as it will contain actual data and vary. Also, it did not specify another value for the RunOn property, so this event will be emitted on the JavaFX Application Thread.

A controller can now subscribe to our request for data and emit that data once it has it:

class CustomerController : Controller() {
    init {
        subscribe<CustomerListRequest> {
            val customers = loadCustomers()
            fire(CustomerListEvent(customers))
        }
    }
​
    fun loadCustomers(): List<Customer> = db.selectAllCustomers()
}
Back in our UI, we can listen to this event inside the customer table definition:

tableview<Customer> {
   column("Name", Customer::nameProperty)
   column("Age", Customer::ageProperty)
​
   subscribe<CustomerListEvent> { event ->
       items.setAll(event.customers)
   }
}
We tell the event bus that we are interested in CustomerListEvents, and once we have such an event we extract the customers from the event and set them into the items property of the TableView.

Query Parameters In Events
Above you saw a signal used to ask for data, and an event returned with that data. The signal could just as well contain query parameters. For example, it could be used to ask for a specific customer. Imagine these events:

class CustomerQuery(val id: Int) : FXEvent(false)
class CustomerEvent(val customer: Customer) : FXEvent()
Using the same procedure as above, we can now signal our need for a specific Customer, but we now need to be more careful with the data we get back. If our UI allows for multiple customers to be edited at once, we need to make sure that we only apply data for the customer we asked for. This is quite easily accounted for though:

class CustomerEditor(val customerId: Int) : View() {
   val model : CustomerModel
​
   override val root = form {
       fieldset("Customer data") {
          field("Name") {
              textfield(model.name)
          }
          // More fields and buttons here
       }
   }
​
   init {
       subscribe<CustomerEvent> {
           if (it.customer.id == customerId)
               model.item = it.customer
       }
       fire(CustomerQuery(customerId))
   }
}
The UI is created before the interesting bit happens in the init function. First, we subscribe to CustomerEvents, but we make sure to only act once we retrieve the customer we were asking for. If the customerId matches, we assign the customer to the item property of our ItemViewModel, and the UI is updated.

A nice side effect of this is that our customer object will be updated whenever the system emits new data for this customer, no matter who asked for them.

Events and Threading
When you create a subclass of FXEvent, you dictate the value of the runOn property. It is ApplicationThread by default, meaning that the subscriber will receive the event on the JavaFX Application Thread. This is useful for events coming from and going to other UI components, as well as backend services sending data to the UI. If you want to signal something to a backend service, one which is likely to perform heavy, long-running work, you should set runOn to BackgroundThread, making sure the subscriber will operate off of the UI thread. The subscriber now no longer needs to make sure that it is off of the UI thread, so you remove a lot of thread-related house keeping calls. Used correctly this is convenient and powerful. Used incorrectly, you will have a non responsive UI. Make sure you understand this completely before playing with events, or always wrap long running tasks in runAsync {}.

Scopes
The event bus emits messages across all scopes by default. If you want to limit signals to a certain scope, you can supply the second parameter to the FXEvent constructor. This will make sure that only subscribers from the given scope will receive your event.

class CustomerListRequest(scope: Scope) : FXEvent(BackgroundThread, scope)
The CustomerListRequest is not an object anymore since it needs to contain the scope parameter. You would now fire this event from any UI Component like this:

button("Load customers").action {
    fire(CustomerListRequest(scope))
}
The scope parameter from your UIComponent is passed into the CustomerListRequest. When customer data comes back, the framework takes care of discriminating on scope and only apply the results if they are meant for you. You do not need to mention the scope to the subscribe function call, as the framework will associate your subscription with the scope your are in at the time you create the subscription.

subscribe<CustomerListEvent> { event ->
   items.setAll(event.customers)
}
Invalidation of Event Subscribers
In many event bus implementations, you are left with the task of deregistering the subscribers when your UI components should no longer receive them. TornadoFX takes an opinionated approach to event cleanup so you do not have to think about it much.

Subscriptions inside UIComponents like View and Fragment are only active when that component is docked. That means that even if you have a View that has been previously initialized and used, event subscriptions will not reach it unless the View is docked inside a window or some other component. Once the view is docked, the events will reach it. Once it is undocked, the events will no longer be delivered to your component. This takes care of the need for you to manually deregister subscribers when you discard of a view.

For Controllers however, subscriptions are always active until you call unsubscribe. You need to keep in mind that controllers are lazily loaded, so if nothing references your controller, the subscriptions will never be registered in the first place. If you have such a controller with no other references, but you want it to subscribe to events right away, a good place to eagerly load it would be the init block of your App subclass:

class MyApp : App(MainView::class) {
    init {
        // Eagerly load CustomerController so it can receive events
        find(CustomerController::class)
    }
}
Duplicate Subscriptions
To avoid registering your subscriptions multiple times, make sure you do not register the event subscriptions in onDock() or any other callback function that might be invoked more than once for the duration of the component lifecycle. The safest place to create event subscriptions is in the init block of the component.

Should I use events for UI logic everywhere?
Using events for everything might seem like a noble idea, and some people might prefer it because of the loose coupling it facilitates. However, the ItemViewModel with injection is often a more streamlined solution to passing data and keeping UI state. This example was provided to explain how the event system works, not to convince you to write your UIs this way all the time.

Many feel that events might be better suited for passing signals rather than actual data, so you might also consider subscribing to signals and then actively retrieving the data you need instead.

Unsubscribe after event is processed
In some situations you might want to only want to trigger your listener a certain amount of times. Admittedly, this is not very convenient. You can pass the times = n parameter to subscribe to control how many times the event is triggered before it is unsubscribed:

object MyEvent : FXEvent()
​
class MyView : View() {
    override val root = stackpane {
        paddingAll = 100
        button("Fire!").action {
            fire(MyEvent)
        }
    }
​
    init {
        subscribe<MyEvent>(times = 2) {
            alert(INFORMATION, "Event received!", "This message should only appear twice.")
        }
    }
}
You can also manually unsubscribe based on an arbitrary condition, or simply after the first run:

class MyView : View() {
    override val root = stackpane {
        paddingAll = 100
        button("Fire!").action {
            fire(MyEvent)
        }
    }
​
    init {
         subscribe<MyEvent> {
            alert(INFORMATION, "Event received!", "This message should only appear once.")
            unsubscribe()
        }
    }
}
