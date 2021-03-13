package com.brodroid.aacademia

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.brodroid.aacademia.ui.PresentationFragment

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private var videoFragment: VideoFragment = VideoFragment.newInstance("")
    private var homeworkFragment: HomeworkFragment  = HomeworkFragment.newInstance("")
    private var presentationFragment: PresentationFragment = PresentationFragment.newInstance("")

    override fun getItemCount() = 3 // TODO Вынести количество вкладок в константу

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> videoFragment
            1 -> presentationFragment
            2 -> homeworkFragment
            else -> throw IllegalStateException()
        }
    }

    fun updateParams(lesson: Lesson) {
        homeworkFragment = HomeworkFragment.newInstance(lesson.homework_id ?: "")
        presentationFragment = PresentationFragment.newInstance(lesson.presentation_id ?: "")
        videoFragment = VideoFragment.newInstance(lesson.youtube_id?: "")
    }
}