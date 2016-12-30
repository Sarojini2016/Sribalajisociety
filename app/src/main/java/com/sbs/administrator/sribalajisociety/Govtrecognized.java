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

public class Govtrecognized extends Activity {
	private WebView wvgovt;
	ProgressDialog progressDialog;
    @Override
	protected void onCreate(Bundle savedInstanceState)
   {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_govtrecognized);
		 wvgovt = (WebView) findViewById(R.id.wvgovtrecog);
	   startWebView("http://app.sribalajisocietypune.org/aicteapp.html");
   }
	private void startWebView(String url) {
		wvgovt.setWebViewClient(new WebViewClient() {
			ProgressDialog progressDialog;

			//If you will not use this method url links are opeen in new brower not in webview
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			//Show loader on url load
			public void onLoadResource(WebView view, String url) {
				if (progressDialog == null) {
					progressDialog = new ProgressDialog(Govtrecognized.this);
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
		wvgovt.getSettings().setJavaScriptEnabled(true);

		// Other webview options

		wvgovt.getSettings().setLoadWithOverviewMode(true);
		wvgovt.getSettings().setUseWideViewPort(true);
		wvgovt.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		wvgovt.setScrollbarFadingEnabled(false);
		wvgovt.getSettings().setBuiltInZoomControls(true);
		wvgovt.loadUrl(url);



	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wvgovt.canGoBack()) {
			this.wvgovt.goBack();
			Intent i = new Intent(Govtrecognized.this,AboutSbsActivity.class);
			startActivity(i);
		}
		return super.onKeyDown(keyCode, event);
	}

 		@Override
		public boolean onCreateOptionsMenu(Menu menu)
		{
		// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.govtrecognized, menu);
			return true;
		}

	}
