package com.uolimzhanov.bttrade.cashRegister.domain

data class Product(
    val id: Int,
    val name: String,
    val price: Long,
    val hasDiscount: Boolean,
    val isFavorite: Boolean,
    val discountPercent: Int?,
    val priceWithDiscount: Long?,
    val quantityInStock: Int,
    val unitType: String,
    val image: String
)