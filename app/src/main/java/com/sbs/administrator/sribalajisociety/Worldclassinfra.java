package com.sbs.administrator.sribalajisociety;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Worldclassinfra extends Activity {
	 private WebView wvworldinfra;
	    public String url = "http://www.balajisociety.org/360/common.html";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_worldclassinfra);
		wvworldinfra = (WebView) findViewById(R.id.wvinfra);
		wvworldinfra.getSettings().setLoadsImagesAutomatically(true);
		wvworldinfra.getSettings().setJavaScriptEnabled(true);
		wvworldinfra.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		wvworldinfra.loadUrl(url);

	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wvworldinfra.canGoBack()) {
			this.wvworldinfra.goBack();
			Intent i = new Intent(Worldclassinfra.this,AndroidGridLayout.class);
			startActivity(i);
			return true;
		}    return super.onKeyDown(keyCode, event);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.worldclassinfra, menu);
		return true;
	}

}
