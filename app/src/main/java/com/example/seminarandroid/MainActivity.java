package com.example.seminarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    Button btnActualizeaza;
    Profil profil;
    TextView tvNume, tvVarsta;

    final String cheie = "profil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profil = new Profil("testStudent@ase.ro", "Pirvu Marian", 25);

        btnActualizeaza = findViewById(R.id.btn_actualizeaza);

        tvNume = findViewById(R.id.tv_nume);
        tvVarsta = findViewById(R.id.tv_varsta);

        initializeazaControale();

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnActualizeaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ModificaProfilActivity.class);
                intent.putExtra(cheie, profil);
                startActivity(intent);
            }
        });
    }

    void initializeazaControale() {
        tvNume.setText(profil.getNume());
        tvVarsta.setText(String.valueOf(profil.getVarsta()));
    }

}