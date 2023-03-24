package com.example.traductordm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivityviewModel extends AndroidViewModel {

    private Map<String, String> palabras = new HashMap<>();
    private Context context;
    private MutableLiveData<String> traducido;
    private Intent intent;

    public MainActivityviewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

    }


    public LiveData<String> getTraduccion(){
        if(traducido == null){
            this.traducido = new MutableLiveData<>();
        }
        return traducido ;
    }

    public void traducir(String palabra){
        String pal ;
        this.palabras.put("Casa","House");
        this.palabras.put("Programador", "Developer");
        try{
            System.out.println(palabra);
            pal = palabras.get(palabra);
            if(pal == null){
               traducido.setValue("No se encontro la palabra");
            }else{
               traducido.setValue(pal);
            }
        }catch(Exception e){
            Toast.makeText(context, e.toString() , Toast.LENGTH_LONG).show();
        }

    }
}
