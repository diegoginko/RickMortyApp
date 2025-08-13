package com.diegoginko.rickmortyapp.ui.core.ex

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.vertical() = layout { measurable, constraints ->
    val placeabe = measurable.measure(constraints)
    layout(placeabe.height, placeabe.width) {
        placeabe.place(
            x = -((placeabe.width/2) - (placeabe.height/2)),
            y = -((placeabe.height/2) - (placeabe.width/2))
        )
    }
}