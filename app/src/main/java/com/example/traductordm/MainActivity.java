package com.example.traductordm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView traducido ;
    private Button boton;
    private EditText palabra ;
    private MainActivityviewModel mv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityviewModel.class);

        this.traducido = findViewById(R.id.tvTraducido);
        this.palabra = findViewById(R.id.etPalabra);
        this.boton = findViewById(R.id.btTraducir);

        mv.getTraduccion().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                traducido.setText(s);
            }
        });

        this.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.traducir(palabra.getText().toString());
            }
        });
    }
}