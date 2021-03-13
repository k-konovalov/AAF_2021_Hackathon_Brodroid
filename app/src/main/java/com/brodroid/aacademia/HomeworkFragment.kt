package com.brodroid.aacademia

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brodroid.aacademia.util.configAndShow

class HomeworkFragment : Fragment(R.layout.fragment_homework_layout) {

    private val homeworkUrl: String by lazy { requireArguments().getString(HOME_URL, "") }
    private lateinit var viewModel: HomeworkViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeworkViewModel::class.java)
        viewModel.checkWhatSHowToUser(homeworkUrl)
        viewModel.onReadyToShow.observe(viewLifecycleOwner) { showWebViewWithUrl(homeworkUrl) }
        viewModel.onEmptyUrl.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.emptyMessage).isVisible = true }
    }

    private fun showWebViewWithUrl(homeworkUrl: String) {
        val webView: WebView? = view?.findViewById(R.id.webView)
        webView?.configAndShow(getString(R.string.fragment_homework_link, homeworkUrl))
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