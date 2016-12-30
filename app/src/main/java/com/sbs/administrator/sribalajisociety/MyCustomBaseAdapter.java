package com.sbs.administrator.sribalajisociety;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomBaseAdapter extends BaseAdapter {
    private static ArrayList<SearchResults> searchArrayList;

    private LayoutInflater mInflater;
    int i = 0;

    //ListModel tempValues=null;
    public MyCustomBaseAdapter(Context context, ArrayList<SearchResults> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        //if(searchArrayList()<=0)
        //return 1;
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.txtdesignationName = (TextView) convertView.findViewById(R.id.designname);
            holder.txttphoneno = (TextView) convertView.findViewById(R.id.telephone);
            holder.txtfaxno = (TextView) convertView.findViewById(R.id.faxno);
            holder.emailid = (TextView) convertView.findViewById(R.id.emailId);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (searchArrayList.get(position).getdesignationname() != null) {
            holder.txtdesignationName.setText(searchArrayList.get(position).getdesignationname());
        }
        if (searchArrayList.get(position).gettelephone() != null) {

            holder.txttphoneno.setText(searchArrayList.get(position).gettelephone());
        }
        if (searchArrayList.get(position).getfaxno() != null) {
            holder.txtfaxno.setText(searchArrayList.get(position).getfaxno());
        }
        if (searchArrayList.get(position).getemaild() != null) {
            holder.emailid.setText(searchArrayList.get(position).getemaild());
        }

        return convertView;
    }

    static class ViewHolder {
        TextView txtdesignationName;
        TextView txttphoneno;
        TextView txtfaxno;
        TextView emailid;

    }
}
