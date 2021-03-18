package com.brodroid.aacademia.ui.details.homework

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

class HomeworkFragment : Fragment(R.layout.fragment_homework) {

    private val homeworkUrl: String by lazy { LessonData.currentLesson?.homework_id.toString() }

    private lateinit var viewModel: HomeworkViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(HomeworkViewModel::class.java)
        viewModel.checkWhatShowToUser(homeworkUrl)
        viewModel.onReadyToShow.observe(viewLifecycleOwner) { showWebViewWithUrl(homeworkUrl) }
        viewModel.onEmptyUrl.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.emptyMessage).isVisible = true
        }
    }

    private fun showWebViewWithUrl(homeworkUrl: String) {
        val webView: WebView? = view?.findViewById(R.id.webView)
        webView?.configAndShow(getString(R.string.fragment_homework_link, homeworkUrl))
    }

}