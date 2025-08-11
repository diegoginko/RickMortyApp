package com.diegoginko.rickmortyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform