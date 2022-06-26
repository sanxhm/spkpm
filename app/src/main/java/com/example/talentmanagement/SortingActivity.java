package com.example.talentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.example.talentmanagement.DivisiSiaranCF_Activity.hasilSiaranCF;

public class SortingActivity extends AppCompatActivity implements View.OnClickListener {

    static float arraySkorCF[], maxCF, arraySkorSF[], maxSF,
            siaranCF, siaranSF, mdCF, mdSF, jurnalisCF, jurnalisSF,
            teknisiCF, teknisiSF, siaranCFGAP, siaranSFGAP, mdCFGAP, mdSFGAP,
            jurnalisCFGAP, jurnalisSFGAP, teknisiCFGAP, teknisiSFGAP, siaranNA,mdNA,
            jurnalisNA,teknisiNA;

    RecyclerView rvSorting;
    SortingAdapter adapter;
    Button btnSurvey, btnRestart, btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting);

        rvSorting = findViewById(R.id.rvSorting);
        setRecycleView();

        btnRestart = findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(this);

        btnKeluar = findViewById(R.id.btnKeluar);
        btnKeluar.setOnClickListener(this);

        siaranCF = getIntent().getIntExtra("hasilSiaran",0);
        siaranSF = getIntent().getIntExtra("hasilSiaranSF", 0);
        mdCF = getIntent().getIntExtra("hasilMdCF", 0);
        mdSF = getIntent().getIntExtra("hasilMdSF", 0);
        jurnalisCF = getIntent().getIntExtra("hasilJurnalisCF", 0);
        jurnalisSF = getIntent().getIntExtra("hasilJurnalisSF", 0);
        teknisiCF = getIntent().getIntExtra("hasilTeknisiCF", 0);
        teknisiSF = getIntent().getIntExtra("hasilTeknisiSF", 0);

        arraySkorCF = new float[4];
        arraySkorCF[0] = siaranCF;
        arraySkorCF[1] = mdCF;
        arraySkorCF[2] = jurnalisCF;
        arraySkorCF[3] = teknisiCF;

        maxCF = arraySkorCF[0];

        for (int c = 0; c < 4; c++) {
            if (arraySkorCF[c] > maxCF) {
                maxCF = arraySkorCF[c];
                c++;
            }
        }
        arraySkorSF = new float[4];
        arraySkorSF[0] = siaranSF;
        arraySkorSF[1] = mdSF;
        arraySkorSF[2] = jurnalisSF;
        arraySkorSF[3] = teknisiSF;

        maxSF = arraySkorSF[0];

        for (int s = 0; s < 4; s++) {
            if (arraySkorSF[s] > maxSF) {
                maxSF = arraySkorSF[s];
                s++;
            }
        }
        siaranCFGAP = siaranCF - maxCF;
        mdCFGAP = mdCF - maxCF;
        jurnalisCFGAP = jurnalisCF - maxCF;
        teknisiCFGAP = teknisiCF - maxCF;

        siaranSFGAP = siaranSF - maxSF;
        mdSFGAP = mdSF - maxSF;
        jurnalisSFGAP = jurnalisSF - maxSF;
        teknisiSFGAP = teknisiSF - maxSF;

        arraySkorCF[0] = siaranCFGAP;
        arraySkorCF[1] = mdCFGAP;
        arraySkorCF[2] = jurnalisCFGAP;
        arraySkorCF[3] = teknisiCFGAP;

        for (int c = 0; c < 4; c++) {
            if (arraySkorCF[c] == 0) {
                arraySkorCF[c] = (float) 5.0;
            } else if (arraySkorCF[c] == 1) {
                arraySkorCF[c] = (float) 4.5;
            } else if (arraySkorCF[c] == -1) {
                arraySkorCF[c] = (float) 4;
            } else if (arraySkorCF[c] == 2) {
                arraySkorCF[c] = (float) 3.5;
            } else if (arraySkorCF[c] == -2) {
                arraySkorCF[c] = (float) 3;
            } else if (arraySkorCF[c] == 3) {
                arraySkorCF[c] = (float) 2.5;
            } else if (arraySkorCF[c] == -3) {
                arraySkorCF[c] = (float) 2;
            } else if (arraySkorCF[c] == 4) {
                arraySkorCF[c] = (float) 1.5;
            } else if (arraySkorCF[c] == -4) {
                arraySkorCF[c] = (float) 1;
            }
        }
        arraySkorSF[0] = siaranSFGAP;
        arraySkorSF[1] = mdSFGAP;
        arraySkorSF[2] = jurnalisSFGAP;
        arraySkorSF[3] = teknisiSFGAP;

        for (int s = 0; s < 4; s++) {
            if (arraySkorSF[s] == 0) {
                arraySkorSF[s] = (float) 5.0;
            } else if (arraySkorSF[s] == 1) {
                arraySkorSF[s] = (float) 4.5;
            } else if (arraySkorSF[s] == -1) {
                arraySkorSF[s] = (float) 4;
            } else if (arraySkorSF[s] == 2) {
                arraySkorSF[s] = (float) 3.5;
            } else if (arraySkorSF[s] == -2) {
                arraySkorSF[s] = (float) 3;
            } else if (arraySkorSF[s] == 3) {
                arraySkorSF[s] = (float) 2.5;
            } else if (arraySkorSF[s] == -3) {
                arraySkorSF[s] = (float) 2;
            } else if (arraySkorSF[s] == 4) {
                arraySkorSF[s] = (float) 1.5;
            } else if (arraySkorSF[s] == -4) {
                arraySkorSF[s] = (float) 1;
            }
        }
        siaranNA = ((arraySkorCF[0] * 60 / 100) + (arraySkorSF[0] * 40 / 100));
        mdNA = ((arraySkorCF[1] * 60 / 100) + (arraySkorSF[1] * 40 / 100));
        jurnalisNA = ((arraySkorCF[2] * 60 / 100) + (arraySkorSF[2] * 40 / 100));
        teknisiNA = ((arraySkorCF[3] * 60 / 100) + (arraySkorSF[3] * 40 / 100));
    }

    private void setRecycleView() {
        rvSorting.setHasFixedSize(true);
        rvSorting.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SortingAdapter(this, getList());
        rvSorting.setAdapter(adapter);
    }

    private List<SortingNilai> getList() {
        List<SortingNilai> nilaiList = new ArrayList<>();
        nilaiList.add(new SortingNilai("Siaran", Math.round(siaranNA/4*100)));
        nilaiList.add(new SortingNilai("Music Director", Math.round(mdNA/4*100)));
        nilaiList.add(new SortingNilai("Jurnalis", Math.round(jurnalisNA/4*100)));
        nilaiList.add(new SortingNilai("Teknisi", Math.round(teknisiNA/4*100)));
        return nilaiList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRestart:
                Intent restart = new Intent(this, DivisiSiaranCF_Activity.class);
                startActivity(restart);
                break;
            case R.id.btnKeluar:
                Intent selesai = new Intent(this, MainActivity.class);
                startActivity(selesai);
                break;
        }
    }
}