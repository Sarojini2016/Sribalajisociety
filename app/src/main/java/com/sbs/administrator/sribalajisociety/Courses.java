package com.sbs.administrator.sribalajisociety;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Courses extends Activity {
	WebView wvc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_courses);
		wvc=(WebView)findViewById(R.id.wvcourses);
		startWebView("http://app.sribalajisocietypune.org/courses.html");
	}
	private void startWebView(String url) {
		wvc.setWebViewClient(new WebViewClient() {
			ProgressDialog progressDialog;

			//If you will not use this method url links are opeen in new brower not in webview
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			//Show loader on url load
			public void onLoadResource (WebView view, String url) {
				if (progressDialog == null) {
					progressDialog = new ProgressDialog(Courses.this);
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
		wvc.getSettings().setJavaScriptEnabled(true);

		// Other webview options

		wvc.getSettings().setLoadWithOverviewMode(true);
		wvc.getSettings().setUseWideViewPort(true);
		wvc.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		wvc.setScrollbarFadingEnabled(false);
		wvc.getSettings().setBuiltInZoomControls(true);
		wvc.loadUrl(url);


	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wvc.canGoBack()) {
			this.wvc.goBack();
			Intent i = new Intent(Courses.this,
					AndroidGridLayout.class);

			//i.putExtra("id", position);
			startActivity(i);
		}
		return super.onKeyDown(keyCode, event);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.courses, menu);
		return true;
	}
}
