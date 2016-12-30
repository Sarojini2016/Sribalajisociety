package com.sbs.administrator.sribalajisociety;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.view.KeyEvent;
public class Whyenroll extends Activity {
	private WebView webview;
	ProgressBar progressbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_whyenroll);
		webview = (WebView) findViewById(R.id.wvwhyenroll);
		startWebView("http://app.sribalajisocietypune.org/whyenroll.html");
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
			public void onLoadResource(WebView view, String url) {
				if (progressDialog == null) {
					progressDialog = new ProgressDialog(Whyenroll.this);
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
			Intent i = new Intent(Whyenroll.this,AboutSbsActivity.class);
			startActivity(i);
		}
		return super.onKeyDown(keyCode, event);
	}

}