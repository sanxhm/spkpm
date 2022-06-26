package com.example.talentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DivisiSiaranCF_Activity extends AppCompatActivity{

    TextView tvSoal;
    RadioGroup rgSoal;
    RadioButton btnBenar, btnSalah;

    int nomor = 0;
    public static int hasilSiaranCF, benar, salah;

    //pertanyaan
    String[] soalSiaranCF = new String[]{
            "1. Presiden Indonesia yang keenam adalah",
            "2. Lambang Negara Indonesia adalah",
            "3. Ibukota Indonesia adalah",
            "4. Lagu Kebangsaan Indonesia adalah",
            "5. Bendera Negara Indonesia adalah"
    };
    //pilihan jawaban
    String[] pilihanSiaranCF = new String[]{
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
    };
    //jawaban benar
    String[] jawabanSiaranCF = new String[]{
            "Benar",
            "Salah",
            "Benar",
            "Salah",
            "Benar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisi_siaran_cf);

        tvSoal = findViewById(R.id.tvSoal);
        rgSoal = findViewById(R.id.rgSoal);
        btnBenar = findViewById(R.id.btnBenar);
        btnSalah = findViewById(R.id.btnSalah);

        tvSoal.setText(soalSiaranCF[nomor]);
        btnBenar.setText(jawabanSiaranCF[0]);
        btnSalah.setText(jawabanSiaranCF[1]);

        rgSoal.check(0);
        benar = 0;
        salah = 0;
    }

    public void btnNext(View view) {
        if (btnBenar.isChecked() || btnSalah.isChecked()) {

            RadioButton jawaban_user = findViewById(rgSoal.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rgSoal.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawabanSiaranCF[nomor])) benar++;
                else salah++;
                nomor++;
            if (nomor < soalSiaranCF.length) {
                tvSoal.setText(soalSiaranCF[nomor]);
                btnBenar.setText(pilihanSiaranCF[(nomor * 2) + 0]);
                btnSalah.setText(pilihanSiaranCF[(nomor * 2) + 1]);
            } else {
                hasilSiaranCF = benar * 1;
                Intent selesai = new Intent(getApplicationContext(), DivisiSiaranSF_Activity.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Jawab dulu maszeh...",Toast.LENGTH_LONG).show();
        }
    }
}