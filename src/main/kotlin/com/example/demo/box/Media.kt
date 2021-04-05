package com.example.demo

import javafx.stage.FileChooser
import javafx.stage.Stage
import javafx.scene.Scene
import java.net.MalformedURLException
import javafx.scene.layout.BorderPane
import javafx.scene.media.MediaView
import javafx.scene.layout.Pane
import javafx.application.Platform
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.beans.InvalidationListener
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.paint.Color
import tornadofx.App
import tornadofx.launch
import java.nio.file.Paths

// Java program to Build a Media
// Player in JavaFX
// launches the application
@Suppress("NAME_SHADOWING")
fun main() {
    launch<Main>()
}
@Suppress("NAME_SHADOWING")
internal class Main : App() {
    var player: Player? = null
    var fileChooser: FileChooser? = null
    override fun start(stage: Stage) {
        // setting up the stages
        val open = MenuItem("Open")
        val file = Menu("File")
        val menu = MenuBar()

        // Connecting the above three
        file.items.add(open) // it would connect open with file
        menu.menus.add(file)

        // Adding functionality to switch to different videos
        fileChooser = FileChooser()
        open.onAction = EventHandler { // Pausing the video while switching
            player!!.player.pause()
            val file = fileChooser!!.showOpenDialog(stage)

            // Choosing the file to play
            if (file != null) {
                try {
                    player = Player(file.toURI().toURL().toExternalForm())
                    val scene = Scene(player, 720.0, 535.0, Color.BLACK)
                    stage.scene = scene
                } catch (e1: MalformedURLException) {
                    e1.printStackTrace()
                }
            }
        }

        // here you can choose any video
        player = Player(Paths.get("Coldplay-Flags.mp3").toUri().toString())

        // Setting the menu at the top
        player!!.top = menu

        // Adding player to the Scene
        val scene = Scene(player, 720.0, 535.0, Color.BLACK)

        // height and width of the video player
        // background color set to Black
        stage.scene = scene // Setting the scene to stage
        stage.show() // Showing the stage
    }
}

internal class Player(file: String?) : BorderPane() // Player class extend BorderPane
// in order to divide the media
// player into regions
{
    var media = Media(file)
    var player: MediaPlayer = MediaPlayer(media)
    var view: MediaView = MediaView(player)
    var mpane: Pane = Pane()
    var bar: MediaBar

    init { // Default constructor
        mpane.children.add(view) // Calling the function getChildren

        // inorder to addUser the view
        center = mpane
        bar = MediaBar(player) // Passing the player to MediaBar
        bottom = bar // Setting the MediaBar at bottom
        style = "-fx-background-color:#bfc2c7" // Adding color to the mediabar
        player.play() // Making the video play
    }
}

internal open class MediaBar(var player: MediaPlayer) : HBox() {
    // MediaBar extends Horizontal Box
    // introducing Sliders
    private var time = Slider() // Slider for time
    var vol = Slider() // Slider for volume
    private var PlayButton = Button("||") // For pausing the player
    var volume = Label("Volume: ")

    // Outside the constructor
    private fun updatesValues() {
        Platform.runLater {
            // Updating to the new time value
            // This will move the slider while running your video
            time.value =
                player.currentTime.toMillis() /
                player.totalDuration.toMillis() * 100
        }
    }

    init { // Default constructor taking
        // the MediaPlayer object
        alignment = Pos.CENTER // setting the HBox to center
        padding = Insets(5.0, 10.0, 5.0, 10.0)
        // Settih the preference for volume bar
        vol.prefWidth = 70.0
        vol.minWidth = 30.0
        vol.value = 100.0
        setHgrow(time, Priority.ALWAYS)
        PlayButton.prefWidth = 30.0

        // Adding the components to the bottom
        children.add(PlayButton) // Playbutton
        children.add(time) // time slider
        children.add(volume) // volume slider
        children.add(vol)

        // Adding Functionality
        // to play the media player
        PlayButton.onAction = EventHandler {
            val status = player.status // To get the status of Player
            if (status == MediaPlayer.Status.PLAYING) {

                // If the status is Video playing
                if (player.currentTime.greaterThanOrEqualTo(player.totalDuration)) {

                    // If the player is at the end of video
                    player.seek(player.startTime) // Restart the video
                    player.play()
                } else {
                    // Pausing the player
                    player.pause()
                    PlayButton.text = ">"
                }
            }
            // If the video is stopped, halted or paused
            if (status == MediaPlayer.Status.HALTED || status == MediaPlayer.Status.STOPPED || status == MediaPlayer.Status.PAUSED) {
                player.play() // Start the video
                PlayButton.text = "||"
            }
        }

        // Providing functionality to time slider
        player.currentTimeProperty().addListener(InvalidationListener { updatesValues() })

        // Inorder to jump to the certain part of video
        time.valueProperty().addListener(InvalidationListener {
            if (time.isPressed) { // It would set the time
                // as specified by user by pressing
                player.seek(player.media.duration.multiply(time.value / 100))
            }
        })

        // providing functionality to volume slider
        vol.valueProperty().addListener(InvalidationListener {
            if (vol.isPressed) {
                player.volume = vol.value / 100 // It would set the volume
                // as specified by user by pressing
            }
        })
    }
}