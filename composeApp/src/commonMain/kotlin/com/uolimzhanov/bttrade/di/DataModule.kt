package com.uolimzhanov.bttrade.di

import com.uolimzhanov.bttrade.cashRegister.data.InMemoryProductRepository
import com.uolimzhanov.bttrade.cashRegister.domain.ProductRepository
import org.koin.dsl.module

val dataModule = module {
    single<ProductRepository> { InMemoryProductRepository() }
}