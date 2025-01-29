package com.uolimzhanov.bttrade.di

import com.uolimzhanov.bttrade.cashRegister.presentation.CashRegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::CashRegisterViewModel)
}