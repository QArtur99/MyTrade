package com.example.androiddevchallenge.ui.data

data class Market(val name: String, val isArrow: Boolean)

val marketList = listOf(
    Market("Week", true),
    Market("ETFs", false),
    Market("Stocks", false),
    Market("Founds", false),
    Market("Futures", false),
    Market("Bounds", false),
    Market("Currencies", false),
)