package com.diegoginko.rickmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import com.diegoginko.rickmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {initKoin()}) { App() }