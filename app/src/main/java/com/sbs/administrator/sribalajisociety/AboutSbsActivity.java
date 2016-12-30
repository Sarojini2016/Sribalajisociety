package com.sbs.administrator.sribalajisociety;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AboutSbsActivity extends Activity implements OnItemClickListener {
	 private ListView lvsbs;
	    private String[] Type = {"About SBS","Why Enroll" ,"AICTE Approvals", "Infrastructure", "AIU Equivalence to MBA","Campus Placement"};
	    private int[] drawlabeType = {R.drawable.aboutused,R.drawable.whysbsed,R.drawable.aicteed, R.drawable.infraed, R.drawable.equaltombaed,R.drawable.campusplacemented};
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_sbs);
        init();
    }

    private void init() {
        lvsbs = (ListView) findViewById(R.id.lvabtsbs);
        lvsbs.setAdapter(new TypeAdater(AboutSbsActivity.this));
        lvsbs.setDividerHeight(2);
        lvsbs.setAdapter(new BindDataAdapter(this, drawlabeType, Type));
        lvsbs.setOnItemClickListener(this);
    }
    private void OnItemSelected(int pos) {
    switch (pos) {
        case 0:
            Intent intent1 = new Intent(AboutSbsActivity.this, WhySBS.class);
            startActivity(intent1);
            break;
        case 1:
            Intent intent2 = new Intent(AboutSbsActivity.this, Whyenroll.class);
            startActivity(intent2);
            break;

        case 2:
            Intent intent3 = new Intent(AboutSbsActivity.this, Govtrecognized.class);
            startActivity(intent3);
            break;

        case 3:
            Intent intent4 = new Intent(AboutSbsActivity.this, Worldclassinfra.class);
            startActivity(intent4);
            break;
        case 4:
            Intent intent5 = new Intent(AboutSbsActivity.this, AIUEquivalence.class);
            startActivity(intent5);
            break;
        case 5:
        	Intent intent6 = new Intent(AboutSbsActivity.this, Campusplacement.class);
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
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
    // TODO Auto-generated method stub
    OnItemSelected(arg2);
    Utilis.Header_Name = Type[arg2];

}
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_sbs, menu);
		return true;
	}

}
