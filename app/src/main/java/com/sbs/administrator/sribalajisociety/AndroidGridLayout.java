package com.sbs.administrator.sribalajisociety;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class AndroidGridLayout extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android_grid_layout);
		GridView gridView = (GridView) findViewById(R.id.grid);
        
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));


        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(AndroidGridLayout.this,AboutSbsActivity.class);
                    i.putExtra("id", position);
                    startActivity(i);
                } else if (position == 1) {
                    
                    Intent i1 = new Intent(AndroidGridLayout.this,MainActivity.class);
                    i1.putExtra("id1", position);
                    startActivity(i1);

                } else if (position == 2) 
                {// Courses Details
                    Intent i2 = new Intent(AndroidGridLayout.this,Courses.class);

                    startActivity(i2);

                } else if (position == 3) {
                    Intent i3 = new Intent(getApplicationContext(),
							Principaldates.class);
					startActivity(i3);
					}
                else if (position == 4) {
                    Intent i4 = new Intent(AndroidGridLayout.this,
                            Youtubeex.class);
                    //youtube

                    startActivity(i4);

                } else if (position == 5) {
                    Intent i5 = new Intent(AndroidGridLayout.this,
                            Facebooksbs.class);

                    startActivity(i5);

                }      else if (position == 6) {
                    Intent i6 = new Intent(AndroidGridLayout.this,
                            ReachUs.class);

                    startActivity(i6);

                }
                else if (position == 7) {
                    Intent i7 = new Intent(AndroidGridLayout.this,
                            MapsActivityDemo.class);

                    startActivity(i7);

                }

             }
        });

    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.android_grid_layout, menu);
		return true;
	}

}
