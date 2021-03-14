package com.brodroid.aacademia.ui.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Timestamp(

    @SerialName("name")
    val name: String? = null,

    @SerialName("time")
    val time: String? = null
)