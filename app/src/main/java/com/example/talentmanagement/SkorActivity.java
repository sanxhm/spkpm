package com.example.talentmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView hasilSiaranCF, hasilSiaranSF, hasilMdCF, hasilMdSF, hasilJurnalisCF,
            hasilJurnalisSF, hasilTeknisiCF, hasilTeknisiSF, hasilProfCF, hasilProfSF,
            hasilGAPsiaranCF, hasilGAPsiaranSF, hasilGAPmdCF, hasilGAPmdSF, hasilGAPjurnalisCF,
            hasilGAPjurnalisSF, hasilGAPteknisiCF, hasilGAPteknisiSF, hasilNAsiaranCF, hasilNAsiaranSF,
            hasilNAsiaranNA, hasilNAmdCF, hasilNAmdSF, hasilNAmdNA, hasilNAjurnalisCF, hasilNAjurnalisSF,
            hasilNAjurnalisNA, hasilNAteknisiCF, hasilNAteknisiSF, hasilNAteknisiNA;

    Button btnSorting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        btnSorting = findViewById(R.id.btnSorting);
        btnSorting.setOnClickListener(this);

        hasilSiaranCF = findViewById(R.id.hasilSiaranCF);
        hasilMdCF = findViewById(R.id.hasilMdCF);
        hasilJurnalisCF = findViewById(R.id.hasilJurnalisCF);
        hasilTeknisiCF = findViewById(R.id.hasilTeknisiCF);
        hasilSiaranSF = findViewById(R.id.hasilSiaranSF);
        hasilMdSF = findViewById(R.id.hasilMdSF);
        hasilJurnalisSF = findViewById(R.id.hasilJurnalisSF);
        hasilTeknisiSF = findViewById(R.id.hasilTeknisiSF);
        hasilProfCF = findViewById(R.id.hasilProfCF);
        hasilProfSF = findViewById(R.id.hasilProfSF);
        hasilGAPsiaranCF = findViewById(R.id.hasilGAPsiaranCF);
        hasilGAPmdCF = findViewById(R.id.hasilGAPmdCF);
        hasilGAPjurnalisCF = findViewById(R.id.hasilGAPjurnalisCF);
        hasilGAPteknisiCF = findViewById(R.id.hasilGAPteknisiCF);
        hasilGAPsiaranSF = findViewById(R.id.hasilGAPsiaranSF);
        hasilGAPmdSF = findViewById(R.id.hasilGAPmdSF);
        hasilGAPjurnalisSF = findViewById(R.id.hasilGAPjurnalisSF);
        hasilGAPteknisiSF = findViewById(R.id.hasilGAPteknisiSF);
        hasilNAsiaranCF = findViewById(R.id.hasilNAsiaranCF);
        hasilNAmdCF = findViewById(R.id.hasilNAmdCF);
        hasilNAjurnalisCF = findViewById(R.id.hasilNAjurnalisCF);
        hasilNAteknisiCF = findViewById(R.id.hasilNAteknisiCF);
        hasilNAsiaranSF = findViewById(R.id.hasilNAsiaranSF);
        hasilNAmdSF = findViewById(R.id.hasilNAmdSF);
        hasilNAjurnalisSF = findViewById(R.id.hasilNAjurnalisSF);
        hasilNAteknisiSF = findViewById(R.id.hasilNAteknisiSF);
        hasilNAsiaranNA = findViewById(R.id.hasilNAsiaranNA);
        hasilNAmdNA = findViewById(R.id.hasilNAmdNA);
        hasilNAjurnalisNA = findViewById(R.id.hasilNAjurnalisNA);
        hasilNAteknisiNA = findViewById(R.id.hasilNAteknisiNA);

        hasilSiaranCF.setText("" + DivisiSiaranCF_Activity.hasilSiaranCF);
        hasilMdCF.setText("" + DivisiMdCF_Activity.hasilMdCF);
        hasilJurnalisCF.setText("" + DivisiJurnalisCF_Activity.hasilJurnalisCF);
        hasilTeknisiCF.setText("" + DivisiTeknisiCF_Activity.hasilTeknisiCF);
        hasilSiaranSF.setText("" + DivisiSiaranSF_Activity.hasilSiaranSF);
        hasilMdSF.setText("" + DivisiMdSF_Activity.hasilMdSF);
        hasilJurnalisSF.setText("" + DivisiJurnalisSF_Activity.hasilJurnalisSF);
        hasilTeknisiSF.setText("" + DivisiTeknisiSF_Activity.hasilTeknisiSF);
        hasilGAPsiaranCF.setText(""+SortingActivity.siaranCFGAP);
        hasilGAPmdCF.setText(""+SortingActivity.mdCFGAP);
        hasilGAPjurnalisCF.setText(""+SortingActivity.jurnalisCFGAP);
        hasilGAPteknisiCF.setText(""+SortingActivity.teknisiCFGAP);
        hasilGAPsiaranSF.setText(""+SortingActivity.siaranSFGAP);
        hasilGAPmdSF.setText(""+SortingActivity.mdSFGAP);
        hasilGAPjurnalisSF.setText(""+SortingActivity.jurnalisSFGAP);
        hasilGAPteknisiSF.setText(""+SortingActivity.teknisiSFGAP);
        hasilNAsiaranCF.setText("");
        hasilNAmdCF.setText("");
        hasilNAjurnalisCF.setText("");
        hasilNAteknisiCF.setText("");
        hasilNAsiaranSF.setText("");
        hasilNAmdSF.setText("");
        hasilNAjurnalisSF.setText("");
        hasilNAteknisiSF.setText("");
        hasilNAsiaranNA.setText(""+SortingActivity.siaranNA);
        hasilNAmdNA.setText(""+SortingActivity.mdNA);
        hasilNAjurnalisNA.setText(""+SortingActivity.jurnalisNA);
        hasilNAteknisiNA.setText(""+SortingActivity.teknisiNA);
        hasilProfCF.setText(""+SortingActivity.maxCF);
        hasilProfSF.setText(""+SortingActivity.maxSF);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSorting:
                Intent intent = new Intent(this, SortingActivity.class);
                startActivity(intent);
                break;
        }
    }
}