package com.bayarsahintekin.stars.util

import android.graphics.Color

enum class Size (var size: String){
    SMALL("S"),
    BIG("B")
}

enum class SmallColors(var color: String){
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green")
}

enum class BigColors(var color: String){
    YELLOW("Yellow"),
    PURPLE("Purple"),
    GRAY("Gray")
}

enum class Brightness(var brightness: String){
    BRIGHT("Bright"),
    NOT_BRIGHT("Not so much")
}