Wizard

Some times you need to ask the user for a lot of information and asking for it all at once would result in a too complex user interface. Perhaps you also need to perform certain operations while or after you have requested the information.

For these situations, you can consider using a wizard. A wizard typically has two or more pages. It lets the user navigate between the pages as well as complete or cancel the process.

TornadoFX has a powerful and customizable Wizard component that lets you do just that. In the following example we need to create a new Customer and we have decided to ask for the basic customer info on the first page and the address information on the next.

Let's have a look at two simple input Views that gather said information from the user. The BasicData page asks for the name of the customer and the type of customer (Person or Company). By now you can probably CustomerModel guess how the Customer and CustomerModel objects look, so we won't repeat them here.

class BasicData : View("Basic Data") {
    val customer: CustomerModel by inject()
​
    override val root = form {
        fieldset(title) {
            field("Type") {
                combobox(customer.type, Customer.Type.values().toList())
            }
            field("Name") {
                textfield(customer.name).required()
            }
        }
    }
}
​
class AddressInput : View("Address") {
    val customer: CustomerModel by inject()
​
    override val root = form {
        fieldset(title) {
            field("Zip/City") {
                textfield(customer.zip) {
                    prefColumnCount = 5
                    required()
                }
                textfield(customer.city).required()
            }
        }
    }
}
By themselves, these views don't do much, but put together in a Wizard we start to see how powerful this input paradigm can be. Our initial Wizard code is only this:

class CustomerWizard : Wizard("Create customer", "Provide customer information") {
    val customer: CustomerModel by inject()
​
    init {
        graphic = resources.imageview("/graphics/customer.png")
        add(WizardStep1::class)
        add(WizardStep2::class)
    }
}
The result can be seen in Figure 21.1.


Figure 21.1

Just by looking at the Wizard the user can see what he will be asked to provide, how he can navigate between the pages and how to complete or cancel the process.

Since the Wizard itself is basically just a normal View, it will respond to the openModal call. Let's imagine a button that opens the Wizard:

button("Add Customer").action {
    find<CustomerWizard> {
        openModal()
    }
}
Page navigation
By default, the Back and Next buttons are available whenever there are more pages either previous or next in the wizard.

For Next navigation however, whether the wizard actually navigates to the next page is dependent upon the completed state of the current page. Every View has a completed property and a corresponding isCompleted variable you can manipulate.

When the Next or Finish button is clicked, the onSave function of the current page is called, and the navigation action is only performed if the current page's completed value is true. Every View is completed by default, that's why we can navigate to page number two without completing page one first. Let's change that.

In the BasicData editor, we override the onSave function to perform a partial commit of the name and type fields, because that's the only two fields the user can change on that page.

override fun onSave() {
    isComplete = customer.commit(customer.name, customer.type)
}
The commit function now controls the completed state of our wizard page, hence controller whether the user is allowed to navigate to the address page. If we try to navigate without filling in the name, we will be granted by the validation error message in Figure 21.2:


Figure 21.2

We could go on to do the same for the address editor, taking care to only commit the editable fields:

override fun onSave() {
    isComplete = customer.commit(customer.zip, customer.city)
}
If the user clicks the Finish button, the onSave function in the Wizard itself is activated. If the Wizard's completed state is true after the onSave call, the wizard dialog is closed, provided that the user calls super.onSave(). In such a scenario, the Wizard itself needs to handle whatever should happen in the onSave function. Another possibility is to configure a callback that will be executed whenever the wizard is completed. With that approach, we need access the completed customer object somehow, so we inject it into the wizard itself as well:

class CustomerWizard : Wizard() {
    val customer: CustomerModel by inject()
}
Let's revisit the button action that activated the wizard and add an onComplete callback that extracts the customer and inserts it into a database before it opens the newly created Customer object in a CustomerEditor View:

button("Add Customer").action {
    find<CustomerWizard> {
        onComplete {
            runAsync {
                database.insert(customer.item)
            } ui {
                workspace.dockInNewScope<CustomerEditor>(customer.item)
            }
        }
        openModal()
    }
}
Wizard scoping
In our example, both of the Wizard pages share a common view model, namely the CustomerModel. This model is injected into both pages, so it should be the same instance. But what if other parts of the application is already using the CustomerModel in the same scope we created the Wizard from? It turns out that this is not even an issue, because the Wizard base class implements InjectionScoped which makes sure that whenever you inject a Wizard subclass, a new scope is automatically activated. This makes sure that whatever resources we require inside the Wizard will be unique and not shared with any other part of the application.

It also means that if you need to inject existing data into a Wizard's scope, you must do so manually:

val wizard = find<MyWizard>()
wizard.scope.set(someExistingObject)
wizard.openModal()
Improving the visual cues
Un until now, the Next button was enabled whenever there was another page to navigate forward to. The Finish button was also always enabled. This might be fine, but you can improve the cues given to your users by only enabling those buttons when it would make sense to click them. By looking into the Wizard base class, we can see that the buttons are bound to the following boolean expressions:

open val canFinish: BooleanExpression = SimpleBooleanProperty(true)
open val canGoNext: BooleanExpression = hasNext
The canFinish expression is bound to the Finish button and the canGoNext expression is bound to the Next button. The Wizard class also includes some boolean expressions that are unused by default. Two of those are currentPageComplete and allPagesComplete. These expressions are always up to date, and we can use them in our CustomerWizard to improve the user experience.

class CustomerWizard : Wizard() {
    override val canFinish = allPagesComplete
    override val canGoNext = currentPageComplete
}
With this redefinition in place, the Next and Finish buttons will only be enabled whenever the new conditions are met. This is what we want, but we're not done yet. Remember how we only updated isCompleted whenever onSave was called? You might also remember that onSave was called whenever Next or Finish was clicked? It looks like we have ourselves a good old Catch22 situation here, folks!

The solution is however quite simple: Instead of evaluating the completed state on save, we will do it whenever a change is made to any of our input fields. We need to make sure that we supply the autocommit parameter to each binding in our ViewModel:

class CustomerModel : ItemViewModel<Customer>() {
    val name = bind(Customer::nameProperty, autocommit = true)
    val zip  = bind(Customer::zipProperty, autocommit = true)
    val city = bind(Customer::cityProperty, autocommit = true)
    val type = bind(Customer::typeProperty, autocommit = true)
}
The input fields in our wizard pages are bound to these properties, and whenever a change is made, the underlying Customer object will be updated. We no longer need to call customer.commit() in our onSave callback, but we do need to redefine the complete boolean expression in each wizard page.

Here is the new definition in the BasicData View:

override val complete = customer.valid(customer.name)
And here is the definition in the AddressInput View:

override val complete = customer.valid(customer.street, customer.zip, customer.city)
We bind the completed state of our wizard pages to an ever updating boolean expression which indicates whether the editable properties for that page is valid or not.

Remember to delete the onSave functions as we no longer need them. If you run the application with these changes you will see how much more expressive the Wizard becomes in terms of telling the user when he can proceed and when he can finish the process. Using this approach will also convey that any non-filled data is optional once the Finish button is enabled.

Here is the completely rewritten wizard and pages:

class CustomerWizard : Wizard() {
    val customer: CustomerModel by inject()
​
    override val canGoNext = currentPageComplete
    override val canFinish = allPagesComplete
​
    init {
        add(BasicData::class)
        add(AddressInput::class)
    }
}
​
class BasicData : View("Basic Data") {
    val customer: CustomerModel by inject()
​
    override val complete = customer.valid(customer.name)
​
    override val root = form {
        fieldset(title) {
            field("Type") {
                combobox(customer.type, Customer.Type.values().toList())
            }
            field("Name") {
                textfield(customer.name).required()
            }
        }
    }
}
​
class AddressInput : View("Address") {
    val customer: CustomerModel by inject()
​
    override val complete = customer.valid(customer.zip, customer.city)
​
    override val root = form {
        fieldset(title) {
            field("Zip/City") {
                textfield(customer.zip) {
                    prefColumnCount = 5
                    required()
                }
                textfield(customer.city).required()
            }
        }
    }
}
Styling and adapting the look and feel
There are many built in options you can configure to change the look and feel of the wizard. Common for them all is that they have observable/writable properties which you can bind to over just set in your wizard subclass. For each accessor below there will be a corresponding accessorProperty.

Modifying the steps indicator
Steps
The steps list is on the left of the wizard. It has the following configuration options:

Name

Description

showSteps

Set to false to remove the steps view completely

stepsText

Change the header from "Steps" to any desired String

showStepsHeader

Remove the header

enableStepLinks

Set to true to turn each step description into a hyperlink

stepLinksCommits

Set to false to no longer require that the current page is valid before navigating to the new page

numberedSteps

Set to true to add the index number before each step description

Navigation
You can change the text of the navigation buttons and control navigation flow with Enter:

Name

Description

backButtonText

Change the text of the Back button

nextButtonText

Change the text of the Next button

cancelButtonText

Change the text of the Cancel button

finishButtonText

Change the text of the Finish button

enterProgresses

Enter goes to next page when complete and finish on last page

Header area
Name

Description

showHeader

Set to false to remove the header

graphic

A node that will show up on the far right of the header

Structural modifications
The root of the Wizard class is a BorderPane. The header will be in the top slot, the steps are in the left slot, the pages are in the center slot and the buttons are in the bottom slot. You can change/hide/add styling and set properties to these nodes as you see fit to alter the design and layout of the Wizard. A good place to do this would be in the onDock callback of your wizard subclass. It is completely valid change the layout in any way you see fit, you can even remove the BorderPane and move the other parts into another layout container for example.
