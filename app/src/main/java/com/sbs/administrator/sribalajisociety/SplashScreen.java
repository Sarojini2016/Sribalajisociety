package com.sbs.administrator.sribalajisociety;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

import com.sbs.administrator.sribalajisociety.LoginActivity;

public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 4000;
	private SessionManager sessionManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		sessionManager  = new SessionManager(getApplicationContext());
		final boolean MY_SESSION = sessionManager.isLoggedIn();

		 new Handler().postDelayed(new Runnable() {

	            @Override
	            public void run() {

					//TODO VALIDATION
					//IF SESSION == FALSE (LOGIN)
					if(!MY_SESSION) {
						Intent iLogin = new Intent(SplashScreen.this, LoginActivity.class);
						//iLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						//iLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(iLogin);
						finish();
					}else {
						//ELSE
						Intent iGridLayout = new Intent(SplashScreen.this, AndroidGridLayout.class);
						//iGridLayout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					//	iGridLayout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						//iGridLayout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(iGridLayout);
						finish();
					}
	               // finish();
	            }
	        }, SPLASH_TIME_OUT);
	    }

		@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			finish();
		}
	    
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
