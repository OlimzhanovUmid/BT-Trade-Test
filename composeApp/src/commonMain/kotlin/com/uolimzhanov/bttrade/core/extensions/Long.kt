package com.uolimzhanov.bttrade.core.extensions

fun Long?.toUzbSums() : String {
    return "%,d".format(this).replace(",", " ") + " so'm"
}