package com.example.traductordm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.traductordm.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private MainActivityviewModel mv ;
    private ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityviewModel.class);

        mv.getTraduccion().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvTraducido.setText(s);
                Intent intent = new Intent(MainActivity.this, TraduccionActivity.class);
                intent.putExtra("palabra",s);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        binding.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.traducir(binding.etPalabra.getText().toString());
            }
        });
    }
}