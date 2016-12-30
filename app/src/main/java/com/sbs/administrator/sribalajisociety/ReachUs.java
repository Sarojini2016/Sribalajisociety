package com.sbs.administrator.sribalajisociety;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
//import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

public class ReachUs extends Activity {
  //  private ImageButton btn_fb, btn_tw;
private Button btn_fb,btn_tw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reach_us);
		btn_fb = (Button)findViewById(R.id.button);
        btn_tw = (Button)findViewById(R.id.button4);
        btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/official.sribalajisocietypune/?fref=ts")));
                }catch (Exception e){
                    Toast.makeText(ReachUs.this, "Unable to open", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/prof_bala")));
                }catch (Exception e){
                    Toast.makeText(ReachUs.this, "Unable to open", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reach_us, menu);
		return true;
	}
}
