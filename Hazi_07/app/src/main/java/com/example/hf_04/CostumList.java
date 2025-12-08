package com.example.hf_04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CostumList extends RecyclerView.Adapter<CostumList.ViewHolder> {

    private Context context;
    private String[] name;
    private String[] rov;
    private Integer[] image;
    private String[] buy;
    private String[] sell;
    private OnItemClickListener listener; // Eseményfigyelő a kattintáshoz

    // Interfész a kattintás kezeléséhez
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Konstruktor
    public CostumList(Context context, String[] name, String[] rov, Integer[] image, String[] buy, String[] sell, OnItemClickListener listener) {
        this.context = context;
        this.name = name;
        this.rov = rov;
        this.image = image;
        this.buy = buy;
        this.sell = sell;
        this.listener = listener;
    }

    // 1. lépés: A sor (CardView) layout betöltése
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Itt hivatkozol a layout fájl nevére (pl. list_item vagy amit a CardView-nál mentettél)
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    // 2. lépés: Az adatok összekötése a nézettel
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.neve.setText(name[position]);
        holder.rovid.setText(rov[position]);
        holder.vesz.setText(buy[position]);
        holder.ad.setText(sell[position]);
        holder.zaszlo.setImageResource(image[position]);

        // Kattintás esemény beállítása az adott elemre
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    // 3. lépés: Hány elem van a listában?
    @Override
    public int getItemCount() {
        return name.length;
    }

    // A ViewHolder osztály: Ez tárolja a hivatkozásokat a View elemekre
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView neve, rovid, vesz, ad;
        ImageView zaszlo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            neve = itemView.findViewById(R.id.name);
            rovid = itemView.findViewById(R.id.rov);
            vesz = itemView.findViewById(R.id.buy);
            ad = itemView.findViewById(R.id.sell);
            zaszlo = itemView.findViewById(R.id.flag);
        }
    }
}