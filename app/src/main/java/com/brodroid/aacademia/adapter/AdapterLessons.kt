package com.brodroid.aacademia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brodroid.aacademia.Lesson
import com.brodroid.aacademia.ProgressBarAnimation
import com.brodroid.aacademia.R
import com.bumptech.glide.Glide


const val BASE_URL_LESSON_IMAGE = "https://img.youtube.com/vi/%s/0.jpg"

class AdapterLessons(
    private val onClick: OnClickDetailLesson,
) : RecyclerView.Adapter<HolderLesson>() {

    private var lessonList = listOf<Lesson>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderLesson {
        return HolderLesson(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_lesson, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HolderLesson, position: Int) {
        holder.onBind(lessonList[position], holder.itemView.context)
        holder.itemView.setOnClickListener {
            onClick.moveDetailsLesson(lessonList[position])
        }
    }

    override fun getItemCount(): Int = lessonList.size

    fun bindLesson(newListLesson: List<Lesson>) {
        lessonList = newListLesson
        notifyDataSetChanged()
    }
}

class HolderLesson(item: View) : RecyclerView.ViewHolder(item) {

    private val progressBarMovie: ProgressBar = item.findViewById(R.id.progress_horizontal_movie)
    private val iconLesson: ImageView = item.findViewById(R.id.image_icon_lesson)
    private val textNameLesson: TextView = item.findViewById(R.id.text_name_lesson)
    private val textDateLesson: TextView = item.findViewById(R.id.text_date_lesson)

    fun onBind(listLesson: Lesson, context: Context) {
        textNameLesson.text = listLesson.name
        textDateLesson.text = listLesson.date

        val anim = ProgressBarAnimation(progressBarMovie, 0f, (20..80).random().toFloat())
        anim.setDuration(1000)
        progressBarMovie.startAnimation(anim)

        listLesson.id?.let { setImage(it, context) }
    }

    private fun setImage(image: String, context: Context) {
        Glide.with(context)
            .load(String.format(BASE_URL_LESSON_IMAGE, image))
            .into(iconLesson)
    }
}