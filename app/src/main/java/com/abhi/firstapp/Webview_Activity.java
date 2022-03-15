package com.abhi.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Webview_Activity extends AppCompatActivity {
    WebView webView;
    EditText editText;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView)findViewById(R.id.webView);
        editText = (EditText) findViewById(R.id.link);
        b = (Button) findViewById(R.id.webbutton);
    }
}