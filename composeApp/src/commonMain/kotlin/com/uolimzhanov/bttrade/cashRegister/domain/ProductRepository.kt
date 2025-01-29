package com.uolimzhanov.bttrade.cashRegister.domain

import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts(): Flow<List<Product>>
    fun getById(id: Int): Product?
}