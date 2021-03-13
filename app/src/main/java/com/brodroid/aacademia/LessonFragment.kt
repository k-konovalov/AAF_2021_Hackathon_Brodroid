package com.brodroid.aacademia

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.brodroid.aacademia.databinding.LessonFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class LessonFragment : Fragment(R.layout.lesson_fragment) {

    private var lessonFragmentBinding: LessonFragmentBinding? = null

    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = LessonFragmentBinding.bind(view)
        lessonFragmentBinding = binding

//        val viewModel = ViewModelProvider(this).get(LessonViewModel::class.java)

        val tabLayout = binding.lessonTablayout
        pagerAdapter = PagerAdapter(this)
        viewPager = binding.lessonViewpager
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> resources.getString(R.string.lesson_fragment_tab_video_item)
                1 -> resources.getString(R.string.lesson_fragment_tab_slides_item)
                2 -> resources.getString(R.string.lesson_fragment_tab_homework_item)
                else -> throw IllegalStateException()
            }
        }.attach()
    }

    override fun onDestroyView() {
        lessonFragmentBinding = null
        super.onDestroyView()
    }
}