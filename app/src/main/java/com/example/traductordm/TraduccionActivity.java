package com.example.traductordm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.traductordm.databinding.ActivityMainBinding;
import com.example.traductordm.databinding.ActivityTraduccionBinding;

public class TraduccionActivity extends AppCompatActivity {

    private ActivityTraduccionBinding binding ;
    private TraduccionActivityViewModel tvm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTraduccionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraduccionActivityViewModel.class);

        tvm.getPalabra().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvTraduccion.setText(s);
            }
        });

        Intent recuperar = getIntent();

        tvm.agregarPalabra(recuperar);

    }


}