package com.example.skillblogassemble

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {
    val webView : WebView by lazy { findViewById(R.id.webView) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val url = intent.getStringExtra("url")
        Log.d("url : ",">>$url")
        if(url != null){
            webView.settings.javaScriptEnabled = true
            //webView.webChromeClient = WebChromeClient()
            webView.loadUrl(url)
        }

    }
}