package com.uolimzhanov.bttrade.shop.presentation

data class ShopState(
    val shopName: String = "Magazin 1",
    val shopActiveUntil: String = "2024.05.29",
    val shiftOpenedAt: String = "10 декабря, 09:23",
    val employeeName: String = "Исмаилов Темур",
    val employeeInitials: String = "ИТ",
    val employeePosition: String = "Продавец"
)