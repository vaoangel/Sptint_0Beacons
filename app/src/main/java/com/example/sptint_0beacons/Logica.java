package com.example.sptint_0beacons;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


//Clase que almacena la lógica relacionada con la conexión al servidor
public class Logica {

    public void enviar_post( String medida){
        Log.d(">>>>>>>>>>", "entra función logica BDD");

        //Creamos un Objeto JSON para almacenar la información

        JSONObject jsonObject = new JSONObject();

        //Implementamos un try catch para asegurarnos de que el valor se inserta en el objeto

        try {
            jsonObject.put("medida",medida );


        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Mediante una libreria http ejecutamos una petición post al servidor en local

        AndroidNetworking.post("http://192.168.0.12:3000/insertar_valor")
                .addJSONObjectBody(jsonObject) // posting json
                .setTag("post")
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
        Log.d(">>>>>>>>>>", "Sale función logica BDD");


    }
}
