package com.uolimzhanov.bttrade

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "BT Trade Test",
    ) {
        App()
    }
}