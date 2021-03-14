package com.brodroid.aacademia.ui.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Lessons(

	@SerialName("lessons")
	val lessons: List<Lesson?>? = null
)
