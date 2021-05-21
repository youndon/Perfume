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
            engine.run { // WebEngine is a non-visual object capable of managing one Web page at a time. It loads Web pages, creates their document models, applies styles as necessary, and runs JavaScript on pages. It provides access to the document model of the current page, and enables two-way communication between a Java application and JavaScript code of the page.
                this.history.run { // The WebHistory class represents a session history associated with a WebEngine instance. A single instance of WebHistory for a particular web engine can be obtained through the WebEngine.getHistory() method. The history is basically a list of entries. Each entry represents a visited page and it provides access to relevant page info, such as URL, title, and the date the page was last visited. Entries in the list are arranged in the order in which the corresponding pages were visited from oldest to newest. The list can be obtained by using the getEntries() method. The history and the corresponding list of entries change as WebEngine navigates across the web. The list may expand or shrink depending on browser actions. These changes can be listened to by the ObservableList API that the list exposes. The index of the history entry associated with the currently visited page is represented by the currentIndexProperty. The current index can be used to navigate to any entry in the history by using the go(int) method. The maxSizeProperty() sets the maximum history size, which is the size of the history list.
                    this.currentIndex // Defines the index of the current Entry in the history. The current entry is the entry associated with the currently loaded page. The index belongs to the range of (index >= 0 && index < getEntries().size())
                    this.entries // Returns an unmodifiable observable list of all entries in the history.
                    this.maxSize // Defines the maximum size of the history list. If the list reaches its maximum and a new entry is added, the first entry is removed from the history.
                    this.go(0) // Navigates the web engine to the URL defined by the Entry object within the specified position relative to the current entry. Params: offset – a negative value specifies a position preceding the current entry, a positive value specifies a position following the current entry, zero value causes no effect
                }
                this.document.run { // The Document interface represents the entire HTML or XML document. Conceptually, it is the root of the document tree, and provides the primary access to the document's data. Since elements, text nodes, comments, processing instructions, etc. cannot exist outside the context of a Document, the Document interface also contains the factory methods needed to create these objects. The Node objects created have a ownerDocument attribute which associates them with the Document within whose context they were created.
                    this.doctype.run { // Each Document has a doctype attribute whose value is either null or a DocumentType object. The DocumentType interface in the DOM Core provides an interface to the list of entities that are defined for the document, and little else because the effect of namespaces and the various XML schema efforts on DTD representation are not clearly understood as of this writing.
                        this.entities.run { // Objects implementing the NamedNodeMap interface are used to represent collections of nodes that can be accessed by name. Note that NamedNodeMap does not inherit from NodeList; NamedNodeMaps are not maintained in any particular order. Objects contained in an object implementing NamedNodeMap may also be accessed by an ordinal index, but this is simply to allow convenient enumeration of the contents of a NamedNodeMap, and does not imply that the DOM specifies an order to these Nodes.
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
                    this.documentElement.run { // The Element interface represents an element in an HTML or XML document. Elements may have attributes associated with them; since the Element interface inherits from Node, the generic Node interface attribute attributes may be used to retrieve the set of all attributes for an element. There are methods on the Element interface to retrieve either an Attr object by name or an attribute value by name. In XML, where an attribute value may contain entity references, an Attr object should be retrieved to examine the possibly fairly complex sub-tree representing the attribute value. On the other hand, in HTML, where all attributes have simple string values, methods to directly access an attribute value can safely be used as a convenience.
                        this.schemaTypeInfo.run { // The TypeInfo interface represents a type referenced from Element or Attr nodes, specified in the schemas associated with the document. The type is a pair of a namespace URI and name properties, and depends on the document's schema.
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
                    this.domConfig.run { // The DOMConfiguration interface represents the configuration of a document and maintains a table of recognized parameters. Using the configuration, it is possible to change Document.normalizeDocument() behavior, such as replacing the CDATASection nodes with Text nodes or specifying the type of the schema that must be used when the validation of the Document is requested. DOMConfiguration objects are also used in [DOM Level 3 Load and Save ] in the DOMParser and DOMSerializer interfaces.
                        this.parameterNames // The list of the parameters supported by this DOMConfiguration object and for which at least one value can be set by the application. Note that this list can also contain parameter names defined outside this specification.
                        this.setParameter() // Set the value of a parameter. Params: name – The name of the parameter to set. value – The new value or null if the user wishes to unset the parameter. While the type of the value parameter is defined as DOMUserData, the object type must match the type defined by the definition of the parameter. For example, if the parameter is "error-handler", the value must be of type DOMErrorHandler.
                        this.getParameter() // Return the value of a parameter if known. Params: name – The name of the parameter.
                        this.canSetParameter() // Check if setting a parameter to a specific value is supported. Params: name – The name of the parameter to check. value – An object. if null, the returned value is true.
                    }
                    this.implementation.run { // The DOMImplementation interface provides a number of methods for performing operations that are independent of any particular instance of the document object model. ndependent of any particular instance of the document object model. See also the Document Object Model (DOM) Level 3 Core Specification .
                        this.getFeature() // This method returns a specialized object which implements the specialized APIs of the specified feature and version, as specified in DOM Features . The specialized object may also be obtained by using binding-specific casting methods but is not necessarily expected to, as discussed in . This method also allow the implementation to provide specialized objects which do not support the DOMImplementation interface. Params: feature – The name of the feature requested. Note that any plus sign "+" prepended to the name of the feature will be ignored since it is not significant in the context of this method. version – This is the version number of the feature to test.
                        this.hasFeature() // Test if the DOM implementation implements a specific feature and version, as specified in [DOM Features] . Params: feature – The name of the feature to test. version – This is the version number of the feature to test.
                        this.createDocument() // Params: namespaceURI – The namespace URI of the document element to create or null. qualifiedName – The qualified name of the document element to be created or null. doctype – The type of document to be created or null. When doctype is not null, its Node.ownerDocument attribute is set to the document being created. Returns: A new Document object with its document element. If the NamespaceURI, qualifiedName, and doctype are null, the returned Document is empty with no document element.
                        this.createDocumentType() // Creates an empty DocumentType node. Entity declarations and notations are not made available. Entity reference expansions and default attribute additions do not occur. Params: qualifiedName – The qualified name of the document type to be created. publicId – The external subset public identifier. systemId – The external subset system identifier.
                    }
                    this.inputEncoding
                    this.strictErrorChecking
                    this.xmlEncoding
                    this.xmlStandalone
                    this.xmlVersion
                    this.adoptNode()
                    this.createAttribute()
                    this.createAttributeNS()
                    this.createCDATASection()
                    this.createComment()
                    this.createDocumentFragment()
                    this.createElement()
                    this.createElementNS()
                    this.createEntityReference()
                    this.createProcessingInstruction()
                    this.createTextNode()
                    this.getElementById()
                    this.getElementsByTagName()
                    this.getElementsByTagNameNS()
                    this.importNode()
                    this.normalizeDocument()
                    this.renameNode()
                }
                this.createPopupHandler
                this.confirmHandler
                this.isJavaScriptEnabled
                this.loadWorker.run {
                    this.exception.run {
                        this.localizedMessage
                        this.stackTrace
                        this.suppressed
                        this.cause
                        this.message
                        this.addSuppressed()
                        this.fillInStackTrace()
                        this.initCause()
                        this.printStackTrace()
                    }
                    this.isRunning
                    this.message
                    this.progress
                    this.state
                    this.title
                    this.totalWork
                    this.value
                    this.workDone
                    this.cancel()
                }
                this.location
                this.onAlert
                this.onError
                this.onResized
                this.onStatusChanged
                this.onVisibilityChanged
                this.title
                this.userAgent
                this.userDataDirectory
                this.userStyleSheetLocation
                this.executeScript()
                this.load()
                this.loadContent()
                this.print()
                this.reload()
            }
        }
    }
}
