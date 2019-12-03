package com.bawei.dinghongxiang20191203.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dinghongxiang20191203.model.Bean;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    List<Bean.ShopGridDataBean> list;

    public MyAdapter(List<Bean.ShopGridDataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHorlder horlder;
        if (view==null){

        }
        return view;
    }

    class ViewHorlder{
        ImageView imageView;
        TextView textView;
    }
}
