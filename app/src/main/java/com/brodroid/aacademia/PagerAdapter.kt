package com.brodroid.aacademia

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3 // TODO Вынести количество вкладок в константу

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VideoFragment() as Fragment
            1 -> SlidesFragment()
            2 -> HomeworkFragment()
            else -> throw IllegalStateException()
        }
    }
}