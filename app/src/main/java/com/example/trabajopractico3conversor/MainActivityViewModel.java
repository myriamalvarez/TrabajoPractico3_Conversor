package com.example.trabajopractico3conversor;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> resultadoMutable;

    public LiveData<String> getResultadoMutable(){
        if(resultadoMutable==null){
            resultadoMutable=new MutableLiveData<>();
        }
        return resultadoMutable;
    }

   public void dolarAEuro(String etDolar){
        try{
            double cotizacionEuro = 0.85;
            double importeDolares = Double.parseDouble(etDolar);

            double total = (importeDolares * cotizacionEuro);

            resultadoMutable.setValue(total + " euros ");
            }catch (Exception ex){
            resultadoMutable.setValue("Debe ingresar un importe");
            }

    }

    public void euroADolar(String etEuro){
    try{
        double cotizacionDolar = 1.18;
        double importeEuros = Double.parseDouble(etEuro);

        double total = (importeEuros * cotizacionDolar);

        resultadoMutable.setValue(total + " dolares ");
    }catch (Exception ex){
        resultadoMutable.setValue("Debe ingresar un importe");
    }
    }

}
