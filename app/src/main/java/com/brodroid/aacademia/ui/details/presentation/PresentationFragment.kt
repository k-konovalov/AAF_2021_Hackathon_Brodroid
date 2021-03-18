package com.brodroid.aacademia.ui.details.presentation

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

class PresentationFragment : Fragment(R.layout.fragment_presentation) {

    private val presentationUrl: String by lazy { LessonData.currentLesson?.presentation_id.toString() }

    private lateinit var viewModel: PresentationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PresentationViewModel::class.java)
        viewModel.checkWhatShowToUser(presentationUrl)
        viewModel.onReadyToShow.observe(viewLifecycleOwner) { showWebViewWithUrl(presentationUrl) }
        viewModel.onEmptyUrl.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.emptyMessage).isVisible = true
        }
    }

    private fun showWebViewWithUrl(homeworkUrl: String) {
        val webView: WebView? = view?.findViewById(R.id.webView)
        webView?.configAndShow(getString(R.string.fragment_presentation_link, homeworkUrl))
    }

}