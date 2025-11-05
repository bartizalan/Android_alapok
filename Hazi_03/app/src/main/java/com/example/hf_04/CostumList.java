package com.example.hf_04;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CostumList extends ArrayAdapter {
    private Activity context;
    private String[] name;
    private String[] rov;
    private Integer[] image;
    private String[] buy;
    private String[] sell;


    public CostumList(@NonNull Activity context, String[] name, String[] rov, Integer[] image, String[] buy, String[] sell) {
        super(context, R.layout.list_item, name);
        this.context = context;
        this.name = name;
        this.rov = rov;
        this.image = image;
        this.buy = buy;
        this.sell = sell;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView neve = listViewItem.findViewById(R.id.name);
        TextView rovid = listViewItem.findViewById(R.id.rov);
        TextView vesz = listViewItem.findViewById(R.id.buy);
        TextView ad = listViewItem.findViewById(R.id.sell);
        ImageView zaszlo = listViewItem.findViewById(R.id.flag);

        neve.setText(name[position]);
        rovid.setText(rov[position]);
        vesz.setText(buy[position]);
        ad.setText(sell[position]);
        zaszlo.setImageResource(image[position]);

        return listViewItem;


    }



}
