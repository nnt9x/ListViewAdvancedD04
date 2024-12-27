package com.bkacad.edu.nnt.listviewadvancedd04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bkacad.edu.nnt.listviewadvancedd04.R;
import com.bkacad.edu.nnt.listviewadvancedd04.model.Food;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    // Thuoc tinh
    private Context context;
    private List<Food> data;

    // Phuong thuc khoi tao
    public MyAdapter(Context context, List<Food> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        }
        // View va bind Id
        ImageView img = convertView.findViewById(R.id.img_item_view);
        TextView tvName = convertView.findViewById(R.id.tv_item_view_name);
        TextView tvPrice = convertView.findViewById(R.id.tv_item_view_price);
        // Do du lieu vao view
        Food food = data.get(position);
        tvName.setText(food.getName());
        tvPrice.setText("" + food.getPrice() + " đ");
        Glide.with(convertView).load(food.getImage()).into(img);

        return convertView;
    }
}
