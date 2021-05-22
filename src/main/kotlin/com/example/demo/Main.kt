import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import javafx.scene.control.cell.TreeItemPropertyValueFactory
import tornadofx.*


fun main() = launch<MainApp>()
class MainApp: App(MainView::class)

class MainView:View() {
    override val root = vbox {
        webview{
            engine.run { //
                this.document.run {
                    // The Document interface represents the entire HTML or XML document. Conceptually, it is the root of the document tree, and provides the primary access to the document's data. Since elements, text nodes, comments, processing instructions, etc. cannot exist outside the context of a Document, the Document interface also contains the factory methods needed to create these objects. The Node objects created have a ownerDocument attribute which associates them with the Document within whose context they were created.
                    this.doctype.run {
                        // Each Document has a doctype attribute whose value is either null or a DocumentType object. The DocumentType interface in the DOM Core provides an interface to the list of entities that are defined for the document, and little else because the effect of namespaces and the various XML schema efforts on DTD representation are not clearly understood as of this writing.
                        this.entities.run {
                            // Objects implementing the NamedNodeMap interface are used to represent collections of nodes that can be accessed by name. Note that NamedNodeMap does not inherit from NodeList; NamedNodeMaps are not maintained in any particular order. Objects contained in an object implementing NamedNodeMap may also be accessed by an ordinal index, but this is simply to allow convenient enumeration of the contents of a NamedNodeMap, and does not imply that the DOM specifies an order to these Nodes.
                            this.length // The number of nodes in this map. The range of valid child node indices is 0 to length-1 inclusive.
                            this.getNamedItem() // Retrieves a node specified by name. Params: name – The nodeName of a node to retrieve.
                            this.getNamedItemNS() // Retrieves a node specified by local name and namespace URI. Per [XML Namespaces ] , applications must use the value null as the namespaceURI parameter for methods if they wish to have no namespace. Params: namespaceURI – The namespace URI of the node to retrieve, localName – The local name of the node to retrieve.
                            this.item() // Returns the indexth item in the map. If index is greater than or equal to the number of nodes in this map, this returns null. Params: index – Index into this map.
                            this.removeNamedItem() // Removes a node specified by name. Params: name – The nodeName of the node to remove.
                            this.removeNamedItemNS() // Removes a node specified by local name and namespace URI. A removed attribute may be known to have a default value when this map contains the attributes attached to an element, as returned by the attributes attribute of the Node interface. Params: namespaceURI – The namespace URI of the node to remove. localName – The local name of the node to remove.
                            this.setNamedItem() // Adds a node using its nodeName attribute. If a node with that name is already present in this map, it is replaced by the new one. Replacing a node by itself has no effect. Params: arg – A node to store in this map. The node will later be accessible using the value of its nodeName attribute.
                            this.setNamedItemNS() // Adds a node using its namespaceURI and localName. If a node with that namespace URI and that local name is already present in this map, it is replaced by the new one. Replacing a node by itself has no effect.Params: arg – A node to store in this map. The node will later be accessible using the value of its namespaceURI and localName attributes.
                        }
                        this.internalSubset // The internal subset as a string, or null if there is none. This is does not contain the delimiting square brackets.
                        this.name // The name of DTD; i.e., the name immediately following the DOCTYPE keyword.
                        this.notations // A NamedNodeMap containing the notations declared in the DTD. Duplicates are discarded. Every node in this map also implements the Notation interface.
                        this.publicId // The public identifier of the external subset.
                        this.systemId // The system identifier of the external subset. This may be an absolute URI or not.
                    }
                    this.documentElement.run {
                        // The Element interface represents an element in an HTML or XML document. Elements may have attributes associated with them; since the Element interface inherits from Node, the generic Node interface attribute attributes may be used to retrieve the set of all attributes for an element. There are methods on the Element interface to retrieve either an Attr object by name or an attribute value by name. In XML, where an attribute value may contain entity references, an Attr object should be retrieved to examine the possibly fairly complex sub-tree representing the attribute value. On the other hand, in HTML, where all attributes have simple string values, methods to directly access an attribute value can safely be used as a convenience.
                        this.schemaTypeInfo.run {
                            // The TypeInfo interface represents a type referenced from Element or Attr nodes, specified in the schemas associated with the document. The type is a pair of a namespace URI and name properties, and depends on the document's schema.
                            this.typeName // The name of a type declared for the associated element or attribute, or null if unknown.
                            this.typeNamespace // The namespace of the type declared for the associated element or attribute or null if the element does not have declaration or if no namespace information is available.
                            this.isDerivedFrom() /* This method returns if there is a derivation between the reference type definition, i.e. the TypeInfo on which the method is being called, and the other type definition, i.e. the one passed as parameters. Params: typeNamespaceArg – the namespace of the other type definition. typeNameArg – the name of the other type definition. derivationMethod – the type of derivation and conditions applied between two types, as described in the list of constants provided in this interface. */
                        }
                        this.tagName // The name of the element. If Node.localName is different from null, this attribute is a qualified name.
                        this.getAttribute() // Retrieves an attribute value by name. Params: name – The name of the attribute to retrieve.
                        this.getAttributeNS() // Params: namespaceURI – The namespace URI of the attribute to retrieve. localName – The local name of the attribute to retrieve.Returns: The Attr value as a string, or the empty string if that attribute does not have a specified or default value.
                        this.getAttributeNode() // Retrieves an attribute node by name. To retrieve an attribute node by qualified name and namespace URI, use the getAttributeNodeNS method.
                        this.getAttributeNodeNS() // Params: namespaceURI – The namespace URI of the attribute to retrieve. localName – The local name of the attribute to retrieve. Returns: The Attr node with the specified attribute local name and namespace URI or null if there is no such attribute.
                        this.getElementsByTagName() // Returns a NodeList of all descendant Elements with a given tag name, in document order. Params: name – The name of the tag to match on. The special value "*" matches all tags.
                        this.getElementsByTagNameNS() // Returns a NodeList of all the descendant Elements with a given local name and namespace URI in document order.  Params: namespaceURI – The namespace URI of the elements to match on. The special value "*" matches all namespaces. localName – The local name of the elements to match on. The special value "*" matches all local names.
                        this.removeAttribute() // Removes an attribute by name. If a default value for the removed attribute is defined in the DTD, a new attribute immediately appears with the default value as well as the corresponding namespace URI, local name, and prefix when applicable.
                        this.removeAttributeNS() // Removes an attribute by local name and namespace URI. If a default value for the removed attribute is defined in the DTD, a new attribute immediately appears with the default value as well as the corresponding namespace URI, local name, and prefix when applicable.
                        this.removeAttributeNode() // Removes the specified attribute node. If a default value for the removed Attr node is defined in the DTD, a new node immediately appears with the default value as well as the corresponding namespace URI, local name, and prefix when applicable.
                        this.setIdAttribute() // If the parameter isId is true, this method declares the specified attribute to be a user-determined ID attribute . This affects the value of Attr.isId and the behavior of Document.getElementById, but does not change any schema that may be in use, in particular this does not affect the Attr.schemaTypeInfo of the specified Attr node. Use the value false for the parameter isId to undeclare an attribute for being a user-determined ID attribute. To specify an attribute by local name and namespace URI, use the setIdAttributeNS method. Params: name – The name of the attribute. isId – Whether the attribute is a of type ID.
                        this.setIdAttributeNS() // If the parameter isId is true, this method declares the specified attribute to be a user-determined ID attribute . This affects the value of Attr.isId and the behavior of Document.getElementById, but does not change any schema that may be in use, in particular this does not affect the Attr.schemaTypeInfo of the specified Attr node. Use the value false for the parameter isId to undeclare an attribute for being a user-determined ID attribute. Params: namespaceURI – The namespace URI of the attribute. localName – The local name of the attribute. isId – Whether the attribute is a of type ID.
                        this.setIdAttributeNode() // If the parameter isId is true, this method declares the specified attribute to be a user-determined ID attribute . This affects the value of Attr.isId and the behavior of Document.getElementById, but does not change any schema that may be in use, in particular this does not affect the Attr.schemaTypeInfo of the specified Attr node. Use the value false for the parameter isId to undeclare an attribute for being a user-determined ID attribute. Params: idAttr – The attribute node. isId – Whether the attribute is a of type ID.
                        this.hasAttribute() // Returns true when an attribute with a given name is specified on this element or has a default value, false otherwise. Params: name – The name of the attribute to look for.
                        this.hasAttributeNS() // Returns true when an attribute with a given local name and namespace URI is specified on this element or has a default value, false otherwise. Params: namespaceURI – The namespace URI of the attribute to look for. localName – The local name of the attribute to look for.
                        this.setAttribute() // Adds a new attribute. If an attribute with that name is already present in the element, its value is changed to be that of the value parameter. Params: name – The name of the attribute to create or alter. value – Value to set in string form.
                        this.setAttributeNS() // Adds a new attribute. If an attribute with the same local name and namespace URI is already present on the element, its prefix is changed to be the prefix part of the qualifiedName, and its value is changed to be the value parameter. Params: namespaceURI – The namespace URI of the attribute to create or alter. qualifiedName – The qualified name of the attribute to create or alter. value – The value to set in string form.
                        this.setAttributeNode() // Adds a new attribute node. If an attribute with that name ( nodeName) is already present in the element, it is replaced by the new one. Params: newAttr – The Attr node to add to the attribute list.
                        this.setAttributeNodeNS() // Adds a new attribute. If an attribute with that local name and that namespace URI is already present in the element, it is replaced by the new one. Params: newAttr – The Attr node to add to the attribute list.
                    }
                    this.documentURI // The location of the document or null if undefined or if the Document was created using DOMImplementation.createDocument. No lexical checking is performed when setting this attribute; this could result in a null value returned when using Node.baseURI .
                    this.domConfig.run {
                        // The DOMConfiguration interface represents the configuration of a document and maintains a table of recognized parameters. Using the configuration, it is possible to change Document.normalizeDocument() behavior, such as replacing the CDATASection nodes with Text nodes or specifying the type of the schema that must be used when the validation of the Document is requested. DOMConfiguration objects are also used in [DOM Level 3 Load and Save ] in the DOMParser and DOMSerializer interfaces.
                        this.parameterNames // The list of the parameters supported by this DOMConfiguration object and for which at least one value can be set by the application. Note that this list can also contain parameter names defined outside this specification.
                        this.setParameter() // Set the value of a parameter. Params: name – The name of the parameter to set. value – The new value or null if the user wishes to unset the parameter. While the type of the value parameter is defined as DOMUserData, the object type must match the type defined by the definition of the parameter. For example, if the parameter is "error-handler", the value must be of type DOMErrorHandler.
                        this.getParameter() // Return the value of a parameter if known. Params: name – The name of the parameter.
                        this.canSetParameter() // Check if setting a parameter to a specific value is supported. Params: name – The name of the parameter to check. value – An object. if null, the returned value is true.
                    }
                    this.implementation.run {
                        // The DOMImplementation interface provides a number of methods for performing operations that are independent of any particular instance of the document object model. ndependent of any particular instance of the document object model. See also the Document Object Model (DOM) Level 3 Core Specification .
                        this.getFeature() // This method returns a specialized object which implements the specialized APIs of the specified feature and version, as specified in DOM Features . The specialized object may also be obtained by using binding-specific casting methods but is not necessarily expected to, as discussed in . This method also allow the implementation to provide specialized objects which do not support the DOMImplementation interface. Params: feature – The name of the feature requested. Note that any plus sign "+" prepended to the name of the feature will be ignored since it is not significant in the context of this method. version – This is the version number of the feature to test.
                        this.hasFeature() // Test if the DOM implementation implements a specific feature and version, as specified in [DOM Features] . Params: feature – The name of the feature to test. version – This is the version number of the feature to test.
                        this.createDocument() // Params: namespaceURI – The namespace URI of the document element to create or null. qualifiedName – The qualified name of the document element to be created or null. doctype – The type of document to be created or null. When doctype is not null, its Node.ownerDocument attribute is set to the document being created. Returns: A new Document object with its document element. If the NamespaceURI, qualifiedName, and doctype are null, the returned Document is empty with no document element.
                        this.createDocumentType() // Creates an empty DocumentType node. Entity declarations and notations are not made available. Entity reference expansions and default attribute additions do not occur. Params: qualifiedName – The qualified name of the document type to be created. publicId – The external subset public identifier. systemId – The external subset system identifier.
                    }
                    this.inputEncoding // An attribute specifying the encoding used for this document at the time of the parsing. This is null when it is not known, such as when the Document was created in memory.
                    this.strictErrorChecking // An attribute specifying whether error checking is enforced or not. When set to false, the implementation is free to not test every possible error case normally defined on DOM operations, and not raise any DOMException on DOM operations or report errors while using Document
                    this.xmlEncoding // An attribute specifying, as part of the [XML declaration] , the encoding of this document. This is null when unspecified or when it is not known, such as when the Document was created in memory.
                    this.xmlStandalone // An attribute specifying, as part of the [XML declaration] , whether this document is standalone. This is false when unspecified.
                    this.xmlVersion // An attribute specifying, as part of the [XML declaration] , the version number of this document. If there is no declaration and if this document supports the "XML" feature, the value is "1.0". If this document does not support the "XML" feature, the value is always null.
                    this.adoptNode() // Attempts to adopt a node from another document to this document. If supported, it changes the ownerDocument of the source node, its children, as well as the attached attribute nodes if there are any. Params: source – The node to move into this document.
                    this.createAttribute() // Creates an Attr of the given name. Note that the Attr instance can then be set on an Element using the setAttributeNode method. To create an attribute with a qualified name and namespace URI, use the createAttributeNS method. Params: name – The name of the attribute.
                    this.createAttributeNS() // Creates an attribute of the given qualified name and namespace URI. Per [XML Namespaces ] , applications must use the value null as the namespaceURI parameter for methods if they wish to have no namespace. Params: namespaceURI – The namespace URI of the attribute to create. qualifiedName – The qualified name of the attribute to instantiate.
                    this.createCDATASection() // Creates a CDATASection node whose value is the specified string. Params: data – The data for the CDATASection contents.
                    this.createComment() // Creates a Comment node given the specified string. Params: data – The data for the node.
                    this.createDocumentFragment() // Creates an empty DocumentFragment object.
                    this.createElement() // Creates an element of the type specified. Note that the instance returned implements the Element interface, so attributes can be specified directly on the returned object. Params: tagName – The name of the element type to instantiate. For XML, this is case-sensitive, otherwise it depends on the case-sensitivity of the markup language in use.
                    this.createElementNS() // Creates an element of the given qualified name and namespace URI. Per [XML Namespaces ] , applications must use the value null as the namespaceURI parameter for methods if they wish to have no namespace. Params: namespaceURI – The namespace URI of the element to create. qualifiedName – The qualified name of the element type to instantiate.
                    this.createEntityReference() // Creates an EntityReference object. In addition, if the referenced entity is known, the child list of the EntityReference node is made the same as that of the corresponding Entity node. Params: name – The name of the entity to reference.Unlike Document.createElementNS or Document.createAttributeNS, no namespace well-formed checking is done on the entity name.
                    this.createProcessingInstruction() // Creates a ProcessingInstruction node given the specified name and data strings. Params: target – The target part of the processing instruction.Unlike Document.createElementNS or Document.createAttributeNS, no namespace well-formed checking is done on the target name.
                    this.createTextNode() // Creates a Text node given the specified string. Params: data – The data for the node.
                    this.getElementById() // Returns the Element that has an ID attribute with the given value. Params: elementId – The unique id value for an element.
                    this.getElementsByTagName() // Returns a NodeList of all the Elements in document order with a given tag name and are contained in the document. Params: tagname – The name of the tag to match on. The special value "*" matches all tags. For XML, the tagname parameter is case-sensitive, otherwise it depends on the case-sensitivity of the markup language in use.
                    this.getElementsByTagNameNS() // Returns a NodeList of all the Elements with a given local name and namespace URI in document order. Params: namespaceURI – The namespace URI of the elements to match on. The special value "*" matches all namespaces. localName – The local name of the elements to match on. The special value "*" matches all local names.
                    this.importNode() // Imports a node from another document to this document, without altering or removing the source node from the original document; this method creates a new copy of the source node. Params: importedNode – The node to import. deep – If true, recursively import the subtree under the specified node; if false, import only the node itself, as explained above. This has no effect on nodes that cannot have any children, and on Attr, and EntityReference nodes.                    this.normalizeDocument()
                    this.renameNode() // Rename an existing node of type ELEMENT_NODE or ATTRIBUTE_NODE. When possible this simply changes the name of the given node, otherwise this creates a new node with the specified name and replaces the existing node with the new node as described below. Params: n – The node to rename. namespaceURI – The new namespace URI. qualifiedName – The new qualified name.
                }
                this.loadWorker.run {
                    // A Worker is an object which performs some work in one or more background threads, and who's state is observable and available to JavaFX applications and is usable from the main JavaFX Application thread. This interface is primarily implemented by both Task and Service, providing a common API among both classes which makes it easier for libraries and frameworks to provide workers which work well when developing user interfaces.
                    this.exception.run {
                        // The Throwable class is the superclass of all errors and exceptions in the Java language.
                        this.localizedMessage // just put those methods in without showing any description.
                        this.stackTrace
                        this.suppressed
                        this.cause
                        this.message
                        this.addSuppressed()
                        this.fillInStackTrace()
                        this.initCause()
                        this.printStackTrace()
                    }
                    this.isRunning // True if the state is either SCHEDULED or RUNNING. When binding a Worker to a javafx.scene.control.ProgressIndicator, you will typically bind the visibility of the ProgressIndicator to the Worker's running property, and the progress of the ProgressIndicator to the Worker's progress property.
                    this.message // Gets a message associated with the current state of this Worker. This may be something such as "Processing image 1 of 3", for example.
                    this.progress // Indicates the current progress of this Worker in terms of percent complete. A value between zero and one indicates progress toward completion.
                    this.state // Specifies the current state of this Worker. The initial value is State.READY. A Task may be restarted, in which case it will progress from one of these end states (SUCCEEDED, CANCELLED, or FAILED) back to READY and then immediately to SCHEDULED and RUNNING.
                    this.title // An optional title that should be associated with this Worker. This may be something such as "Modifying Images".
                    this.totalWork // Indicates a maximum value for the workDoneProperty property. The totalWork will either be -1 (indicating that the amount of work to do is indeterminate), or it will be a non-zero value less than or equal to Double.MAX_VALUE.
                    this.value // Specifies the value, or result, of this Worker.
                    this.workDone // Indicates the current amount of work that has been completed. Zero or a positive value indicate progress toward completion.
                    this.cancel() // Terminates execution of this Worker. Calling this method will either remove this Worker from the execution queue or stop execution.
                }
                this.location // Returns URL of the current Web page. If the current page has no URL, returns an empty String.
                this.onAlert // Returns the JavaScript alert handler.
                this.onError // The event handler called when an error occurs.
                this.onResized // Returns the JavaScript window resize handler.
                this.onStatusChanged // Returns the JavaScript status handler.
                this.onVisibilityChanged // Returns the JavaScript window visibility handler.
                this.title // Returns title of the current Web page. If the current page has no title, returns null.
                this.userAgent // Specifies user agent ID string. This string is the value of the User-Agent HTTP header.
                this.userDataDirectory // Specifies the directory to be used by this WebEngine to store local user data.
                this.userStyleSheetLocation // Location of the user stylesheet as a string URL. This should be a local URL, i.e. either 'data:', 'file:', or 'jar:'. Remote URLs are not allowed for security reasons.
                this.executeScript() // Executes a script in the context of the current page.
                this.load() // Loads a Web page into this engine. This method starts asynchronous loading and returns immediately. Params: url – URL of the web page to load
                this.loadContent() // Loads the given content directly. This method is useful when you have content composed in memory, or loaded from some system which cannot be reached via a URL (for example, the SVG text may have come from a database).
                this.print() // Prints the current Web page using the given printer job. This method does not modify the state of the job, nor does it call PrinterJob.endJob, so the job may be safely reused afterwards. Params: job – printer job used for printing
                this.reload() // Reloads the current page, whether loaded from URL or directly from a String in one of the loadContent methods.
            }
        }
    }
}
