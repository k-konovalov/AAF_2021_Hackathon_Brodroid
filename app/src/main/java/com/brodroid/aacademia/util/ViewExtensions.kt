package com.brodroid.aacademia.util

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.DimenRes

fun WebView.configAndShow( url: String) {
    webViewClient = WebViewClient()
    settings.setSupportZoom(true)
    settings.javaScriptEnabled = true
    webViewClient = WebViewController()
    loadUrl(url)
}