WebView is a Node that manages a WebEngine and displays its content.
The associated `WebEngine` is created automatically at construction time and cannot be changed afterwards.
`WebView` handles mouse and some keyboard events, and manages scrolling automatically, so there's no need to put it into a `ScrollPane`.

Extensions    |    Property   |  Description
-------     |    -------    |   --------
`engine` | No | **Returns** the `WebEngine` object.
`fontScale` | `fontScaleProperty()` | Specifies scale factor applied to font. This setting affects text content but not images and fixed size elements.
`fontSmoothingType` | `fontSmoothingTypeProperty()` | Specifies a requested font smoothing type : `gray` or `LCD`. The width of the bounding box is defined by the widest row. _Note:_ `LCD` mode doesn't apply in numerous cases, such as various compositing modes, where effects are applied and very large glyphs.
`height` | `heightProperty()` | **Returns** height of this `WebView`.
`width` | `widthProperty()` | **Returns** width of this `WebView`.
`isContextMenuEnabled` | `contextMenuEnabledProperty()` | Specifies whether context menu is enabled.
`maxHeight` | `maxHeightProperty()` | **Returns** maximum height.
`maxWidth` | `maxWidthProperty()` | **Returns** maximum width.
`minHeight` | `minHeightProperty()` | Sets minimum height.
`minWidth` | `minWidthProperty()` | Sets minimum width.
`prefHeight` | `prefHeightProperty()` | **Returns** preferred height.
`prefWidth` | `prefWidthProperty()` | **Returns** preferred width.
`zoom` | `zoomProperty()` | **Returns** current zoom factor applied to the whole page contents. **Returns:** current zoom factor
`setMaxSize()` | No | Convenience method for setting maximum width and height.
`setMinSize()` | No | Convenience method for setting minimum width and height.
`setPrefSize()` | No | Convenience method for setting preferred width and height.

### `engine` Extensions.

`confirmHandler` | `confirmHandlerProperty()` | **Returns** the **JavaScript** confirm handler.
`createPopupHandler` | `createPopupHandlerProperty()` |**Returns** the **JavaScript** popup handler.
`document` | `documentProperty()` | **Returns** the document object for the current Web page. If the Web page failed to load, returns `null`.
`history` | No | **Returns** the session history object