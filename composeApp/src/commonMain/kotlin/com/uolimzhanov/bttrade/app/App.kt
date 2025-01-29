package com.uolimzhanov.bttrade.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldLayout
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uolimzhanov.bttrade.cashRegister.presentation.CashRegisterScreen
import com.uolimzhanov.bttrade.core.presentation.lightGrayishBlue
import com.uolimzhanov.bttrade.di.allModules
import com.uolimzhanov.bttrade.shop.presentation.ShopTopAppBar
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() = KoinApplication(
    application = { modules(allModules) },
    content = {
        MaterialTheme {
            Surface(
                modifier = Modifier
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .fillMaxSize(),
                color = lightGrayishBlue
            ) {
                NavigationSuiteScaffoldLayout(
                    navigationSuite = {
                        AppNavigationRail()
                    },
                    layoutType = NavigationSuiteType.NavigationRail
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ShopTopAppBar()
                        CashRegisterScreen()
                    }
                }
            }
        }
    }
)