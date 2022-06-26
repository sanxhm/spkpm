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

public class DivisiSiaranSF_Activity extends AppCompatActivity{

    TextView tvSoal;
    RadioGroup rgSoal;
    RadioButton btnBenar, btnSalah;

    int nomor = 0;
    public static int hasilSiaranSF, benar, salah;

    //pertanyaan
    String[] soalSiaranSF = new String[]{
            "6. Presiden Indonesia yang keenam adalah",
            "7. Lambang Negara Indonesia adalah",
            "8. Ibukota Indonesia adalah",
            "9. Lagu Kebangsaan Indonesia adalah",
            "10. Bendera Negara Indonesia adalah"
    };
    //pilihan jawaban
    String[] pilihanSiaranSF = new String[]{
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
            "Benar", "Salah",
    };
    //jawaban benar
    String[] jawabanSiaranSF = new String[]{
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

        tvSoal.setText(soalSiaranSF[nomor]);
        btnBenar.setText(jawabanSiaranSF[0]);
        btnSalah.setText(jawabanSiaranSF[1]);

        rgSoal.check(0);
        benar = 0;
        salah = 0;
    }

    public void btnNext(View view) {
        if (btnBenar.isChecked() || btnSalah.isChecked()) {

            RadioButton jawaban_user = findViewById(rgSoal.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rgSoal.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawabanSiaranSF[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < soalSiaranSF.length) {
                tvSoal.setText(soalSiaranSF[nomor]);
                btnBenar.setText(pilihanSiaranSF[(nomor * 2) + 0]);
                btnSalah.setText(pilihanSiaranSF[(nomor * 2) + 1]);

            } else {
                hasilSiaranSF = benar * 1;
                Intent selesai = new Intent(getApplicationContext(), DivisiMdCF_Activity.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Jawab dulu maszeh...",Toast.LENGTH_LONG).show();
        }
    }
}