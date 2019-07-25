//
//  WebviewActivity.java
//  EC-sample
//
//  Created by Trial: Yusuke Ebinuma on 2019/08/09.
//  Copyright © 2019 Repro CRE. All rights reserved.
//

package com.company.ecsample.Activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.company.ecsample.R;

import io.repro.android.Repro;
import io.repro.android.tracking.ViewContentProperties;


public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_screen);
        setTitle("Webview Screen");

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                /**
                 * Track content viewing using the standard event trackinng.
                 *
                 * Refer to the documentation for more detail information.
                 * (JP) https://docs.repro.io/ja/dev/sdk/tracking.html#id3
                 * (EN) https://docs.repro.io/en/dev/sdk/tracking.html#id3
                 */
                ViewContentProperties properties = new ViewContentProperties();
                Repro.trackViewContent("WebView", properties);
            }
        });


        WebSettings webSettings = webView.getSettings(); // js enabled
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://hiroshi-imamasu.github.io/cre-ec-sample.io/");

        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);

        /**
         * Setup webview tracking
         *
         * WARNING: You also need to setup Repro.js.
         *
         * Refer to the documentation for more detail information.
         * (JP) https://docs.repro.io/ja/dev/sdk/webview.html#webview
         * (EN) https://docs.repro.io/en/dev/sdk/webview.html#webview
         */
        // call startWebViewTracking() with webView and client
        Repro.startWebViewTracking(webView, client);

        // (Optional) You must specify "utf-8" as default encoding if you track events included localized strings
        webView.getSettings().setDefaultTextEncodingName("utf-8");
    }

}
