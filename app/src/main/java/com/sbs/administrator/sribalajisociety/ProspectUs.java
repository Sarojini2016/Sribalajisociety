package com.sbs.administrator.sribalajisociety;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class ProspectUs extends Activity {
	private WebView wvprospec;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prospect_us);
		wvprospec = (WebView) findViewById(R.id.wvprospectus);
        wvprospec.getSettings().setLoadsImagesAutomatically(true);
        wvprospec.getSettings().setJavaScriptEnabled(true);
        wvprospec.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wvprospec.canGoBack()) {
            this.wvprospec.goBack();
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://balajisociety.org/SBS-Prospectus-2016-18.html"));
            startActivity(intent1);
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prospect_us, menu);
		return true;
	}
}
