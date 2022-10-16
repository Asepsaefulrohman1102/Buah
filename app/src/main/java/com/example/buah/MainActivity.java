package com.example.buah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String nama_buah[]={"Mangga","Alpukat","Delima","Pisang","Kiwi","Jambu","Semangka","Naga","Pepaya","Nanas","Salak",
            "Kelengkeng","Strawberry","Jeruk","Apel","Anggur","Durian"};

    int gambar_buah[]={R.drawable.mangga,R.drawable.alpukat,R.drawable.delima,R.drawable.pisang,
            R.drawable.kiwi,R.drawable.jambu,R.drawable.semangka,R.drawable.naga,R.drawable.pepaya,
            R.drawable.nanas,R.drawable.salak,R.drawable.kelengkeng,R.drawable.strawbery,R.drawable.jeruk,
            R.drawable.apel, R.drawable.anggur,R.drawable.durian};

    String keterangan[]={"Mangga atau mempelam adalah nama sejenis buah, demikian pula nama pohonnya. Mangga termasuk ke dalam genus Mangifera, yang terdiri dari 35-40 anggota dari famili Anacardiaceae.\n\n" +
            "Buah Mangga Sendiri Mempunyai banyak manfaat sebagai berikut :\n1. Menjaga Kesehatan Mata\n2. Melindungi dari kanker\n3. Menurunkan resiko diabetes\n4. Menjaga kesehatan rambut\n5. Meningkatkan kekebalan tubuh",

            "Alpukat merupakan jenis buah yang memiliki kandungan lemak tinggi, sekitar 20 kali lebih tinggi dibanding buah-buahan lain.\n\n" +
            "Buah Alpukat mempunyai banyak manfaat yang luar biasa bagi kesehatan, antara lain:\n1. Menjaga berat badan\n2. Memelihara kesehatan jantung\n3. Menjaga kesehatan mata\n4. Mencegah dan mengatasi sembelit\n5. Mengontrol tekanan darah",

            "Buah dengan nama latin Punica granatum ini merupakan jenis buah yang masuk ke dalam kelompok berry. Buah delima diketahui mengandung berbagai nutrisi yang dibutuhkan oleh tubuh, seperti protein, karbohidrat, serat, dan vitamin, termasuk vitamin C, vitamin B kompleks, folat, vitamin E, serta vitamin K. Buah delima juga mengandung beraneka mineral, di antaranya kalium, magnesium, zinc, dan tembaga, serta kaya antioksidan polifenol, termasuk kantosianin. Tak hanya itu, buah delima juga rendah kalori dan lemak, sehingga relatif aman untuk dikonsumsi tiap hari.\n\n" +
            "Berikut ini adalah beberapa manfaat buah delima yang penting untuk diketahui :\n1. Mencegah penyakit jantung\n2. Mencegah kanker\n3. Mengurangi kolesterol jahat\n4. Mengurangi risiko penyakit radang sendi\n5. Mendukung kesehatan otot\n6. Menghambat pertumbuhan sel kanker\n7. Mencegah dehidrasi",

            "Pisang adalah kelompok tanaman herba yang berbuah dan diketahui berasal dari kawasan tropis. Tanaman ini juga tergolong dalam kelompok tumbuhan monokotil atau berbiji tunggal. Di dalam buah pisang terdapat banyak sekali nutrisi sehat seperti potasium, kalium, serat, zat besi, magnesium, dan berbagai macam vitamin.\n\n" +
            "Berikut adalah berbagai manfaat kesehatan yang bisa didapatkan jika kita rajin mengonsumsi pisang, antara lain:\n1. Baik untuk kesehatan otak\n2. Sebagai sumber energi\n3. Menjaga kesehatan jantung dan pembuluh darah\n4. Mencegah kerusakan sel dan jaringan tubuh\n5. Mengurangi risiko penyakit ginjal ",

            "Kiwi adalah buah kecil yang berbentuk sawo. Selain memiliki rasa yang enak, buah kiwi memiliki banyak manfaat untuk kesehatan. Daging buahnya berwarna hijau, memiliki rasa yang manis serta kaya akan nutrisi seperti vitamin C, vitamin K, vitamin E, asam folat dan kalium.\n\n" +
            "Rasa buah kiwi yang manis dan segar tak hanya nikmat untuk disantap, tetapi juga memiliki beragam manfaat untuk kesehatan tubuh. Berikut ini adalah beberapa manfaat buah kiwi bagi kesehatan:\n1. Meredakan asma\n2. Menjaga kesehatan pencernaan\n3. Meningkatkan daya tahan tubuh\n4. Menurunkan tekanan darah\n5. Menurunkan risiko terjadinya pembekuan darah",

            "Jambu biji dikenal sebagai buah tropis yang banyak tumbuh di Meksiko, Amerika Tengah, Karibia, dan Amerika Selatan. Buah yang juga disebut guava ini telah banyak dibudidayakan dan dapat dinikmati di banyak negara beriklim tropis dan subtropis, termasuk Indonesia.Jambu biji dapat dikonsumsi langsung ataupun dijadikan berbagai olahan, seperti jus buah dan selai. Tak hanya buahnya, daun jambu biji juga sering kali dimanfaatkan untuk berbagai pengobatan, mulai dari gangguan pada saluran cerna hingga diabetes.\n\n" +
            "Berkat kandungan nutrisinya yang melimpah, ada beberapa manfaat jambu biji yang dapat Anda ambil, di antaranya :\n1. Melancarkan saluran pencernaan\n2. Memperkuat daya tahan tubuh\n3. Menurunkan tekanan darah dan kolesterol\n4. Mencegah diabetes\n5. Menjaga kesehatan mata",

            "Semangka merupakan salah satu buah yang cukup banyak dikonsumsi masyarakat Indonesia. Rasanya yang lezat dan kandungan air yang tinggi membuat semangka sering dikonsumsi untuk mengusir rasa haus di tengah cuaca panas.Semangka juga mengandung asam amino citrulline dan berbagai jenis antioksidan, seperti beta karoten, likopen, dan cucurbitacin E.\n\n" +
            "Berkat kandungan nutrisinya yang melimpah, ada beberapa manfaat yang dapat Anda peroleh dari mengonsumsi semangka, di antaranya :\n1. Menyehatkan saluran cerna\n2. Mencegah dehidrasi\n3. Memelihara kesehatan sendi\n4. Memelihara kesehatan jantung\n5. Menangkal efek radikal bebas",

            "Buah naga merah merupakan salah satu buah yang banyak dikonsumsi oleh masyarakat Indonesia. Selain harganya terjangkau, buah ini juga mudah ditemukan, baik di supermarket atau pedagang tradisional. Rasa yang manis dengan kandungan air yang banyak dan daging buah yang bertekstur lembut, membuat buah ini nikmat disantap terutama saat cuaca sedang panas. Selain bisa memanjakan lidah, buah naga juga menyimpan beragam manfaat untuk kesehatan tubuh. Oleh karena itu, sayang rasanya jika melewatkan beragam manfaat dari buah yang masih satu keluarga dengan kaktus ini.\n\n" +
            "Ada beberapa manfaat buah naga merah untuk kesehatan yang dapat diperoleh dengan mengonsumsinya secara teratur, antara lain :\n1. Mencegah anemia\n2. Memelihara kesehatan tulang\n3. Merangsang pembentukan kolagen\n4. Mencegah migrain\n5. Melindungi tubuh dari radikal bebas",

            "Pepaya, atau battek adalah tumbuhan yang diperkirakan berasal dari Meksiko bagian selatan dan bagian utara dari Amerika Selatan. Pepaya kini telah menyebar luas dan banyak ditanam di seluruh daerah tropis untuk diambil buahnya.\n\n" +
            "Sebagian orang mungkin mengenal pepaya hanya sebagai buah yang dapat melancarkan pencernaan saja. Padahal, sebenarnya ada beragam manfaat lain dari buah pepaya dan baik untuk kesehatan tubuh, antara lain :\n1. Menjaga kesehatan mata\n2. Memelihara kesehatan rambut dan kuku\n3. Memulihkan kulit yang terbakar sinar matahari\n4. Menjaga kesehatan kulit\n5. Melancarkan pencernaan",

            "Nanas adalah buah yang tergolong rendah kalori namun memiliki nutrisi yang berlimpah. Nanas juga memiliki kandungan vitamin C, mangan, tembaga, folat, kalium, magnesium, niasin, zat besi, dan vitamin A.\n\n" +
            "Karena mengandung beragam nutrisi penting, konsumsi buah nanas dapat membawa banyak manfaat untuk kesehatan. Berikut ini adalah beberapa di antaranya :\n1. Meningkatkan imunitas tubuh\n2. Mengatasi gangguan pencernaan\n3. Membantu menjaga kesehatan kulit dan tulang\n4. Mengurangi peradangan\n5. Menurunkan berat badan",

            "Salacca zalacca atau dikenal dengan buah salak merupakan buah tropis yang juga menjadi buah asli Indonesia. Salak awalnya ditemukan tumbuh liar di alam di Jawa bagian barat daya dan Sumatra bagian selatan.Di balik kulitnya yang bersisik, salak memiliki beragam khasiat bagi kesehatan. Manfaatnya dapat diperoleh karena buah satu ini tidak hanya mengandung karbohidrat dan serat yang tinggi, tapi juga beragam vitamin dan mineral penting seperti vitamin B2, vitamin C, kalium, kalsium, fosfor, folat, dan zat besi.\n\n" +
            "Manfaat salak bagi kesehatan ada beragam. Berikut ini adalah beberapa di antaranya :\n1. Meningkatkan daya tahan tubuh\n2. Mencerahkan kulit\n3. Meningkatkan daya ingat\n4. Menurunkan berat badan\n5. Mengontrol diabetes",

            "Buah kelengkeng adalah salah satu jenis buah yang banyak disukai oleh masyarakat Indonesia. Meskipun memiliki ukuran yang kecil, buah kelengkeng ternyata memberikan banyak manfaat bagi kesehatan tubuh. Buah yang bisa Anda temukan di Asia Tenggara ini memiliki rasa yang manis.Buah kelengkeng diketahui kaya akan nutrisi, seperti serat, kalsium, zat besi, vitamin B, vitamin C, kalium, serta antioksidan polifenol dan flavonoid. Berbagai nutrisi inilah yang membuat buah kelengkeng dapat memberikan beragam manfaat bagi kesehatan tubuh.\n\n" +
            "Berikut ini adalah beberapa manfaat buah kelengkeng yang dapat Anda peroleh :\n1. Menjaga berat badan\n2. Meningkatkan daya tahan tubuh\n3. Menangkal efek radikal bebas\n4. Menjaga kesehatan mata dan kulit\n5. Menjaga Kesehatan Otak",

            "Strawberry merupakan salah satu jenis buah beri yang mudah ditemukan di Indonesia. Buah ini berwarna merah terang dan memiliki perpaduan rasa manis dan asam. Selain dikonsumsi secara langsung, buah stroberi juga dapat diolah menjadi berbagai jenis produk makanan, seperti selai, sirop, dan kue. Strawberry juga mengandung magnesium, kalium, zat besi, dan beragam jenis antioksidan, seperti antosianin dan ellagitannins. Kandungan zat besi dan antioksidan tersebut juga dapat digunakan untuk memperbaiki rambut yang rusak, melembapkan, serta menjadikan rambut terasa halus.\n\n" +
            "Berkat kandungan nutrisinya yang beragam, ada beberapa manfaat stroberi yang dapat diperoleh dengan mengonsumsinya secara rutin, yaitu:\n1. Menurunkan kadar kolesterol dalam tubuh\n2. Menyehatkan saluran cerna\n3. Menjaga tekanan darah tetap stabil\n4. Mengontrol kadar gula darah\n5. Menurunkan berat badan\n6. Mencegah penyakit jantung",

            "Jeruk adalah buah yang memiliki bentuk yang bulat dan kulit yang berwarna oranye. Aroma yang khas dikeluarkan oleh jeruk pun sangat kuat sehingga kita dapat dengan mudah menebak buah jeruk tanpa harus melihatnya hanya dengan mencium aromanya. Buah jeruk ini memiliki berbagai macam jenis ukuran yaitu, kecil, sedang, hingga besar.Buah jeruk dikenal sebagai salah satu buah dengan kandungan vitamin C yang tinggi. Padahal, selain vitamin C, buah ini juga mengandung beragam gizi lain, seperti vitamin A, karbohidrat, serat, protein, kalsium, zat besi, magnesium, fosfor, kalium, folat, serta kolin.\n\n" +
            "ada beberapa manfaat yang bisa kamu dapatkan dengan mengonsumsi buah jeruk, yaitu :\n1. Meningkatkan daya tahan tubuh\n2. Mencegah anemia\n3. Menjaga kesehatan jantung\n4. Membantu mencukupi kebutuhan cairan tubuh\n5. Mendukung kesehatan sistem cerna",

            "Apel merupakan jenis buah-buahan, atau buah yang dihasilkan dari pohon buah apel. Buah apel biasanya berwarna merah kulitnya jika masak dan, namun bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek dan daging buahnya keras. Buah apel memiliki beberapa biji di dalamnya.  Buah apel diketahui rendah kalori serta mengandung beragam vitamin dan mineral, seperti vitamin A, vitamin B6, vitamin C, dan kalium. Tak hanya itu, buah apel juga mengandung antioksidan, seperti flavonoid, dan pektin yang baik bagi kesehatan tubuh dan mencegah berbagai penyakit. Anda bisa mengonsumsi buah apel dengan berbagai cara, baik dimakan langsung, dibuat jus, atau dijadikan salad buah.\n\n" +
            "Ada beberapa manfaat yang bisa Anda peroleh dari mengonsumsi buah apel, di antaranya :\n1. Menjaga kesehatan saluran pencernaan\n2. Menjaga kesehatan dan fungsi jantung\n3. Menurunkan risiko terkena diabetes\n4. Menjaga kesehatan otak\n5. Mengatasi bau mulut",

            "Anggur merupakan tanaman buah berupa perdu merambat yang termasuk ke dalam keluarga Vitaceae. Buah ini biasanya digunakan untuk membuat jus anggur, jelly, minuman anggur, minyak biji anggur dan kismis, atau dimakan langsung. Buah anggur mengandung polifenol, yaitu senyawa pemberi warna cerah pada buah. Kandungan antioksidan polifenol dalam buah yang sudah ditanam sejak 6.000-8.000 tahun lalu ini, memberi tubuh perlindungan dari penyakit dan kerusakan akibat faktor lingkungan, serta membantu melawan radikal bebas.\n\n" +
            "Ada beberapa manfaat buah anggur yang bisa Anda rasakan, di antaranya :\n1. Mengatasi gangguan pembuluh darah dan jantung\n2. Mencegah penyakit kanker\n3. Mengurangi gejala insufisiensi vena kronis\n4. Menurunkan tekanan darah tinggi\n5. Meningkatkan daya ingat\n6. Melindungi retina mata\n7. Memperlambat penuaan",

            "Durian adalah nama tumbuhan tropis yang berasal dari wilayah Asia Tenggara, sekaligus nama buahnya yang bisa dimakan. Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri.Meski berduri dan memiliki bau yang cukup tajam, buah durian mengandung berbagai macam nutrisi penting, seperti antioksidan, karbohidrat, serat, protein, lemak, vitamin A, vitamin C, magnesium, dan fosfor. Nutrisi tersebut diketahui baik untuk kesehatan tubuh Anda.\n\n" +
            "Ada beberapa manfaat buah durian yang bisa anda rasakan, di antaranya :\n1. Membantu meredakan gejala penyakit liver\n2. Meredakan gejala tekanan darah tinggi\n3. Membantu meringankan gejala malaria\n4. Meredakan demam\n5. Mempercepat penyembuhan luka\n6. Meningkatkan gairah seksual"
    };

    String harga_buah[]={"10.000","12.000","13.000","14.000","15.000","16.000","17.000","18.000","19.000","20.000","21.000","22.000","23.000","24.000","25.000","26.000","27.000"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=(ListView) findViewById(R.id.listdatabuah);
        AdapterBuah adapterBuah = new AdapterBuah(this,nama_buah,gambar_buah,keterangan,harga_buah);
        listView.setAdapter(adapterBuah);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nm_buah=nama_buah[position].toString();
                int gbr_buah=gambar_buah[position];
                String ket=keterangan[position].toString();
                String hrg=harga_buah[position].toString();

//                Toast.makeText(MainActivity.this,""+nm_buah.trim(),Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity.this,""+gbr_buah,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailBuah.class);
                intent.putExtra("namabuah",nm_buah);
                intent.putExtra("gambarbuah",gbr_buah);
                intent.putExtra("keter",ket);
                intent.putExtra("hargabuah",hrg);
                startActivity(intent);
            }
        });
    }




}
