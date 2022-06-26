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

public class DivisiMdSF_Activity extends AppCompatActivity{

    TextView tvSoal;
    RadioGroup rgSoal;
    RadioButton btnBenar, btnSalah;

    int nomor = 0;
    public static int hasilMdSF, benar, salah;

    //pertanyaan
    String[] soalMdSF = new String[]{
            "16. Presiden Indonesia yang keenam adalah",
            "17. Lambang Negara Indonesia adalah",
            "18. Ibukota Indonesia adalah",
            "19. Lagu Kebangsaan Indonesia adalah",
            "20. Bendera Negara Indonesia adalah"
    };
    //pilihan jawaban
    String[] pilihanMdSF = new String[]{
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
    };
    //jawaban benar
    String[] jawabanMdSF = new String[]{
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

        tvSoal.setText(soalMdSF[nomor]);
        btnBenar.setText(jawabanMdSF[0]);
        btnSalah.setText(jawabanMdSF[1]);

        rgSoal.check(0);
        benar = 0;
        salah = 0;
    }

    public void btnNext(View view) {
        if (btnBenar.isChecked() || btnSalah.isChecked()) {

            RadioButton jawaban_user = findViewById(rgSoal.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rgSoal.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawabanMdSF[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < soalMdSF.length) {
                tvSoal.setText(soalMdSF[nomor]);
                btnBenar.setText(pilihanMdSF[(nomor * 2) + 0]);
                btnSalah.setText(pilihanMdSF[(nomor * 2) + 1]);

            } else {
                hasilMdSF = benar * 1;
                Intent selesai = new Intent(getApplicationContext(), DivisiJurnalisCF_Activity.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Jawab dulu maszeh...",Toast.LENGTH_LONG).show();
        }
    }
}