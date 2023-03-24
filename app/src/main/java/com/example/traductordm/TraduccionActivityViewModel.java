package com.example.traductordm;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class TraduccionActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> palabra ;

    public TraduccionActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getPalabra(){
        if(palabra == null){
            palabra = new MutableLiveData<>();
        }
        return palabra;
    }

    public void agregarPalabra(Intent recuperar){
        palabra.setValue(recuperar.getStringExtra("palabra"));
    }
}
