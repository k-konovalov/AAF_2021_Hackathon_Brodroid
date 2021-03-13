package com.brodroid.aacademia

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brodroid.aacademia.util.configAndShow

class HomeworkFragment : Fragment(R.layout.homework_fragment) {

    private val presentationUrl: String by lazy { requireArguments().getString(HOME_URL, "") }
    private lateinit var viewModel: HomeworkViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeworkViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (presentationUrl.isNotEmpty()) {
            val webView: WebView = view.findViewById(R.id.webView)
            webView.configAndShow(presentationUrl)
        } else {
            view.findViewById<TextView>(R.id.emptyMessage).isVisible = true
        }
    }

    companion object {
        private const val HOME_URL = "url"

        fun newInstance(url: String) = HomeworkFragment().apply {
            arguments = Bundle().apply {
                putString(HOME_URL, url)
            }
        }
    }

}