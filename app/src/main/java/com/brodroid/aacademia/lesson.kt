package com.brodroid.aacademia

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Lesson(

	@SerialName("lessons")
	val lessons: List<LessonsItem?>? = null
)

data class LessonsItem(

	@SerialName("date")
	val date: String? = null,

	@SerialName("timestamps")
	val timestamps: List<TimestampsItem?>? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: String? = null,

	@SerialName("presentation_id")
	val presentationId: String? = null,

	@SerialName("youtube_id")
	val youtubeId: String? = null
)

data class TimestampsItem(

	@SerialName("name")
	val name: String? = null,

	@SerialName("time")
	val time: String? = null
)
