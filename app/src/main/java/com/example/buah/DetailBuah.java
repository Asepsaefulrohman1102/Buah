package com.example.buah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBuah extends AppCompatActivity {
    ImageView gambarbuah_masuk;
    TextView namabuah_masuk,ketbuah_masuk,hargabuah_masuk,totalterima_masuk;

    String nama_kunci="namabuah";
    String ket_kunci="keter";
    int gambarbuah;
    //menampilkan harga buah
    String harga_kunci="hargabuah";

    String namabuahnya;
    String ketbuahnya;
    //menampilkan harga buah
    String hargabuahnya;

    EditText quantity;
    int count = 0;
    double total;
    Button btn_increment,btn_decrement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);

        quantity = (EditText) findViewById(R.id.quantity);

        btn_increment = (Button) findViewById(R.id.btn_increment);
        btn_decrement = (Button) findViewById(R.id.btn_decrement);

        //menampilkan total harga dari quantity
        btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                quantity.setText(Integer.toString(count));
                total = count * Double.parseDouble(hargabuahnya);
                totalterima_masuk.setText("Rp. " + total + "00");
            }
        });

        btn_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    count--;
                    quantity.setText(Integer.toString(count));
                    total = count * Double.parseDouble(hargabuahnya);
                    totalterima_masuk.setText("Rp. " + total + "00");
                }
            }
        });


        //lama
        gambarbuah_masuk=findViewById(R.id.gambarterima);
        namabuah_masuk=findViewById(R.id.nmbuah);
        ketbuah_masuk=findViewById(R.id.ket);
        hargabuah_masuk=findViewById(R.id.hargaterima);

        //menampilkan total harga dari quantity
        totalterima_masuk=findViewById(R.id.Totalterima);



        Bundle bundle=getIntent().getExtras();

        gambarbuah=bundle.getInt(String.valueOf("gambarbuah"));
        gambarbuah_masuk.setImageResource(gambarbuah);

        namabuahnya=bundle.getString("namabuah");
        ketbuahnya=bundle.getString("keter");

        //menampilkan harga buah
        hargabuahnya=bundle.getString("hargabuah");
    

        //menampilkan total harga dari quantity
        totalterima_masuk.setText("Rp. " + total);
        

        namabuah_masuk.setText(namabuahnya);
        ketbuah_masuk.setText(ketbuahnya);
        hargabuah_masuk.setText(hargabuahnya);
    }

    public void Increment(View v) {
        count++;
        quantity.setText("" + count);
    }

    public void Decrement(View v){
        if (count <= 0) count = 0;
        else count--;
        quantity.setText("" + count);
    }
}
