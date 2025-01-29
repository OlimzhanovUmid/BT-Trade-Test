package com.uolimzhanov.bttrade.cashRegister.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uolimzhanov.bttrade.cashRegister.presentation.components.cart.CartList
import com.uolimzhanov.bttrade.cashRegister.presentation.components.product.ProductsGrid
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CashRegisterScreen(
    viewModel: CashRegisterViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle() // suddenly "by" doesn't work

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CartList(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            cartItems = state.value.cart,
            onAction = viewModel::onAction
        )
        ProductsGrid(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            products = state.value.allProducts,
            onAction = viewModel::onAction
        )
    }
}