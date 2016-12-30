package com.sbs.administrator.sribalajisociety;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class Youtubeex extends Activity {
	private WebView webview;
    private String url = "https://www.youtube.com/channel/UCI8Am85I47QdTcparDFBuZw+";
    boolean doubleBackToExitPressedOnce;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_youtubeex);
		webview = (WebView) findViewById(R.id.wvyoutube);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.loadUrl(url);
   
	}
	 @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webview.canGoBack()) {
	            this.webview.goBack();
	            Intent i = new Intent(Youtubeex.this,AndroidGridLayout.class);
	            startActivity(i);
	            return true;
	        }    return super.onKeyDown(keyCode, event);
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.youtubeex, menu);
		return true;
	}

}
