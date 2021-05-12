
import javafx.geometry.Orientation
import org.controlsfx.glyphfont.FontAwesome
import org.controlsfx.glyphfont.Glyph
import org.controlsfx.glyphfont.GlyphFont
import org.controlsfx.glyphfont.GlyphFontRegistry
import tornadofx.*


fun main() = launch<MainApp>()
class SymbolsApp: App(MainView::class)

class SymbolsView: View() {
    private val fontAwesome = GlyphFontRegistry.font("FontAwesome")
    override val root = scrollpane {
        vbox {
            kotlin.runCatching {
                (0..ss.size).forEach {
                    button(ss[it].first,fontAwesome.create(ss[it].second))
                }
            }
        }
    }
}
val ss = listOf(
    "ADJUST" to ('\uf042'),
    "ADN" to ('\uf170'),
    "ALIGN_CENTER" to ('\uf037'),
    "ALIGN_JUSTIFY" to ('\uf039'),
    "ALIGN_LEFT" to ('\uf036'),
    "ALIGN_RIGHT" to ('\uf038'),
    "AMBULANCE" to ('\uf0f9'),
    "ANCHOR" to ('\uf13d'),
    "ANDROID" to ('\uf17b'),
    "ANGELLIST" to ('\uf209'),
    "ANGLE_DOUBLE_DOWN" to ('\uf103'),
    "ANGLE_DOUBLE_LEFT" to ('\uf100'),
    "ANGLE_DOUBLE_RIGHT" to ('\uf101'),
    "ANGLE_DOUBLE_UP" to ('\uf102'),
    "ANGLE_DOWN" to ('\uf107'),
    "ANGLE_LEFT" to ('\uf104'),
    "ANGLE_RIGHT" to ('\uf105'),
    "ANGLE_UP" to ('\uf106'),
    "APPLE" to ('\uf179'),
    "ARCHIVE" to ('\uf187'),
    "AREA_CHART" to ('\uf1fe'),
    "ARROW_CIRCLE_DOWN" to ('\uf0ab'),
    "ARROW_CIRCLE_LEFT" to ('\uf0a8'),
    "ARROW_CIRCLE_O_DOWN" to ('\uf01a'),
    "ARROW_CIRCLE_O_LEFT" to ('\uf190'),
    "ARROW_CIRCLE_O_RIGHT" to ('\uf18e'),
    "ARROW_CIRCLE_O_UP" to ('\uf01b'),
    "ARROW_CIRCLE_RIGHT" to ('\uf0a9'),
    "ARROW_CIRCLE_UP" to ('\uf0aa'),
    "ARROW_DOWN" to ('\uf063'),
    "ARROW_LEFT" to ('\uf060'),
    "ARROW_RIGHT" to ('\uf061'),
    "ARROW_UP" to ('\uf062'),
    "ARROWS" to ('\uf047'),
    "ARROWS_ALT" to ('\uf0b2'),
    "ARROWS_H" to ('\uf07e'),
    "ARROWS_V" to ('\uf07d'),
    "ASTERISK" to ('\uf069'),
    "AT" to ('\uf1fa'),
    "AUTOMOBILE" to ('\uf1b9'),
    "BACKWARD" to ('\uf04a'),
    "BAN" to ('\uf05e'),
    "BANK" to ('\uf19c'),
    "BAR_CHART" to ('\uf080'),
    "BAR_CHART_O" to ('\uf080'),
    "BARCODE" to ('\uf02a'),
    "BARS" to ('\uf0c9'),
    "BED" to ('\uf236'),
    "BEER" to ('\uf0fc'),
    "BEHANCE" to ('\uf1b4'),
    "BEHANCE_SQUARE" to ('\uf1b5'),
    "BELL" to ('\uf0f3'),
    "BELL_O" to ('\uf0a2'),
    "BELL_SLASH" to ('\uf1f6'),
    "BELL_SLASH_O" to ('\uf1f7'),
    "BICYCLE" to ('\uf206'),
    "BINOCULARS" to ('\uf1e5'),
    "BIRTHDAY_CAKE" to ('\uf1fd'),
    "BITBUCKET" to ('\uf171'),
    "BITBUCKET_SQUARE" to ('\uf172'),
    "BITCOIN" to ('\uf15a'),
    "BOLD" to ('\uf032'),
    "BOLT" to ('\uf0e7'),
    "BOMB" to ('\uf1e2'),
    "BOOK" to ('\uf02d'),
    "BOOKMARK" to ('\uf02e'),
    "BOOKMARK_ALT" to ('\uf097'),
    "BRIEFCASE" to ('\uf0b1'),
    "BTC" to ('\uf15a'),
    "BUG" to ('\uf188'),
    "BUILDING" to ('\uf1ad'),
    "BUILDING_ALT" to ('\uf0f7'),
    "BULLHORN" to ('\uf0a1'),
    "BULLSEYE" to ('\uf140'),
    "BUS" to ('\uf207'),
    "BUYSELLADS" to ('\uf20d'),
    "CAB" to ('\uf1ba'),
    "CALCULATOR" to ('\uf1ec'),
    "CALENDAR" to ('\uf073'),
    "CALENDAR_ALT" to ('\uf133'),
    "CAMERA" to ('\uf030'),
    "CAMERA_RETRO" to ('\uf083'),
    "CAR" to ('\uf1b9'),
    "CARET_DOWN" to ('\uf0d7'),
    "CARET_LEFT" to ('\uf0d9'),
    "CARET_RIGHT" to ('\uf0da'),
    "CARET_SQUARE_ALT_DOWN" to ('\uf150'),
    "CARET_SQUARE_ALT_LEFT" to ('\uf191'),
    "CARET_SQUARE_ALT_RIGHT" to ('\uf152'),
    "CARET_SQUARE_ALT_UP" to ('\uf151'),
    "CARET_UP" to ('\uf0d8'),
    "CART_ARROW_DOWN" to ('\uf218'),
    "CART_PLUS" to ('\uf217'),
    "CC" to ('\uf20a'),
    "CC_AMEX" to ('\uf1f3'),
    "CC_DISCOVER" to ('\uf1f2'),
    "CC_MASTERCARD" to ('\uf1f1'),
    "CC_PAYPAL" to ('\uf1f4'),
    "CC_STRIPE" to ('\uf1f5'),
    "CC_VISA" to ('\uf1f0'),
    "CERTIFICATE" to ('\uf0a3'),
    "CHAIN" to ('\uf0c1'),
    "CHAIN_BROKEN" to ('\uf127'),
    "CHECK" to ('\uf00c'),
    "CHECK_CIRCLE" to ('\uf058'),
    "CHECK_CIRCLE_ALT" to ('\uf05d'),
    "CHECK_SQUARE" to ('\uf14a'),
    "CHECK_SQUARE_ALT" to ('\uf046'),
    "CHEVRON_CIRCLE_DOWN" to ('\uf13a'),
    "CHEVRON_CIRCLE_LEFT" to ('\uf137'),
    "CHEVRON_CIRCLE_RIGHT" to ('\uf138'),
    "CHEVRON_CIRCLE_UP" to ('\uf139'),
    "CHEVRON_DOWN" to ('\uf078'),
    "CHEVRON_LEFT" to ('\uf053'),
    "CHEVRON_RIGHT" to ('\uf054'),
    "CHEVRON_UP" to ('\uf077'),
    "CHILD" to ('\uf1ae'),
    "CIRCLE" to ('\uf111'),
    "CIRCLE_ALT" to ('\uf10c'),
    "CIRCLE_ALT_NOTCH" to ('\uf1ce'),
    "CIRCLE_THIN" to ('\uf1db'),
    "CLIPBOARD" to ('\uf0ea'),
    "CLOCK_ALT" to ('\uf017'),
    "CLOSE" to ('\uf00d'),
    "CLOUD" to ('\uf0c2'),
    "CLOUD_DOWNLOAD" to ('\uf0ed'),
    "CLOUD_UPLOAD" to ('\uf0ee'),
    "CNY" to ('\uf157'),
    "CODE" to ('\uf121'),
    "CODE_FORK" to ('\uf126'),
    "CODEPEN" to ('\uf1cb'),
    "COFFEE" to ('\uf0f4'),
    "COG" to ('\uf013'),
    "COGS" to ('\uf085'),
    "COLUMNS" to ('\uf0db'),
    "COMMENT" to ('\uf075'),
    "COMMENT_ALT" to ('\uf0e5'),
    "COMMENTS" to ('\uf086'),
    "COMMENTS_ALT" to ('\uf0e6'),
    "COMPASS" to ('\uf14e'),
    "COMPRESS" to ('\uf066'),
    "CONNECTDEVELOP" to ('\uf20e'),
    "COPY" to ('\uf0c5'),
    "COPYRIGHT" to ('\uf1f9'),
    "CREDIT_CARD" to ('\uf09d'),
    "CROP" to ('\uf125'),
    "CROSSHAIRS" to ('\uf05b'),
    "CSS3" to ('\uf13c'),
    "CUBE" to ('\uf1b2'),
    "CUBES" to ('\uf1b3'),
    "CUT" to ('\uf0c4'),
    "CUTLERY" to ('\uf0f5'),
    "DASHBOARD" to ('\uf0e4'),
    "DASHCUBE" to ('\uf210'),
    "DATABASE" to ('\uf1c0'),
    "DEDENT" to ('\uf03b'),
    "DELICIOUS" to ('\uf1a5'),
    "DESKTOP" to ('\uf108'),
    "DEVIANTART" to ('\uf1bd'),
    "DIAMOND" to ('\uf219'),
    "DIGG" to ('\uf1a6'),
    "DOLLAR" to ('\uf155'),
    "DOT_CIRCLE_ALT" to ('\uf192'),
    "DOWNLOAD" to ('\uf019'),
    "DRIBBBLE" to ('\uf17d'),
    "DROPBOX" to ('\uf16b'),
    "DRUPAL" to ('\uf1a9'),
    "EDIT" to ('\uf044'),
    "EJECT" to ('\uf052'),
    "ELLIPSIS_H" to ('\uf141'),
    "ELLIPSIS_V" to ('\uf142'),
    "EMPIRE" to ('\uf1d1'),
    "ENVELOPE" to ('\uf0e0'),
    "ENVELOPE_ALT" to ('\uf003'),
    "ENVELOPE_SQUARE" to ('\uf199'),
    "ERASER" to ('\uf12d'),
    "EUR" to ('\uf153'),
    "EURO" to ('\uf153'),
    "EXCHANGE" to ('\uf0ec'),
    "EXCLAMATION" to ('\uf12a'),
    "EXCLAMATION_CIRCLE" to ('\uf06a'),
    "EXCLAMATION_TRIANGLE" to ('\uf071'),
    "EXPAND" to ('\uf065'),
    "EXTERNAL_LINK" to ('\uf08e'),
    "EXTERNAL_LINK_SQUARE" to ('\uf14c'),
    "EYE" to ('\uf06e'),
    "EYE_SLASH" to ('\uf070'),
    "EYEDROPPER" to ('\uf1fb'),
    "FACEBOOK" to ('\uf09a'),
    "FACEBOOK_F" to ('\uf09a'),
    "FACEBOOK_ALTFFICIAL" to ('\uf230'),
    "FACEBOOK_SQUARE" to ('\uf082'),
    "FAST_BACKWARD" to ('\uf049'),
    "FAST_FORWARD" to ('\uf050'),
    "FAX" to ('\uf1ac'),
    "FEMALE" to ('\uf182'),
    "FIGHTER_JET" to ('\uf0fb'),
    "FILE" to ('\uf15b'),
    "FILE_ARCHIVE_ALT" to ('\uf1c6'),
    "FILE_AUDIO_ALT" to ('\uf1c7'),
    "FILE_CODE_ALT" to ('\uf1c9'),
    "FILE_EXCEL_ALT" to ('\uf1c3'),
    "FILE_IMAGE_ALT" to ('\uf1c5'),
    "FILE_MOVIE_ALT" to ('\uf1c8'),
    "FILE_ALT" to ('\uf016'),
    "FILE_PDF_ALT" to ('\uf1c1'),
    "FILE_PHOTO_ALT" to ('\uf1c5'),
    "FILE_PICTURE_ALT" to ('\uf1c5'),
    "FILE_POWERPOINT_ALT" to ('\uf1c4'),
    "FILE_SOUND_ALT" to ('\uf1c7'),
    "FILE_TEXT" to ('\uf15c'),
    "FILE_TEXT_ALT" to ('\uf0f6'),
    "FILE_VIDEO_ALT" to ('\uf1c8'),
    "FILE_WORD_ALT" to ('\uf1c2'),
    "FILE_ZIP_ALT" to ('\uf1c6'),
    "FILES_ALT" to ('\uf0c5'),
    "FILM" to ('\uf008'),
    "FILTER" to ('\uf0b0'),
    "FIRE" to ('\uf06d'),
    "FIRE_EXTINGUISHER" to ('\uf134'),
    "FLAG" to ('\uf024'),
    "FLAG_CHECKERED" to ('\uf11e'),
    "FLAG_ALT" to ('\uf11d'),
    "FLASH" to ('\uf0e7'),
    "FLASK" to ('\uf0c3'),
    "FLICKR" to ('\uf16e'),
    "FLOPPY_ALT" to ('\uf0c7'),
    "FOLDER" to ('\uf07b'),
    "FOLDER_ALT" to ('\uf114'),
    "FOLDER_OPEN" to ('\uf07c'),
    "FOLDER_OPEN_ALT" to ('\uf115'),
    "FONT" to ('\uf031'),
    "FORUMBEE" to ('\uf211'),
    "FORWARD" to ('\uf04e'),
    "FOURSQUARE" to ('\uf180'),
    "FROWN_ALT" to ('\uf119'),
    "FUTBOL_ALT" to ('\uf1e3'),
    "GAMEPAD" to ('\uf11b'),
    "GAVEL" to ('\uf0e3'),
    "GBP" to ('\uf154'),
    "GE" to ('\uf1d1'),
    "GEAR" to ('\uf013'),
    "GEARS" to ('\uf085'),
    "GENDERLESS" to ('\uf1db'),
    "GIFT" to ('\uf06b'),
    "GIT" to ('\uf1d3'),
    "GIT_SQUARE" to ('\uf1d2'),
    "GITHUB" to ('\uf09b'),
    "GITHUB_ALT" to ('\uf113'),
    "GITHUB_SQUARE" to ('\uf092'),
    "GITTIP" to ('\uf184'),
    "GLASS" to ('\uf000'),
    "GLOBE" to ('\uf0ac'),
    "GOOGLE" to ('\uf1a0'),
    "GOOGLE_PLUS" to ('\uf0d5'),
    "GOOGLE_PLUS_SQUARE" to ('\uf0d4'),
    "GOOGLE_WALLET" to ('\uf1ee'),
    "GRADUATION_CAP" to ('\uf19d'),
    "GRATIPAY" to ('\uf184'),
    "GROUP" to ('\uf0c0'),
    "H_SQUARE" to ('\uf0fd'),
    "HACKER_NEWS" to ('\uf1d4'),
    "HAND_ALT_DOWN" to ('\uf0a7'),
    "HAND_ALT_LEFT" to ('\uf0a5'),
    "HAND_ALT_RIGHT" to ('\uf0a4'),
    "HAND_ALT_UP" to ('\uf0a6'),
    "HDD_ALT" to ('\uf0a0'),
    "HEADER" to ('\uf1dc'),
    "HEADPHONES" to ('\uf025'),
    "HEART" to ('\uf004'),
    "HEART_ALT" to ('\uf08a'),
    "HEARTBEAT" to ('\uf21e'),
    "HISTORY" to ('\uf1da'),
    "HOME" to ('\uf015'),
    "HOSPITAL_ALT" to ('\uf0f8'),
    "HOTEL" to ('\uf236'),
    "HTML5" to ('\uf13b'),
    "ILS" to ('\uf20b'),
    "IMAGE" to ('\uf03e'),
    "INBOX" to ('\uf01c'),
    "INDENT" to ('\uf03c'),
    "INFO" to ('\uf129'),
    "INFO_CIRCLE" to ('\uf05a'),
    "INR" to ('\uf156'),
    "INSTAGRAM" to ('\uf16d'),
    "INSTITUTION" to ('\uf19c'),
    "IOXHOST" to ('\uf208'),
    "ITALIC" to ('\uf033'),
    "JOOMLA" to ('\uf1aa'),
    "JPY" to ('\uf157'),
    "JSFIDDLE" to ('\uf1cc'),
    "KEY" to ('\uf084'),
    "KEYBOARD_ALT" to ('\uf11c'),
    "KRW" to ('\uf159'),
    "LANGUAGE" to ('\uf1ab'),
    "LAPTOP" to ('\uf109'),
    "LASTFM" to ('\uf202'),
    "LASTFM_SQUARE" to ('\uf203'),
    "LEAF" to ('\uf06c'),
    "LEANPUB" to ('\uf212'),
    "LEGAL" to ('\uf0e3'),
    "LEMON_ALT" to ('\uf094'),
    "LEVEL_DOWN" to ('\uf149'),
    "LEVEL_UP" to ('\uf148'),
    "LIFE_BOUY" to ('\uf1cd'),
    "LIFE_BUOY" to ('\uf1cd'),
    "LIFE_RING" to ('\uf1cd'),
    "LIFE_SAVER" to ('\uf1cd'),
    "LIGHTBULB_ALT" to ('\uf0eb'),
    "LINE_CHART" to ('\uf201'),
    "LINK" to ('\uf0c1'),
    "LINKEDIN" to ('\uf0e1'),
    "LINKEDIN_SQUARE" to ('\uf08c'),
    "LINUX" to ('\uf17c'),
    "LIST" to ('\uf03a'),
    "LIST_ALT" to ('\uf022'),
    "LIST_OL" to ('\uf0cb'),
    "LIST_UL" to ('\uf0ca'),
    "LOCATION_ARROW" to ('\uf124'),
    "LOCK" to ('\uf023'),
    "LONG_ARROW_DOWN" to ('\uf175'),
    "LONG_ARROW_LEFT" to ('\uf177'),
    "LONG_ARROW_RIGHT" to ('\uf178'),
    "LONG_ARROW_UP" to ('\uf176'),
    "MAGIC" to ('\uf0d0'),
    "MAGNET" to ('\uf076'),
    "MAIL_FORWARD" to ('\uf064'),
    "MAIL_REPLY" to ('\uf112'),
    "MAIL_REPLY_ALL" to ('\uf122'),
    "MALE" to ('\uf183'),
    "MAP_MARKER" to ('\uf041'),
    "MARS" to ('\uf222'),
    "MARS_DOUBLE" to ('\uf227'),
    "MARS_STROKE" to ('\uf229'),
    "MARS_STROKE_H" to ('\uf22b'),
    "MARS_STROKE_V" to ('\uf22a'),
    "MAXCDN" to ('\uf136'),
    "MEANPATH" to ('\uf20c'),
    "MEDIUM" to ('\uf23a'),
    "MEDKIT" to ('\uf0fa'),
    "MEH_ALT" to ('\uf11a'),
    "MERCURY" to ('\uf223'),
    "MICROPHONE" to ('\uf130'),
    "MICROPHONE_SLASH" to ('\uf131'),
    "MINUS" to ('\uf068'),
    "MINUS_CIRCLE" to ('\uf056'),
    "MINUS_SQUARE" to ('\uf146'),
    "MINUS_SQUARE_ALT" to ('\uf147'),
    "MOBILE" to ('\uf10b'),
    "MOBILE_PHONE" to ('\uf10b'),
    "MONEY" to ('\uf0d6'),
    "MOON_ALT" to ('\uf186'),
    "MORTAR_BOARD" to ('\uf19d'),
    "MOTORCYCLE" to ('\uf21c'),
    "MUSIC" to ('\uf001'),
    "NAVICON" to ('\uf0c9'),
    "NEUTER" to ('\uf22c'),
    "NEWSPAPER_ALT" to ('\uf1ea'),
    "OPENID" to ('\uf19b'),
    "OUTDENT" to ('\uf03b'),
    "PAGELINES" to ('\uf18c'),
    "PAINT_BRUSH" to ('\uf1fc'),
    "PAPER_PLANE" to ('\uf1d8'),
    "PAPER_PLANE_ALT" to ('\uf1d9'),
    "PAPERCLIP" to ('\uf0c6'),
    "PARAGRAPH" to ('\uf1dd'),
    "PASTE" to ('\uf0ea'),
    "PAUSE" to ('\uf04c'),
    "PAW" to ('\uf1b0'),
    "PAYPAL" to ('\uf1ed'),
    "PENCIL" to ('\uf040'),
    "PENCIL_SQUARE" to ('\uf14b'),
    "PENCIL_SQUARE_ALT" to ('\uf044'),
    "PHONE" to ('\uf095'),
    "PHONE_SQUARE" to ('\uf098'),
    "PHOTO" to ('\uf03e'),
    "PICTURE_ALT" to ('\uf03e'),
    "PIE_CHART" to ('\uf200'),
    "PIED_PIPER" to ('\uf1a7'),
    "PIED_PIPER_ALT" to ('\uf1a8'),
    "PINTEREST" to ('\uf0d2'),
    "PINTEREST_P" to ('\uf231'),
    "PINTEREST_SQUARE" to ('\uf0d3'),
    "PLANE" to ('\uf072'),
    "PLAY" to ('\uf04b'),
    "PLAY_CIRCLE" to ('\uf144'),
    "PLAY_CIRCLE_ALT" to ('\uf01d'),
    "PLUG" to ('\uf1e6'),
    "PLUS" to ('\uf067'),
    "PLUS_CIRCLE" to ('\uf055'),
    "PLUS_SQUARE" to ('\uf0fe'),
    "PLUS_SQUARE_ALT" to ('\uf196'),
    "POWER_OFF" to ('\uf011'),
    "PRINT" to ('\uf02f'),
    "PUZZLE_PIECE" to ('\uf12e'),
    "QQ" to ('\uf1d6'),
    "QRCODE" to ('\uf029'),
    "QUESTION" to ('\uf128'),
    "QUESTION_CIRCLE" to ('\uf059'),
    "QUOTE_LEFT" to ('\uf10d'),
    "QUOTE_RIGHT" to ('\uf10e'),
    "RA" to ('\uf1d0'),
    "RANDOM" to ('\uf074'),
    "REBEL" to ('\uf1d0'),
    "RECYCLE" to ('\uf1b8'),
    "REDDIT" to ('\uf1a1'),
    "REDDIT_SQUARE" to ('\uf1a2'),
    "REFRESH" to ('\uf021'),
    "REMOVE" to ('\uf00d'),
    "RENREN" to ('\uf18b'),
    "REORDER" to ('\uf0c9'),
    "REPEAT" to ('\uf01e'),
    "REPLY" to ('\uf112'),
    "REPLY_ALL" to ('\uf122'),
    "RETWEET" to ('\uf079'),
    "RMB" to ('\uf157'),
    "ROAD" to ('\uf018'),
    "ROCKET" to ('\uf135'),
    "ROTATE_LEFT" to ('\uf0e2'),
    "ROTATE_RIGHT" to ('\uf01e'),
    "ROUBLE" to ('\uf158'),
    "RSS" to ('\uf09e'),
    "RSS_SQUARE" to ('\uf143'),
    "RUB" to ('\uf158'),
    "RUBLE" to ('\uf158'),
    "RUPEE" to ('\uf156'),
    "SAVE" to ('\uf0c7'),
    "SCISSORS" to ('\uf0c4'),
    "SEARCH" to ('\uf002'),
    "SEARCH_MINUS" to ('\uf010'),
    "SEARCH_PLUS" to ('\uf00e'),
    "SELLSY" to ('\uf213'),
    "SEND" to ('\uf1d8'),
    "SEND_ALT" to ('\uf1d9'),
    "SERVER" to ('\uf233'),
    "SHARE" to ('\uf064'),
    "SHARE_ALT" to ('\uf1e0'),
    "SHARE_ALT_SQUARE" to ('\uf1e1'),
    "SHARE_SQUARE" to ('\uf14d'),
    "SHARE_SQUARE_ALT" to ('\uf045'),
    "SHEKEL" to ('\uf20b'),
    "SHEQEL" to ('\uf20b'),
    "SHIELD" to ('\uf132'),
    "SHIP" to ('\uf21a'),
    "SHIRTSINBULK" to ('\uf214'),
    "SHOPPING_CART" to ('\uf07a'),
    "SIGN_IN" to ('\uf090'),
    "SIGN_OUT" to ('\uf08b'),
    "SIGNAL" to ('\uf012'),
    "SIMPLYBUILT" to ('\uf215'),
    "SITEMAP" to ('\uf0e8'),
    "SKYATLAS" to ('\uf216'),
    "SKYPE" to ('\uf17e'),
    "SLACK" to ('\uf198'),
    "SLIDERS" to ('\uf1de'),
    "SLIDESHARE" to ('\uf1e7'),
    "SMILE_ALT" to ('\uf118'),
    "SOCCER_BALL_ALT" to ('\uf1e3'),
    "SORT" to ('\uf0dc'),
    "SORT_ALPHA_ASC" to ('\uf15d'),
    "SORT_ALPHA_DESC" to ('\uf15e'),
    "SORT_AMOUNT_ASC" to ('\uf160'),
    "SORT_AMOUNT_DESC" to ('\uf161'),
    "SORT_ASC" to ('\uf0de'),
    "SORT_DESC" to ('\uf0dd'),
    "SORT_DOWN" to ('\uf0dd'),
    "SORT_NUMERIC_ASC" to ('\uf162'),
    "SORT_NUMERIC_DESC" to ('\uf163'),
    "SORT_UP" to ('\uf0de'),
    "SOUNDCLOUD" to ('\uf1be'),
    "SPACE_SHUTTLE" to ('\uf197'),
    "SPINNER" to ('\uf110'),
    "SPOON" to ('\uf1b1'),
    "SPOTIFY" to ('\uf1bc'),
    "SQUARE" to ('\uf0c8'),
    "SQUARE_ALT" to ('\uf096'),
    "STACK_EXCHANGE" to ('\uf18d'),
    "STACK_OVERFLOW" to ('\uf16c'),
    "STAR" to ('\uf005'),
    "STAR_HALF" to ('\uf089'),
    "STAR_HALF_EMPTY" to ('\uf123'),
    "STAR_HALF_FULL" to ('\uf123'),
    "STAR_HALF_ALT" to ('\uf123'),
    "STAR_ALT" to ('\uf006'),
    "STEAM" to ('\uf1b6'),
    "STEAM_SQUARE" to ('\uf1b7'),
    "STEP_BACKWARD" to ('\uf048'),
    "STEP_FORWARD" to ('\uf051'),
    "STETHOSCOPE" to ('\uf0f1'),
    "STOP" to ('\uf04d'),
    "STREET_VIEW" to ('\uf21d'),
    "STRIKETHROUGH" to ('\uf0cc'),
    "STUMBLEUPON" to ('\uf1a4'),
    "STUMBLEUPON_CIRCLE" to ('\uf1a3'),
    "SUBSCRIPT" to ('\uf12c'),
    "SUBWAY" to ('\uf239'),
    "SUITCASE" to ('\uf0f2'),
    "SUN_ALT" to ('\uf185'),
    "SUPERSCRIPT" to ('\uf12b'),
    "SUPPORT" to ('\uf1cd'),
    "TABLE" to ('\uf0ce'),
    "TABLET" to ('\uf10a'),
    "TACHOMETER" to ('\uf0e4'),
    "TAG" to ('\uf02b'),
    "TAGS" to ('\uf02c'),
    "TASKS" to ('\uf0ae'),
    "TAXI" to ('\uf1ba'),
    "TENCENT_WEIBO" to ('\uf1d5'),
    "TERMINAL" to ('\uf120'),
    "TEXT_HEIGHT" to ('\uf034'),
    "TEXT_WIDTH" to ('\uf035'),
    "TH" to ('\uf00a'),
    "TH_LARGE" to ('\uf009'),
    "TH_LIST" to ('\uf00b'),
    "THUMB_TACK" to ('\uf08d'),
    "THUMBS_DOWN" to ('\uf165'),
    "THUMBS_ALT_DOWN" to ('\uf088'),
    "THUMBS_ALT_UP" to ('\uf087'),
    "THUMBS_UP" to ('\uf164'),
    "TICKET" to ('\uf145'),
    "TIMES" to ('\uf00d'),
    "TIMES_CIRCLE" to ('\uf057'),
    "TIMES_CIRCLE_ALT" to ('\uf05c'),
    "TINT" to ('\uf043'),
    "TOGGLE_DOWN" to ('\uf150'),
    "TOGGLE_LEFT" to ('\uf191'),
    "TOGGLE_OFF" to ('\uf204'),
    "TOGGLE_ON" to ('\uf205'),
    "TOGGLE_RIGHT" to ('\uf152'),
    "TOGGLE_UP" to ('\uf151'),
    "TRAIN" to ('\uf238'),
    "TRANSGENDER" to ('\uf224'),
    "TRANSGENDER_ALT" to ('\uf225'),
    "TRASH" to ('\uf1f8'),
    "TRASH_ALT" to ('\uf014'),
    "TREE" to ('\uf1bb'),
    "TRELLO" to ('\uf181'),
    "TROPHY" to ('\uf091'),
    "TRUCK" to ('\uf0d1'),
    "TRY" to ('\uf195'),
    "TTY" to ('\uf1e4'),
    "TUMBLR" to ('\uf173'),
    "TUMBLR_SQUARE" to ('\uf174'),
    "TURKISH_LIRA" to ('\uf195'),
    "TWITCH" to ('\uf1e8'),
    "TWITTER" to ('\uf099'),
    "TWITTER_SQUARE" to ('\uf081'),
    "UMBRELLA" to ('\uf0e9'),
    "UNDERLINE" to ('\uf0cd'),
    "UNDO" to ('\uf0e2'),
    "UNIVERSITY" to ('\uf19c'),
    "UNLINK" to ('\uf127'),
    "UNLOCK" to ('\uf09c'),
    "UNLOCK_ALT" to ('\uf13e'),
    "UNSORTED" to ('\uf0dc'),
    "UPLOAD" to ('\uf093'),
    "USD" to ('\uf155'),
    "USER" to ('\uf007'),
    "USER_MD" to ('\uf0f0'),
    "USER_PLUS" to ('\uf234'),
    "USER_SECRET" to ('\uf21b'),
    "USER_TIMES" to ('\uf235'),
    "USERS" to ('\uf0c0'),
    "VENUS" to ('\uf221'),
    "VENUS_DOUBLE" to ('\uf226'),
    "VENUS_MARS" to ('\uf228'),
    "VIACOIN" to ('\uf237'),
    "VIDEO_CAMERA" to ('\uf03d'),
    "VIMEO_SQUARE" to ('\uf194'),
    "VINE" to ('\uf1ca'),
    "VK" to ('\uf189'),
    "VOLUME_DOWN" to ('\uf027'),
    "VOLUME_OFF" to ('\uf026'),
    "VOLUME_UP" to ('\uf028'),
    "WARNING" to ('\uf071'),
    "WECHAT" to ('\uf1d7'),
    "WEIBO" to ('\uf18a'),
    "WEIXIN" to ('\uf1d7'),
    "WHATSAPP" to ('\uf232'),
    "WHEELCHAIR" to ('\uf193'),
    "WIFI" to ('\uf1eb'),
    "WINDOWS" to ('\uf17a'),
    "WON" to ('\uf159'),
    "WORDPRESS" to ('\uf19a'),
    "WRENCH" to ('\uf0ad'),
    "XING" to ('\uf168'),
    "XING_SQUARE" to ('\uf169'),
    "YAHOO" to ('\uf19e'),
    "YELP" to ('\uf1e9'),
    "YEN" to ('\uf157'),
    "YOUTUBE" to ('\uf167'),
    "YOUTUBE_PLAY" to ('\uf16a'),
    "YOUTUBE_SQUARE" to ('\uf166')
)