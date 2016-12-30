package com.sbs.administrator.sribalajisociety;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BindDataAdapter extends BaseAdapter {
    Activity mLocal;
    int[] imgArray;
    String titleA[];
    LayoutInflater mLayoutInflater;

    public BindDataAdapter(Activity activity, int[] imageArray, String[] title) {
        mLocal = activity;
        imgArray = imageArray;
        titleA = title;
        mLayoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return imgArray.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    private class Holder {
        ImageView image;
        TextView textView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.activity_main, null);
            holder = new Holder();
            holder.image = (ImageView) convertView.findViewById(R.id.iamge);
            holder.textView = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.image.setBackgroundResource(imgArray[position]);
        holder.textView.setText(titleA[position]);
        return convertView;
    }

}
