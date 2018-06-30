package com.cenfotec.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentUno extends Fragment implements View.OnClickListener {

    //Botones de interfaz
    Button boton1;
    Button boton2;

    //Referencia a la instancia de la interfaz, que es asignada al invocarse
    //este fragment. Es asignada dentro del onAttach y corresponde al activity
    //padre de este fragment.
    GestorBotones gestorBotones;

    //Interfaz que indica los metodos que el activity padre de este fragment
    //debe implementar para poder responder a acciones del usuario (en este caso,
    //tocar alguno de los dos botones).
    public interface GestorBotones{
        void accionBoton1();
        void accionBoton2();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Se asigna a la instancia de la interfaz el contexto recibido en este
        //metodo, que corresponde al activity padre de este fragment.
        gestorBotones = (GestorBotones) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inicializacion del view, de manera similar a un activity.
        View view = inflater.inflate(R.layout.fragment_uno,
                container, false);

        //Si se estuviera utilizando butterknife, se usa la siguiente linea:
        //ButterKnife.bind(this, view);

        boton1 = view.findViewById(R.id.boton1);
        boton2 = view.findViewById(R.id.boton2);

        //Se le asigna esta clase como listener al evento de click
        //de ambos botones
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);

        //Se recupera el parametro de inicializacion especificado en MainActivity.java
        //y se cambia el valor del texto a dicho mensaje.
        String msj = getArguments().getString(MainActivity.PARAM_MSJ);
        ((TextView)view.findViewById(R.id.texto)).setText(msj);

        return view;
    }

    //Metodo publico ejemplo que no hace nada
    public void actualizarInfo(String titulo, String descripcion){

    }

    @Override
    public void onClick(View view) {
        //Al hacerse click en alguno de los dos botones, la accion
        //de respuesta es realizada por la instancia de la interfaz
        //(ver MainActivity.java).
        if(view.equals(boton1)){
            gestorBotones.accionBoton1();
        } else {
            gestorBotones.accionBoton2();
        }
    }

}
