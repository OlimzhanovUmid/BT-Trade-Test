package com.uolimzhanov.bttrade.app

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.bill_line
import bttradetest.composeapp.generated.resources.chevron_double_left
import bttradetest.composeapp.generated.resources.cog
import bttradetest.composeapp.generated.resources.collection
import bttradetest.composeapp.generated.resources.newspaper
import bttradetest.composeapp.generated.resources.presentation_chart_bar
import bttradetest.composeapp.generated.resources.support
import bttradetest.composeapp.generated.resources.user_group
import bttradetest.composeapp.generated.resources.warehouse
import com.uolimzhanov.bttrade.core.presentation.classicBlue
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppNavigationRail() {
    val selectedIndex by remember { mutableIntStateOf(0) }
    val screens = listOf(
        Screen(
            icon = painterResource(Res.drawable.newspaper),
            name = "Касса"
        ),
        Screen(
            icon = painterResource(Res.drawable.bill_line),
            name = "Журнал чеков"
        ),
        Screen(
            icon = painterResource(Res.drawable.user_group),
            name = "Клиенты"
        ),
        Screen(
            icon = painterResource(Res.drawable.presentation_chart_bar),
            name = "Аналитика"
        ),
        Screen(
            icon = painterResource(Res.drawable.collection),
            name = "Каталог товаров"
        ),
        Screen(
            icon = painterResource(Res.drawable.warehouse),
            name = "Склад"
        ),
        Screen(
            icon = painterResource(Res.drawable.support),
            name = "Помощь"
        ),
        Screen(
            icon = painterResource(Res.drawable.cog),
            name = "Настройки"
        ),
    )
    NavigationRail(
        header = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(Res.drawable.chevron_double_left),
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        containerColor = Color.White
    ) {
        screens.forEachIndexed { index, screen ->
            NavigationRailItem(
                selected = selectedIndex == index,
                icon = {
                    Icon(
                        painter = screen.icon,
                        tint = if (selectedIndex == index) classicBlue else Color.Gray,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = screen.name,
                        textAlign = TextAlign.Center,
                        color = if (selectedIndex == index) Color.Black else Color.Gray
                    )
                },
                onClick = {}
            )
        }
    }
}

data class Screen(
    val icon: Painter,
    val name: String
)