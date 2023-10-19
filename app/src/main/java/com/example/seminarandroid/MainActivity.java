package com.example.seminarandroid;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.app.Instrumentation;
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

    private final String cheie = "profil";

    // contract
    ActivityResultContracts.StartActivityForResult startActivityForResultContract =
            new ActivityResultContracts.StartActivityForResult();

    // callback
    ActivityResultCallback<ActivityResult> activityResultCallback = new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                profil = (Profil) result.getData().getSerializableExtra("profil_nou");

                initializeazaControale(profil);
            }
        }
    };

    // launcher
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(startActivityForResultContract,
            activityResultCallback);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profil = new Profil("testStudent@ase.ro", "Pirvu Marian", 25);

        btnActualizeaza = findViewById(R.id.btn_actualizeaza);

        tvNume = findViewById(R.id.tv_nume);
        tvVarsta = findViewById(R.id.tv_varsta);

        initializeazaControale(profil);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnActualizeaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ModificaProfilActivity.class);
                intent.putExtra(cheie, profil);

                // de inlocuit pentru preluare raspuns!
//                startActivity(intent);

                // invocare activitate rezultat
                activityResultLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(cheie, profil);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        profil = (Profil) savedInstanceState.getSerializable("profil_nou");
        initializeazaControale(profil);
    }

    void initializeazaControale(Profil profil) {
        tvNume.setText(profil.getNume());
        tvVarsta.setText(String.valueOf(profil.getVarsta()));
    }

}