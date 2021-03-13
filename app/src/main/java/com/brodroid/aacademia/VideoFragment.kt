package com.brodroid.aacademia

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brodroid.aacademia.util.configAndShow

class VideoFragment : Fragment(R.layout.video_fragment) {

    private val videoUrl: String by lazy { requireArguments().getString(VIDEO_URL, "") }

    private lateinit var viewModel: VideoViewModel

    companion object {
        private const val VIDEO_URL = "url"
        fun newInstance(url: String) = VideoFragment().apply {
            arguments = Bundle().apply {
                putString(VIDEO_URL, url)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        viewModel.checkWhatSHowToUser(videoUrl)
        viewModel.onReadyToShow.observe(viewLifecycleOwner) { showWebViewWithUrl(videoUrl) }
        viewModel.onEmptyUrl.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.emptyMessage).isVisible = true
        }
    }


    private fun showWebViewWithUrl(videoUrl: String) {
        val webView: WebView? = view?.findViewById(R.id.webView)
        webView?.configAndShow(getString(R.string.fragment_video_link, videoUrl))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}