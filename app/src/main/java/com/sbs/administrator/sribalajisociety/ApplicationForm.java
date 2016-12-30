package com.sbs.administrator.sribalajisociety;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ApplicationForm extends Activity {
	 private ListView listview;
	    private ArrayList<String> TypeName;
	    private TextView txtheaderName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_application_form);
		init();
	}
	private void init() {
    	//Typeface tf=Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Light.ttf");

        txtheaderName = (TextView) findViewById(R.id.header_name);
        txtheaderName.setText(com.sbs.administrator.sribalajisociety.Utilis.Header_Name);
       
       // txtheaderName.setTypeface(tf);
        TypeName = getIntent().getStringArrayListExtra("type");
        listview = (ListView) findViewById(R.id.listview_main1);
        
        listview.setAdapter(new TypeAdater(ApplicationForm.this));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forms.balajisociety.org/"));
                        startActivity(intent);
                    }
            }
        });
    }
    private class TypeAdater extends BaseAdapter {
        private Context context;

        public TypeAdater(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return TypeName.size();
        }

        @Override
        public Object getItem(int arg0) {
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewholder;
            if (convertView == null) {
                LayoutInflater li = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = li.inflate(R.layout.layout_subtyperow, null);
                viewholder = new ViewHolder();
                viewholder.txtwhoname = (TextView) convertView
                        .findViewById(R.id.txt_name);

                convertView.setTag(viewholder);

            } else {

                viewholder = (ViewHolder) convertView.getTag();
            }
            viewholder.txtwhoname.setText(TypeName.get(position).toString());

            return convertView;
        }

        private class ViewHolder {
            public TextView txtwhoname;
        }
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.application_form, menu);
		return true;
	}

}
