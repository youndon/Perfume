WebView.
-------

WebView is a Node that manages a WebEngine and displays its content.
The associated `WebEngine` is created automatically at construction time and cannot be changed afterwards.
`WebView` handles mouse and some keyboard events, and manages scrolling automatically, so there's no need to put it into a `ScrollPane`.

Extensions    |    Property   |  Description
-------     |    -------    |   --------
[`engine`]() | No | **Returns** the `WebEngine` object.
`height` | `heightProperty()` | **Returns** height of this `WebView`.
`fontScale` | `fontScaleProperty()` | Specifies scale factor applied to font. This setting affects text content but not images and fixed size elements.
`fontSmoothingType` | `fontSmoothingTypeProperty()` | Specifies a requested font smoothing type : `gray` or `LCD`. The width of the bounding box is defined by the widest row. _Note:_ `LCD` mode doesn't apply in numerous cases, such as various compositing modes, where effects are applied and very large glyphs.
`width` | `widthProperty()` | **Returns** width of this `WebView`.
`isContextMenuEnabled` | `contextMenuEnabledProperty()` | Specifies whether context menu is enabled.
`maxHeight` | `maxHeightProperty()` | **Returns** maximum height.
`maxWidth` | `maxWidthProperty()` | **Returns** maximum width.
`minHeight` | `minHeightProperty()` | Sets minimum height.
`minWidth` | `minWidthProperty()` | Sets minimum width.
`prefHeight` | `prefHeightProperty()` | **Returns** preferred height.
`prefWidth` | `prefWidthProperty()` | **Returns** preferred width.
`zoom` | `zoomProperty()` | **Returns** current zoom factor applied to the whole page contents.
`setMaxSize()` | No | Convenience method for setting maximum width and height.
`setMinSize()` | No | Convenience method for setting minimum width and height.
`setPrefSize()` | No | Convenience method for setting preferred width and height.

### `engine` extensions.
WebEngine is a non-visual object capable of managing one Web page at a time. 
It loads Web pages, creates their document models, applies styles as necessary, and runs **JavaScript** on pages. 
It provides access to the document model of the current page,
and enables two-way communication between a Java application and **JavaScript** code of the page.

Extensions    |    Property   |  Description
-------     |    -------    |   --------
`history` | No | **Returns** the session history object.
`document` | `documentProperty()` | **Returns** the document object for the current Web page. 
createPopupHandler | createPopupHandlerProperty() | **Returns** the **JavaScript** popup handler, Check Also: setCreatePopupHandler{}.
confirmHandler | confirmHandlerProperty() | **Returns** the **JavaScript** confirm handler, Check Also: setConfirmHandler{}.
isJavaScriptEnabled | javaScriptEnabledProperty() | Specifies whether **JavaScript** execution is enabled. 



### `history` extensions.
The WebHistory class represents a session history associated with a WebEngine instance. 
A single instance of WebHistory for a particular web engine can be obtained through the WebEngine.getHistory() method.
The history is basically a list of entries. 
Each entry represents a visited page, and it provides access to relevant page info, such as URL, title, and the date the page was last visited.
Entries in the list are arranged in the order in which the corresponding pages were visited from oldest to newest.
The list can be obtained by using the getEntries() method.
The history and the corresponding list of entries change as WebEngine navigates across the web.
The list may expand or shrink depending on browser actions.
These changes can be listened to by the ObservableList API that the list exposes. 
The index of the history entry associated with the currently visited page is represented by the currentIndexProperty.
The current index can be used to navigate to any entry in the history by using the go(int) method.
The maxSizeProperty() sets the maximum history size, which is the size of the history list.

Extensions    |    Property   |  Description
-------     |    -------    |   --------
`currentIndex` | `currentIndexProperty()` | Defines the index of the current Entry in the history. The current entry is the entry associated with the currently loaded page. The index belongs to the range of `index >= 0 && index < getEntries().size()`.
`maxSize` | `maxSizeProperty()` | Defines the maximum size of the history list. If the list reaches its maximum and a new entry is added, the first entry is removed from the history.
`entries` | Yes | **Returns** an unmodifiable observable list of all entries in the history.
`go()` | No | Navigates the web engine to the URL defined by the Entry object within the specified position relative to the current entry. **Params:** `offset` – a negative value specifies a position preceding the current entry, a positive value specifies a position following the current entry, zero value causes no effect
                