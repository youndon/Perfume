package com.hegyi.botond.controllers

import com.example.demo.snakeGame.MyLogger.INFO
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.scene.input.KeyEvent
import java.util.prefs.Preferences

class SettingsViewController : GoBack() {
    private val backBtn: Button? = null
    private val upText: TextField? = null
    private val downText: TextField? = null
    private val rightText: TextField? = null
    private val leftText: TextField? = null
    private val scoreCheckBox: CheckBox? = null
    private val prefs: Preferences = Preferences.userRoot().node(SettingsViewController::class.java.name)
    private val UP = "UP"
    private val DOWN = "DOWN"
    private val RIGHT = "RIGHT"
    private val LEFT = "LEFT"

    // set the default controls
    private fun setDefCont() {
        prefs.put(UP, UP)
        prefs.put(DOWN, DOWN)
        prefs.put(RIGHT, RIGHT)
        prefs.put(LEFT, LEFT)
    }

    // set controls text
    private fun setContText() {
        upText!!.text = prefs[UP, ""]
        downText!!.text = prefs[DOWN, ""]
        rightText!!.text = prefs[RIGHT, ""]
        leftText!!.text = prefs[LEFT, ""]
    }

    private fun setCheckBox() {
        scoreCheckBox!!.isSelected = prefs.getBoolean("renderScore", true)
    }

    private fun setDefCheckBox() {
        prefs.putBoolean("renderScore", false)
    }

    // reset the controls to the default values
    fun reset() {
        setDefCont()
        setContText()
        setDefCheckBox()
        setCheckBox()
    }

    @FXML // this method is called every time when the user open the settings view
    fun initialize() {
        setContText()
        setCheckBox()
    }

    fun changeText(keyEvent: KeyEvent) {
        val textField = keyEvent.source as Node
        (textField as TextField).text = keyEvent.code.toString()
        if (textField.getId() == upText!!.id) {
            INFO("up stored " + keyEvent.code)
            prefs.put(UP, keyEvent.code.toString())
        } else {
            if (textField.getId() == downText!!.id) {
                INFO("down stored " + keyEvent.code)
                prefs.put(DOWN, keyEvent.code.toString())
            } else {
                if (textField.getId() == rightText!!.id) {
                    INFO("right stored " + keyEvent.code)
                    prefs.put(RIGHT, keyEvent.code.toString())
                } else {
                    if (textField.getId() == leftText!!.id) {
                        INFO("left stored: " + keyEvent.code)
                        prefs.put(LEFT, keyEvent.code.toString())
                    }
                }
            }
        }
    }

    fun check() {
        if (scoreCheckBox!!.isSelected) {
            INFO("is checked")
            prefs.putBoolean("renderScore", true)
        } else {
            INFO("unchecked")
            prefs.putBoolean("renderScore", false)
        }
    }

}