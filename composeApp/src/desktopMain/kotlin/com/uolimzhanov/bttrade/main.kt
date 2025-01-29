package com.uolimzhanov.bttrade

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.uolimzhanov.bttrade.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            placement = WindowPlacement.Maximized
        ),
        title = "BT Trade Test",
    ) {
        App()
    }
}