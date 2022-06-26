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

public class DivisiMdCF_Activity extends AppCompatActivity{

    TextView tvSoal;
    RadioGroup rgSoal;
    RadioButton btnBenar, btnSalah;

    int nomor = 0;
    public static int hasilMdCF, benar, salah;

    //pertanyaan
    String[] soalMdCF = new String[]{
            "11. Presiden Indonesia yang keenam adalah",
            "12. Lambang Negara Indonesia adalah",
            "13. Ibukota Indonesia adalah",
            "14. Lagu Kebangsaan Indonesia adalah",
            "15. Bendera Negara Indonesia adalah"
    };
    //pilihan jawaban
    String[] pilihanMdCF = new String[]{
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
    };
    //jawaban benar
    String[] jawabanMdCF = new String[]{
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

        tvSoal.setText(soalMdCF[nomor]);
        btnBenar.setText(jawabanMdCF[0]);
        btnSalah.setText(jawabanMdCF[1]);

        rgSoal.check(0);
        benar = 0;
        salah = 0;
    }

    public void btnNext(View view) {
        if (btnBenar.isChecked() || btnSalah.isChecked()) {

            RadioButton jawaban_user = findViewById(rgSoal.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rgSoal.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawabanMdCF[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < soalMdCF.length) {
                tvSoal.setText(soalMdCF[nomor]);
                btnBenar.setText(pilihanMdCF[(nomor * 2) + 0]);
                btnSalah.setText(pilihanMdCF[(nomor * 2) + 1]);

            } else {
                hasilMdCF = benar * 1;
                Intent selesai = new Intent(getApplicationContext(), DivisiMdSF_Activity.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Jawab dulu maszeh...",Toast.LENGTH_LONG).show();
        }
    }
}