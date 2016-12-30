package com.sbs.administrator.sribalajisociety;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.ProgressDialog;
import android.webkit.WebViewClient;
public class AIUEquivalence extends Activity {
	 private WebView wvaiumba;
	//    public String url = "http://app.sribalajisocietypune.org/aiu.html";
	ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aiuequivalence);
		 wvaiumba = (WebView) findViewById(R.id.wvaiu);

	startWebView("http://app.sribalajisocietypune.org/aiu.html");
}
	private void startWebView(String url) {
		wvaiumba.setWebViewClient(new WebViewClient() {
			//If you will not use this method url links are opeen in new brower not in webview
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			//Show loader on url load
			public void onLoadResource(WebView view, String url) {
				if (progressDialog == null) {
					progressDialog = new ProgressDialog(AIUEquivalence.this);
					progressDialog.setMessage("Loading...");
					progressDialog.show();
				}
			}

			public void onPageFinished(WebView view, String url) {
				try {
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}

		});
// Javascript inabled on webview
		wvaiumba.getSettings().setJavaScriptEnabled(true);

		// Other webview options

		wvaiumba.getSettings().setLoadWithOverviewMode(true);
		wvaiumba.getSettings().setUseWideViewPort(true);
		wvaiumba.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		wvaiumba.setScrollbarFadingEnabled(false);
		wvaiumba.getSettings().setBuiltInZoomControls(true);
		wvaiumba.loadUrl(url);



	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aiuequivalence, menu);
		return true;
	}

}
