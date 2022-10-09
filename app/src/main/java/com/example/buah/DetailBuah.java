package com.example.buah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBuah extends AppCompatActivity {
    ImageView gambarbuah_masuk;
    TextView namabuah_masuk,ketbuah_masuk;

    String nama_kunci="namabuah";
    String ket_kunci="keter";
    int gambarbuah;

    String namabuahnya;
    String ketbuahnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);

        gambarbuah_masuk=findViewById(R.id.gambarterima);
        namabuah_masuk=findViewById(R.id.nmbuah);
        ketbuah_masuk=findViewById(R.id.ket);

        Bundle bundle=getIntent().getExtras();

        gambarbuah=bundle.getInt(String.valueOf("gambarbuah"));
        gambarbuah_masuk.setImageResource(gambarbuah);

        namabuahnya=bundle.getString("namabuah");
        ketbuahnya=bundle.getString("keter");

        namabuah_masuk.setText(namabuahnya);
        ketbuah_masuk.setText(ketbuahnya);

    }
}