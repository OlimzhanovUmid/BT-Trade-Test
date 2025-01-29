package com.uolimzhanov.bttrade.cashRegister.presentation

import com.uolimzhanov.bttrade.cashRegister.domain.CartItem
import com.uolimzhanov.bttrade.cashRegister.domain.Product

sealed interface CashRegisterAction {
    data object OnFavoriteProductsClick : CashRegisterAction
    data object OnDiscountedProductsClick : CashRegisterAction
    data object OnSellClick: CashRegisterAction
    data class OnAddToCartClick(val product: Product) : CashRegisterAction
    data class OnIncreaseQuantityClick(val cartItem: CartItem) : CashRegisterAction
    data class OnDecreaseQuantityClick(val cartItem: CartItem) : CashRegisterAction
    data class OnRemoveFromCartClick(val cartItem: CartItem) : CashRegisterAction
    data class OnViewModeChange(val viewMode: ViewMode) : CashRegisterAction
}