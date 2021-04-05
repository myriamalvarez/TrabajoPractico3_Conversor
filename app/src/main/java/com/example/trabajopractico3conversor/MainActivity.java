package com.example.trabajopractico3conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel vm;
    private Button btnConvertir;
    private EditText etDolar, etEuro, etTotal;
    private RadioButton rbDolarAEuro, rbEuroADolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        inicializarVista();

        vm.getResultadoMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etTotal.setText(s);

            }
        });
    }

    private void inicializarVista(){
        etDolar = findViewById(R.id.etDolar);
        etEuro = findViewById(R.id.etEuro);
        etTotal = findViewById(R.id.etTotal);
        rbDolarAEuro = findViewById(R.id.rbDolarAEuro);
        rbEuroADolar = findViewById(R.id.rbEuroADolar);
        btnConvertir = findViewById(R.id.btnConvertir);

        rbDolarAEuro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etEuro.setEnabled(false);
                etDolar.setEnabled(true);
            }
        });

        rbEuroADolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDolar.setEnabled(false);
                etEuro.setEnabled(true);
            }
        });

        btnConvertir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(rbDolarAEuro.isChecked()){
                    vm.dolarAEuro(etDolar.getText().toString());
                }
                else if(rbEuroADolar.isChecked()){
                    vm.euroADolar(etEuro.getText().toString());
                }

            }
        });

        }

        }



