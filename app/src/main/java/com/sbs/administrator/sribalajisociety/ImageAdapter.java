package com.sbs.administrator.sribalajisociety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter  extends BaseAdapter{
	 private Context mContext;

	    // Keep all Images in array
	    public Integer[] mThumbIds = {
	            R.drawable.aboutus,
	            R.drawable.admissions, R.drawable.courses,R.drawable.impdates,
	            R.drawable.youtube, R.drawable.fb1, R.drawable.reachus,R.drawable.maps

	    };
	    public String name[] = {"About Us","Admissions","Courses","Principal Dates", "Youtube", "Facebook",  "Reach Us","Maps"};

	    // Constructor
	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    @Override
	    public int getCount() {
	        return mThumbIds.length;
	    }

	    @Override
	    public Object getItem(int position) {
	        return mThumbIds[position];
	    }

	    @Override
	    public long getItemId(int position) {
	        return 0;
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        Holder holder;
	        ImageView imageView;
	        if (convertView == null) {
	            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            holder = new Holder();
	            convertView = inflater.inflate(R.layout.gridview_row, null);
	            holder.imageview = (ImageView) convertView.findViewById(R.id.img_view);
	            holder.txtname = (TextView) convertView.findViewById(R.id.name);
	           /* imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(8, 8, 8, 8);*/
	            convertView.setTag(holder);

	        } else {
	            holder = (Holder) convertView.getTag();
	        }
	        holder.imageview.setImageResource(mThumbIds[position]);
	        //holder.imgeview.setLayoutParams(new GridView.LayoutParams((int)(xdpi-4)/2,(int)(xdpi-4)/2));
	        /*holder.imgeview.setScaleType(ImageView.ScaleType.CENTER_CROP);
			holder.imgeview.setPadding(1, 1, 1, 1);*/
	        holder.txtname.setText(name[position]);
	        return convertView;
	    }

	    private class Holder {
	        ImageView imageview;
	        TextView txtname;
	    }


}