package com.example.sptint_0beacons;

import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Logica_fake {


    public void logica_bdd_fake (){
        Log.d(">>>>>>>>>>", "entra función lógica fake");
        //Creamos un Objeto JSON para almacenar la información
        JSONObject jsonObject = new JSONObject();
        try {
            //Implementamos un try catch para asegurarnos de que el valor se inserta en el objeto
            jsonObject.put("medida","777" );


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Mediante una libreria ejecutamos una petición post al servidor en local
        AndroidNetworking.post("http://192.168.0.12:3000/insertar_valor")
                .addJSONObjectBody(jsonObject) // posting json
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // do anything with response
                    }
                    @Override
                    public void onError(ANError error) {
                        //En caso de fallar muestra el error por consola
                        Log.d(">>>>>>>>>>", String.valueOf(error));

                    }
                });
        Log.d(">>>>>>>>>>", "Sale función lógica fake");

    } // ()
}
