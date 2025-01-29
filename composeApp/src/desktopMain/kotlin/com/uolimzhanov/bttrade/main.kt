package com.uolimzhanov.bttrade

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.uolimzhanov.bttrade.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "BT Trade Test",
    ) {
        App()
    }
}