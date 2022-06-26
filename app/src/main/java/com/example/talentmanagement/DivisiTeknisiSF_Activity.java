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

public class DivisiTeknisiSF_Activity extends AppCompatActivity{

    TextView tvSoal;
    RadioGroup rgSoal;
    RadioButton btnBenar, btnSalah;

    int nomor = 0;
    public static int hasilTeknisiSF, benar, salah;

    //pertanyaan
    String[] soalTeknisiSF = new String[]{
            "36. Presiden Indonesia yang keenam adalah",
            "37. Lambang Negara Indonesia adalah",
            "38. Ibukota Indonesia adalah",
            "39. Lagu Kebangsaan Indonesia adalah",
            "40. Bendera Negara Indonesia adalah"
    };
    //pilihan jawaban
    String[] pilihanTeknisiSF = new String[]{
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
    };
    //jawaban benar
    String[] jawabanTeknisiSF = new String[]{
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

        tvSoal.setText(soalTeknisiSF[nomor]);
        btnBenar.setText(jawabanTeknisiSF[0]);
        btnSalah.setText(jawabanTeknisiSF[1]);

        rgSoal.check(0);
        benar = 0;
        salah = 0;
    }

    public void btnNext(View view) {
        if (btnBenar.isChecked() || btnSalah.isChecked()) {

            RadioButton jawaban_user = findViewById(rgSoal.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rgSoal.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawabanTeknisiSF[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < soalTeknisiSF.length) {
                tvSoal.setText(soalTeknisiSF[nomor]);
                btnBenar.setText(pilihanTeknisiSF[(nomor * 2) + 0]);
                btnSalah.setText(pilihanTeknisiSF[(nomor * 2) + 1]);

            } else {
                hasilTeknisiSF = benar * 1;
                Intent selesai = new Intent(getApplicationContext(), SkorActivity.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Jawab dulu maszeh...",Toast.LENGTH_LONG).show();
        }
    }
}