package com.example.buah;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class AdapterBuah extends ArrayAdapter {
    private final String namabuah[];
    private final String ket_buah[];
    private final int gambar_buah[];
    private final String hargabuah[];
    private final Activity activity;

    //menampilkan harga buah
    public AdapterBuah(MainActivity activity,String[] namabuah, int[] gambar_buah,String[] ket_buah,String[] hargabuah) {
        super(activity,R.layout.list_item,namabuah);
        this.namabuah = namabuah;
        this.ket_buah = ket_buah;
        this.gambar_buah = gambar_buah;
        this.hargabuah = hargabuah;
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View tampil=inflater.inflate(R.layout.list_item,null,true);

        ImageView gambarnya;
        TextView nama_buah;

        gambarnya=tampil.findViewById(R.id.gambar_buah);
        nama_buah=tampil.findViewById(R.id.nama_buah);



        gambarnya.setImageResource(gambar_buah[position]);
        nama_buah.setText(namabuah[position]);
        
        return tampil;
    }
}
