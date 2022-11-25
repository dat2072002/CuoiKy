package com.example.ktck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> sinhVienList;

    public StudentAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtTen;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;
        if (view == null ){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtTen = (TextView)  view.findViewById(R.id.textviewHoTen);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        SinhVien sinhVien = sinhVienList.get(position);
        holder.txtTen.setText(sinhVien.getHoTen());
        return view;
    }
}