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

public class Facebooksbs extends Activity {
	 private WebView wvfacebook;
	  //  public String url = "https://www.facebook.com/sbs.admissions/?fref=nf";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facebooksbs);
		 wvfacebook = (WebView) findViewById(R.id.wvfb);
		startWebView("https://www.facebook.com/sbs.admissions/?fref=nf");
	}
	private void startWebView(String url) {
		wvfacebook.setWebViewClient(new WebViewClient() {
			ProgressDialog progressDialog;

			//If you will not use this method url links are opeen in new brower not in webview
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			//Show loader on url load
			public void onLoadResource (WebView view, String url) {
				if (progressDialog == null) {
					progressDialog = new ProgressDialog(Facebooksbs.this);
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
		wvfacebook.getSettings().setJavaScriptEnabled(true);

		// Other webview options

		wvfacebook.getSettings().setLoadWithOverviewMode(true);
		wvfacebook.getSettings().setUseWideViewPort(true);
		wvfacebook.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		wvfacebook.setScrollbarFadingEnabled(false);
		wvfacebook.getSettings().setBuiltInZoomControls(true);
		wvfacebook.loadUrl(url);


	}

	//loadResource(webview, URL_TO_LOAD);
	        //wvwrittenexam.getSettings().setJavaScriptEnabled(true);

	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wvfacebook.canGoBack())
	        {
	            this.wvfacebook.goBack();
	            Intent i = new Intent(Facebooksbs.this,
	                    AndroidGridLayout.class);

	            //i.putExtra("id", position);
	            startActivity(i);
	        }
	        return super.onKeyDown(keyCode, event);
	    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.facebooksbs, menu);
		return true;
	}

}
