package com.example.talentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View .OnClickListener{

    EditText etNama, etJurusan;
    RadioButton jkPria, jkWanita;
    Button btnMasuk;
    String nama, jenkel, jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.etNama);
        etJurusan = findViewById(R.id.etJurusan);
        jkPria = findViewById(R.id.jkPria);
        jkWanita = findViewById(R.id.jkWanita);

        btnMasuk = findViewById(R.id.btnMasuk);
        btnMasuk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
            switch (view.getId()){
                case R.id.btnMasuk:
                    nama = etNama.getText().toString();
                    jurusan = etJurusan.getText().toString();
                    jenkel = jkPria.getText().toString();
                    jenkel = jkWanita.getText().toString();

                    if (jkPria.isChecked()){
                        jenkel ="Pria";
                    }
                    if (jkWanita.isChecked()){
                        jenkel ="Wanita";
                    }

                    Intent intent = new Intent(this, DivisiSiaranCF_Activity.class);
                    startActivity(intent);
                    break;
            }Toast.makeText(this,"Selamat mengerjakan...",Toast.LENGTH_LONG).show();
    }
}