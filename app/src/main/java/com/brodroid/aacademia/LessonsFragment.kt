package com.brodroid.aacademia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.brodroid.aacademia.adapter.AdapterLessons
import com.brodroid.aacademia.adapter.OnClickDetailLesson

class LessonsFragment : Fragment(R.layout.fragment_lesson) {

    private lateinit var recyclerView: RecyclerView;
    private val adapterLesson by lazy { AdapterLessons(onClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.rec_view_lesson).apply {
            adapter = adapterLesson
        }
        setAdapter()
    }

    private fun setAdapter() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        adapterLesson.bindLesson(list)
    }

    private val onClick = object : OnClickDetailLesson {
        override fun moveDetailLesson(position : Int) {
            Toast.makeText(context, "Lesson №$position", Toast.LENGTH_SHORT).show()
        }
    }
}