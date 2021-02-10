package com.hegyi.botond.controllers

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import java.net.URL
import java.util.*
import java.util.prefs.Preferences

class InstructionDialogController : Initializable {
    @FXML
    private val rightLabel: Label? = null

    @FXML
    private val leftLabel: Label? = null

    @FXML
    private val upLabel: Label? = null

    @FXML
    private val downLabel: Label? = null
    override fun initialize(location: URL, resources: ResourceBundle) {
        val prefs = Preferences.userRoot().node(SettingsViewController::class.java.name)
        rightLabel!!.text = prefs["RIGHT", ""]
        leftLabel!!.text = prefs["LEFT", ""]
        upLabel!!.text = prefs["UP", ""]
        downLabel!!.text = prefs["DOWN", ""]
    }
}