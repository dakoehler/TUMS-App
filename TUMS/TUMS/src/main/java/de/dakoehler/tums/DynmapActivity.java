package de.dakoehler.tums;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
/**
 * Created by Max on 19.05.13.
 */
public class DynmapActivity extends Activity{
    WebView wv;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynmap);
        wv = (WebView) findViewById(R.id.webView1);
        wv.loadUrl("http://map.tums-mc.de/");
        wv.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        final Intent intent = new Intent(this, MainActivity.class);
        button =(Button)findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(intent);
            }
        });
    }
}
