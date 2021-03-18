package com.brodroid.aacademia.ui.details.lecture

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brodroid.aacademia.R
import com.brodroid.aacademia.ui.details.LessonData
import com.brodroid.aacademia.util.configAndShow

class VideoFragment : Fragment(R.layout.fragment_video) {

    private val videoUrl: String by lazy { LessonData.currentLesson?.youtube_id.toString() }

    private lateinit var viewModel: VideoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        viewModel.checkWhatShowToUser(videoUrl)
        viewModel.onReadyToShow.observe(viewLifecycleOwner) { showWebViewWithUrl(videoUrl) }
        viewModel.onEmptyUrl.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.emptyMessage).isVisible = true
        }
    }

    private fun showWebViewWithUrl(videoUrl: String) {
        val webView: WebView? = view?.findViewById(R.id.webView)
        webView?.configAndShow(getString(R.string.fragment_video_link, videoUrl))
    }

}