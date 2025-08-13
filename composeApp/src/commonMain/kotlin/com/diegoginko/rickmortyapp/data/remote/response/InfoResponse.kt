package com.diegoginko.rickmortyapp.data.remote.response

data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?

)
