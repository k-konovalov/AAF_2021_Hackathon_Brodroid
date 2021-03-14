package com.brodroid.aacademia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.brodroid.aacademia.adapter.AdapterLessons
import com.brodroid.aacademia.adapter.OnClickDetailLesson
import com.brodroid.aacademia.viewModel.ViewModelLessons

const val BUNDLE_VIDEO_FRAGMENT = "BUNDLE_VIDEO_FRAGMENT"
const val BUNDLE_PRESENTATION_FRAGMENT = "BUNDLE_PRESENTATION_FRAGMENT"
const val BUNDLE_HOMEWORK_FRAGMENT = "BUNDLE_HOMEWORK_FRAGMENT"

class LessonsFragment : Fragment(R.layout.fragment_lesson) {

    private lateinit var recyclerView: RecyclerView;
    private val adapterLesson by lazy { AdapterLessons(onClick) }

    private val mViewModelLessons : ViewModelLessons by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.rec_view_lesson).apply {
            adapter = adapterLesson
        }

        mViewModelLessons.liveDataLessonList.observe(viewLifecycleOwner, {listLesson ->
            Toast.makeText(context, "List size = ${listLesson.size}", Toast.LENGTH_SHORT).show()
            setAdapter(listLesson)
        })
    }

    private fun setAdapter(listLesson: List<Lesson>) {
        adapterLesson.bindLesson(listLesson)
    }

    private val onClick = object : OnClickDetailLesson {
        override fun moveDetailsLesson(lesson: Lesson) {
            val bundle = Bundle()
            bundle.putString(BUNDLE_VIDEO_FRAGMENT, lesson.youtube_id ?: "")
            bundle.putString(BUNDLE_PRESENTATION_FRAGMENT, lesson.presentation_id ?: "")
            bundle.putString(BUNDLE_HOMEWORK_FRAGMENT, lesson.homework_id ?: "")
            findNavController().navigate(R.id.action_lessonFragment_to_videoFragment, bundle)
        }
    }
}