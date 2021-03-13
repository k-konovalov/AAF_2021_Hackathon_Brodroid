package com.brodroid.aacademia

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Lessons(

	@SerialName("lessons")
	val lessons: List<Lesson?>? = null
)

@Serializable
data class Lesson(

	@SerialName("date")
	val date: String? = null,

	@SerialName("timestamps")
	val timestamps: List<Timestamp?>? = null,

	@SerialName("name")
	val name: String? = "",

	@SerialName("id")
	val id: String? = "",

	@SerialName("presentation_id")
	val presentation_id: String? = "",

	@SerialName("youtube_id")
	val youtube_id: String? = null,

	@SerialName("homework_id")
	val homework_id: String? = ""
) : java.io.Serializable

@Serializable
data class Timestamp(

	@SerialName("name")
	val name: String? = null,

	@SerialName("time")
	val time: String? = null
)