package com.sbs.administrator.sribalajisociety;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class SelectionProcedure extends Activity {
	private WebView webview;
    String url = "http://sribalajisocietypune.org/selectionprocedure.html";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selection_procedure);
		 	webview = (WebView) findViewById(R.id.wvadmprocedure);
	        webview.getSettings().setLoadsImagesAutomatically(true);
	        webview.getSettings().setJavaScriptEnabled(true);
	        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
	        webview.loadUrl(url);

	    }

	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webview.canGoBack()) {
	            this.webview.goBack();
	            /*Intent i = new Intent(SelectionProcedure.this,
	                    MainActivity.class);
	            startActivity(i);*/
	        }
	        return super.onKeyDown(keyCode, event);
	    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selection_procedure, menu);
		return true;
	}

}
