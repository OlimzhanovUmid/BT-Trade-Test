package com.uolimzhanov.bttrade.shop.presentation

sealed interface ShopAction {
    data object CloseShift : ShopAction
}