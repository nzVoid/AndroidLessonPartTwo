package com.startandoid.p0321simplebrowser

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        var webView: WebView = findViewById(R.id.webView)
        webView.setWebViewClient(WebViewClient())
        var data: Uri? = getIntent().getData()
        webView.loadUrl(data.toString())
    }
}