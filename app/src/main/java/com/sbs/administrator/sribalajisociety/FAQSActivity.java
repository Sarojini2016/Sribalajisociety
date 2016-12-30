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

public class FAQSActivity extends Activity {
	 WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faqs);
		 wv = (WebView) findViewById(R.id.wvfaqs);
		startWebView("http://app.sribalajisocietypune.org/faq.html");
	}
	private void startWebView(String url) {
		wv.setWebViewClient(new WebViewClient() {
			ProgressDialog progressDialog;

			//If you will not use this method url links are opeen in new brower not in webview
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			//Show loader on url load
			public void onLoadResource (WebView view, String url) {
				if (progressDialog == null) {
					progressDialog = new ProgressDialog(FAQSActivity.this);
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
		wv.getSettings().setJavaScriptEnabled(true);

		// Other webview options

		wv.getSettings().setLoadWithOverviewMode(true);
		wv.getSettings().setUseWideViewPort(true);
		wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		wv.setScrollbarFadingEnabled(false);
		wv.getSettings().setBuiltInZoomControls(true);
		wv.loadUrl(url);


	}

	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wv.canGoBack()) {
	            this.wv.goBack();
	            Intent i = new Intent(FAQSActivity.this,
	                    AndroidGridLayout.class);

	            //i.putExtra("id", position);
	            startActivity(i);
	        }
	        return super.onKeyDown(keyCode, event);
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.faq, menu);
		return true;
	}

}
