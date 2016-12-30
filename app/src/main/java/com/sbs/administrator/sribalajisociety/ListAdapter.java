package com.sbs.administrator.sribalajisociety;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ListAdapter extends ArrayAdapter<Data> {

    private List<Data> items;
    private LayoutInflater mInflater;
    private ViewHolder holder;

    public ListAdapter(Context context, List<Data> items) {
        super(context, 0, items);
        this.items = items;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Data> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        if (this.items != null) {
            return this.items.size();
        } else {
            return 0;
        }
    }

    @Override
    public Data getItem(int position) {
        if (this.items != null) {
            return items.get(position);
        } else {
            return null;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.row, null);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            holder.tvSubTitle = (TextView) convertView.findViewById(R.id.txtSubTitle);
            holder.tvPhone = (TextView) convertView.findViewById(R.id.txtPhone);
            holder.tvFax = (TextView) convertView.findViewById(R.id.txtFax);
            holder.tvEmail = (TextView) convertView.findViewById(R.id.txtEmail);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convertView.setTag(holder);

        Data data = items.get(position);

        holder.tvTitle.setText(data.getHeader());
        holder.tvSubTitle.setText(data.getSubHeader());
        holder.tvPhone.setText(data.getMobile());
        holder.tvFax.setText(data.getFax());
        holder.tvEmail.setText(data.getEmail());
        return convertView;
    }

    public static class ViewHolder {
        public TextView tvTitle;
        public TextView tvSubTitle;
        public TextView tvPhone;
        public TextView tvFax;
        public TextView tvEmail;
    }
}
