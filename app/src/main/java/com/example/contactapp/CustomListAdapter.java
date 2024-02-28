package com.example.contactapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final Integer[] foto;
    private final String[] nama;
    private final String[] telepon;

    public CustomListAdapter(Activity context, Integer[] foto, String[] nama, String[] telepon) {
        super(context, R.layout.activity_item, nama);
        this.context = context;
        this.foto = foto;
        this.nama = nama;
        this.telepon = telepon;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.activity_item, null, true);

        ImageView ivFoto = (ImageView) row.findViewById(R.id.ivFoto);
        TextView tvNama = (TextView) row.findViewById(R.id.tvNama);
        TextView tvTelepon = (TextView) row.findViewById(R.id.tvTelepon);

        ivFoto.setImageResource(foto[position]);
        tvNama.setText(nama[position]);
        tvTelepon.setText(telepon[position]);

        return row;
    }
}
