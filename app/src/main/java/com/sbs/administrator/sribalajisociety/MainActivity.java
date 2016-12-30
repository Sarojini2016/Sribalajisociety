package com.sbs.administrator.sribalajisociety;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	  private String[] Type =
          {		  "Application Form",
                  "Prospectus",
                  "Selection Procedure",
                  "Eligibility",
                  "GDPI Centers",
                  "Fee Structure",
                  "FAQs",
                 
           };
	  private int[] drawlabeType = {R.drawable.applicationformed, R.drawable.prospectused, R.drawable.selectioned,
	            R.drawable.eligibilityed, R.drawable.locationed, R.drawable.feeed, R.drawable.faqed};

	    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

       }
    
    private void init() {
        listview = (ListView) findViewById(R.id.listview_main);
       
        listview.setAdapter(new TypeAdater(MainActivity.this));
        listview.setDividerHeight(2);
        listview.setAdapter(new BindDataAdapter(this, drawlabeType, Type));
        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                OnItemSelected(arg2);
                Utilis.Header_Name = Type[arg2];
            }
        });

    }

    private void OnItemSelected(int pos) {
        switch (pos) {
            case 0:

              	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forms.balajisociety.org/"));
              	startActivity(intent);
              	break;

            case 1:
            	Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://balajisociety.org/SBS-Prospectus-2016-18.html"));
                startActivity(intent1);
                break;

            case 2:
            
                Intent intent2 = new Intent(MainActivity.this, AdmissionProcedure.class);
                startActivity(intent2);
                break;

            case 3:
                
                Intent intent3 = new Intent(MainActivity.this, Eligibility.class);
                startActivity(intent3);
                break;

            case 4:
                
                Intent intent4 = new Intent(MainActivity.this, Gdpicentres.class);
                startActivity(intent4);
                break;

            case 5:
                Intent intent5 = new Intent(MainActivity.this, FeeStructure.class);
                startActivity(intent5);
                break;


            case 6:
                Intent intent6 = new Intent(MainActivity.this, FAQSActivity.class);
                startActivity(intent6);
                break;

                default:
                break;
        }

    }

    public class TypeAdater extends BaseAdapter {
        private Context context;

        public TypeAdater(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return Type.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewholder;
            if (convertView == null) {
                LayoutInflater li = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = li.inflate(R.layout.layout_typerow, null);
                viewholder = new ViewHolder();
                viewholder.txtwhoname = (TextView) convertView
                        .findViewById(R.id.txt_name);

                convertView.setTag(viewholder);

            } else {

                viewholder = (ViewHolder) convertView.getTag();
            }
            viewholder.txtwhoname.setText(Type[position]);
            return convertView;
        }

        public class ViewHolder {
            public TextView txtwhoname;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
