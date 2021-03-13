package com.brodroid.aacademia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brodroid.aacademia.R

class AdapterLessons(
    private val onClick: OnClickDetailLesson,
) : RecyclerView.Adapter<HolderLesson>() {

    private var lessonList = listOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderLesson {
        return HolderLesson(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_lesson, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HolderLesson, position: Int) {
        holder.onBind(lessonList[position])
        holder.itemView.setOnClickListener {
            onClick.moveDetailLesson(lessonList[position])
        }
    }

    override fun getItemCount(): Int = lessonList.size

    fun bindLesson(newListLesson: List<Int>) {
        lessonList = newListLesson
        notifyDataSetChanged()
    }
}

class HolderLesson(item: View) : RecyclerView.ViewHolder(item) {

    private val iconLesson: ImageView = item.findViewById(R.id.image_icon_lesson)
    private val textNumberLesson: TextView = item.findViewById(R.id.text_number_lesson)
    private val textDataLesson: TextView = item.findViewById(R.id.text_number_lesson)

    fun onBind(number: Int) {
        textNumberLesson.text = "№$number name lesson"
    }
}