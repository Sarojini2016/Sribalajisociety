package com.sbs.administrator.sribalajisociety;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AicteApproval extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aicte_approval);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aicte_approval, menu);
		return true;
	}

}
