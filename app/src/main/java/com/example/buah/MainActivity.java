package com.example.buah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String nama_buah[]={"Mangga","Alpukat","Pisang","Kiwi","Semangka","Pepaya","Salak",
            "Kelengkeng","Jeruk","Apel","Anggur","Durian"};

    int gambar_buah[]={R.drawable.mangga,R.drawable.alpukat,R.drawable.pisang,
            R.drawable.kiwi,R.drawable.semangka,R.drawable.pepaya,
            R.drawable.salak,R.drawable.kelengkeng,R.drawable.jeruk,
            R.drawable.apel, R.drawable.anggur,R.drawable.durian};

    String keterangan[]={"Mangga atau mempelam adalah nama sejenis buah, demikian pula nama pohonnya. Mangga termasuk ke dalam genus Mangifera, yang terdiri dari 35-40 anggota dari famili Anacardiaceae.",
            "Alpukat merupakan jenis buah yang memiliki kandungan lemak tinggi, sekitar 20 kali lebih tinggi dibanding buah-buahan lain.",
            "Pisang adalah kelompok tanaman herba yang berbuah dan diketahui berasal dari kawasan tropis. Tanaman ini juga tergolong dalam kelompok tumbuhan monokotil atau berbiji tunggal.",
            "Kiwi adalah buah kecil yang berbentuk sawo. Selain memiliki rasa yang enak, buah kiwi memiliki banyak manfaat untuk kesehatan. Daging buahnya berwarna hijau, memiliki rasa yang manis serta kaya akan nutrisi seperti vitamin C, vitamin K, vitamin E, asam folat dan kalium.",
            "Semangka adalah tanaman merambat yang berasal dari daerah setengah gurun di Afrika bagian selatan. Tanaman ini masih sekerabat dengan labu-labuan, melon dan ketimun.",
            "Pepaya, atau battek adalah tumbuhan yang diperkirakan berasal dari Meksiko bagian selatan dan bagian utara dari Amerika Selatan. Pepaya kini telah menyebar luas dan banyak ditanam di seluruh daerah tropis untuk diambil buahnya.",
            "Salacca zalacca atau dikenal dengan buah salak merupakan buah tropis yang juga menjadi buah asli Indonesia. Salak awalnya ditemukan tumbuh liar di alam di Jawa bagian barat daya dan Sumatra bagian selatan.",
            "Buah kelengkeng adalah salah satu jenis buah yang banyak disukai oleh masyarakat Indonesia. Meskipun memiliki ukuran yang kecil, buah kelengkeng ternyata memberikan banyak manfaat bagi kesehatan tubuh. Buah yang bisa Anda temukan di Asia Tenggara ini memiliki rasa yang manis.",
            "Jeruk adalah buah yang memiliki bentuk yang bulat dan kulit yang berwarna oranye. Aroma yang khas dikeluarkan oleh jeruk pun sangat kuat sehingga kita dapat dengan mudah menebak buah jeruk tanpa harus melihatnya hanya dengan mencium aromanya. Buah jeruk ini memiliki berbagai macam jenis ukuran yaitu, kecil, sedang, hingga besar.",
            "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon buah apel. Buah apel biasanya berwarna merah kulitnya jika masak dan, namun bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya.",
            "nggur merupakan tanaman buah berupa perdu merambat yang termasuk ke dalam keluarga Vitaceae. Buah ini biasanya digunakan untuk membuat jus anggur, jelly, minuman anggur, minyak biji anggur dan kismis, atau dimakan langsung.",
            "Durian adalah nama tumbuhan tropis yang berasal dari wilayah Asia Tenggara, sekaligus nama buahnya yang bisa dimakan. Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listdatabuah);
        AdapterBuah adapterBuah = new AdapterBuah(this,nama_buah,gambar_buah,keterangan);
        listView.setAdapter(adapterBuah);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nm_buah=nama_buah[position].toString();
                int gbr_buah=gambar_buah[position];
                String ket=keterangan[position].toString();

//                Toast.makeText(MainActivity.this,""+nm_buah.trim(),Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this,""+gbr_buah,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailBuah.class);
                intent.putExtra("namabuah",nm_buah);
                intent.putExtra("gambarbuah",gbr_buah);
                intent.putExtra("keter",ket);
                startActivity(intent);
            }
        });
    }
}