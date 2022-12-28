package com.example.myscaleapk;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class tips extends AppCompatActivity {

    private RecyclerView recTips;
    private ArrayList<tips_desc> listTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tips);

        recTips = findViewById(R.id.recTips);
        initData();

        recTips.setAdapter(new tipsAdapter(listTips));
        recTips.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        this.listTips = new ArrayList<>();
        listTips.add(new tips_desc("Mengonsumsi makanan bergizi dengan porsi seimbang.", "Asupan makanan bergizi dengan porsi seimbang sangat penting untuk menunjang kesehatan. Selain mengonsumsi makanan yang mengenyangkan, " +
                "Anda juga harus memperhatikan kandungan gizi dari makanan tersebut. " +
                "Tubuh tak hanya membutuhkan karbohidrat, lemak, dan protein melainkan juga butuh vitamin, mineral, dan serat. " +
                "Jadi, jangan malas mengonsumsi sayuran, buah-buahan, dan kacang-kacangan untuk menyempurnakan asupan gizi bagi tubuh.", R.drawable.makanangizi));
        listTips.add(new tips_desc("Mengelola stres dan selalu berpikir positif.", "Stres berkepanjangan ternyata rentan menurunkan daya tahan tubuh sehingga membuat Anda gampang sakit. " +
                "Oleh sebab itu, Anda harus mahir mengelola stres dan selalu berpikir positif. " +
                "Anda harus menjauh atau mengatasi penyebab stres agar pikiran dan hati merasa lega. " +
                "Jangan ragu melakukan hobi atau meluangkan me time agar Anda lebih bahagia.", R.drawable.stres));
        listTips.add(new tips_desc("Rajin berolahraga.", "Rutinitas olahraga juga baik untuk meningkatkan daya tahan tubuh. Di masa pandemi ini, sebaiknya Anda meminimalkan aktivitas olahraga di luar rumah." +
                " Sebagai gantinya, Anda bisa melakukan aktivitas olahraga #DiRumahAja. " +
                "Ada berbagai jenis olahraga menarik yang dapat Anda lakukan di rumah, misalnya senam lantai, yoga, pilates, dan angkat beban.", R.drawable.olahraga));
        listTips.add(new tips_desc("Istirahat cukup dan tidur teratur.", "Jangan mengabaikan waktu istirahat bila Anda ingin senantiasa sehat dan terhindar dari risiko Covid-19. " +
                "Ketika Anda tidur, tubuh melakukan proses regenerasi sel dan memberikan jeda pada organ untuk beristirahat. Kurang tidur rentan menyebabkan daya tahan tubuh menurun, mood tidak stabil, dan kurang fokus. " +
                "Anda harus tidur minimal delapan jam sehari agar kondisi fisik dan psikis selalu prima.", R.drawable.tidur));
        listTips.add(new tips_desc("Minum air putih minimal 2 liter sehari.", "Selain makanan bergizi, asupan air yang cukup juga penting untuk mendukung metabolisme tubuh dan menjaga daya tahan tubuh." +
                " Anda harus mengonsumsi air putih minimal 2 liter sehari supaya tubuh Anda tetap sehat dan terhindar dari risiko dehidrasi serta penyakit lainnya.", R.drawable.airputih));
        listTips.add(new tips_desc("Menghentikan berbagai kebiasaan buruk.", "Beberapa kebiasaan buruk yang patut dihentikan demi memaksimalkan pola hidup sehat yaitu:\n" +
                "\n" +
                "• Konsumsi alkohol, rokok, dan junk food.\n" +
                "• Begadang atau lembur kerja hingga larut malam.\n" +
                "• Gaya hidup minim gerak (sedentari).", R.drawable.rokok));
    }

}
