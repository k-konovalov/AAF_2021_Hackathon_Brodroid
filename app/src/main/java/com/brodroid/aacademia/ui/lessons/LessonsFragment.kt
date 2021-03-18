package com.brodroid.aacademia.ui.lessons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.brodroid.aacademia.R
import com.brodroid.aacademia.ui.data.Lesson
import com.brodroid.aacademia.ui.details.LessonData
import com.brodroid.aacademia.ui.lessons.adapter.AdapterLessons
import com.brodroid.aacademia.ui.lessons.adapter.OnClickDetailLesson

class LessonsFragment : Fragment(R.layout.fragment_lessons_list) {

    private lateinit var recyclerView: RecyclerView
    private val adapterLesson by lazy { AdapterLessons(onClick) }

    private val mViewModelLessons: ViewModelLessons by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.rec_view_lesson).apply {
            adapter = adapterLesson
        }

        mViewModelLessons.liveDataLessonList.observe(viewLifecycleOwner, { listLesson ->
            setAdapter(listLesson)
        })
    }

    private fun setAdapter(listLesson: List<Lesson>) {
        adapterLesson.bindLesson(listLesson)
    }

    private val onClick = object : OnClickDetailLesson {
        override fun moveDetailsLesson(lesson: Lesson) {
            LessonData.currentLesson = lesson
            findNavController().navigate(R.id.action_lessonFragment_to_videoFragment)
        }
    }
}