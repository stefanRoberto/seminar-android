package com.example.seminarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ModificaProfilActivity extends AppCompatActivity {

    Profil profil;
    EditText ptNume, ptVarsta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_profil);

        Intent intent = getIntent();
        profil = (Profil) intent.getSerializableExtra("profil");

        ptNume = findViewById(R.id.pt_nume);
        ptVarsta = findViewById(R.id.pt_varsta);

        preiaControale();
    }

    private void preiaControale() {
        ptNume.setText(profil.getNume());
        ptVarsta.setText(String.valueOf(profil.getVarsta()));
    }
}
