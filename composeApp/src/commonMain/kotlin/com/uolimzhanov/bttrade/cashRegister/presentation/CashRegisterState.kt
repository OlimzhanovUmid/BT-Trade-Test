package com.uolimzhanov.bttrade.cashRegister.presentation

import com.uolimzhanov.bttrade.cashRegister.domain.CartItem
import com.uolimzhanov.bttrade.cashRegister.domain.Product

data class CashRegisterState(
    val allProducts: List<Product> = emptyList(),
    val cart: List<CartItem> = emptyList(),
    val isLoading: Boolean = true,
    val currentViewMode: ViewMode = ViewMode.GRID
)