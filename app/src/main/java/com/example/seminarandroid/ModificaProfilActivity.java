package com.example.seminarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModificaProfilActivity extends AppCompatActivity {

    Profil profil;
    EditText etNume, etVarsta;



    private final String cheieProfilNou = "profil_nou";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_profil);

        Intent intent = getIntent();
        profil = (Profil) intent.getSerializableExtra("profil");

        etNume = findViewById(R.id.pt_nume);
        etVarsta = findViewById(R.id.pt_varsta);

        preiaControale();

        Button btn_salveaza = findViewById(R.id.btn_salveaza);
        btn_salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profil.setNume(etNume.getText().toString());
                profil.setVarsta(Integer.parseInt(etVarsta.getText().toString()));

                Intent date = new Intent();
                date.putExtra(cheieProfilNou, profil);
                setResult(RESULT_OK, date);

                finish();
            }
        });
    }

    private void preiaControale() {
        etNume.setText(profil.getNume());
        etVarsta.setText(String.valueOf(profil.getVarsta()));
    }
}
