package com.sbs.administrator.sribalajisociety;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.app.ProgressDialog;
import android.webkit.WebViewClient;
public class AdmissionProcedure extends Activity {
	private WebView webview;
   // String url = "http://app.sribalajisocietypune.org/selectionprocedure.html";
    ProgressDialog progressDialog;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admission_procedure);
		webview = (WebView) findViewById(R.id.wvadmprocedure);

        startWebView("http://app.sribalajisocietypune.org/selectionprocedure.html");
    }
    private void startWebView(String url) {
        webview.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(AdmissionProcedure.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });

// Javascript inabled on webview
        webview.getSettings().setJavaScriptEnabled(true);

        // Other webview options

        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.setScrollbarFadingEnabled(false);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.loadUrl(url);


    }

@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webview.canGoBack()) {
            this.webview.goBack();
            Intent i = new Intent(AdmissionProcedure.this,
                    MainActivity.class);
            startActivity(i);
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admission_procedure, menu);
		return true;
	}

}
