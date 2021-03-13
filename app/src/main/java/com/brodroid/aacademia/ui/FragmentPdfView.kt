package com.brodroid.aacademia.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.brodroid.aacademia.R
import com.brodroid.aacademia.util.WebViewController

class FragmentPdfView: Fragment(R.layout.fragment_pdf_view) {

    private val presentationUrl: String by lazy { requireArguments().getString(PRESENTATION_URL, "") }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (presentationUrl.isNotEmpty()) {
            val webView: WebView = view.findViewById(R.id.webView)
            webView.webViewClient = WebViewClient()
            webView.settings.setSupportZoom(true)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewController()
            webView.loadUrl(presentationUrl)
        } else {
            view.findViewById<TextView>(R.id.presentationEmptyMessage).isVisible = true
        }

    }

    companion object {
        private const val PRESENTATION_URL = "url"
        fun newInstance(url: String) = FragmentPdfView().apply {
            arguments = Bundle().apply {
                putString(PRESENTATION_URL, url)
            }
        }
    }

}