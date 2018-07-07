package com.hbck.txt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * ListView适配器
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<TxtBean> list;

    public MyAdapter(Context mContext, List<TxtBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvName.setText(list.get(position).getFileName());
        holder.tvSize.setText(list.get(position).getFileSize());
        return convertView;
    }

    private static class ViewHolder {
        public TextView tvName;
        public TextView tvSize;

        public ViewHolder(View view) {
            this.tvName = (TextView) view.findViewById(R.id.tv_name);
            this.tvSize = (TextView) view.findViewById(R.id.tv_size);
        }
    }
}