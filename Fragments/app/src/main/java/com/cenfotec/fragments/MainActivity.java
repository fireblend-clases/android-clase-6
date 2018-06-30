package com.cenfotec.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentUno.GestorBotones{

    public static final String PARAM_MSJ = "param.msj";

    //Tabs sencillos en parte superior de la pantalla
    TextView tab1;
    TextView tab2;
    TextView tab3;

    //Objeto con el que se van a realizar las transacciones
    //de fragments
    FragmentManager fm;

    //Instancias de los fragmentos que pueden existir dentro del
    //contenedor (R.id.contenedor en activity_main.xml)
    FragmentUno fragmentUno;
    FragmentDos fragmentDos = new FragmentDos();
    FragmentTres fragmentTres = new FragmentTres();

    //Referencia al tab que esta seleccionado en un momento dado
    TextView tabSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se inicializan los tabs
        tab1 = (TextView)findViewById(R.id.tab1);
        tab2 = (TextView)findViewById(R.id.tab2);
        tab3 = (TextView)findViewById(R.id.tab3);

        //Se les asigna la clase actual como ClickListener
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);

        //La instancia de fragmentUno se inicializa acá a modo de
        //ejemplo. Notar que fragmentDos y fragmentTres se inicializan
        //arriba.
        fragmentUno = new FragmentUno();

        //El objeto Bundle sirve para enviarle parametros de inicializacion
        //al fragmento
        Bundle argumentos = new Bundle();
        //Mismo diseño de llave-valor
        argumentos.putString(PARAM_MSJ, "Mensaje");
        //Se le asignan los parametros al fragmento
        fragmentUno.setArguments(argumentos);

        //Queremos que al iniciarse el activity, se muestre el tab 1 por
        //defecto, por lo que se genera una transaccion inicial para agregarlo.
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.contenedor, fragmentUno);
        ft.commit();

        //Se asigna el tab1 como tabSeleccionado y se pone en color rojo
        tabSeleccionado = tab1;
        tab1.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void onClick(View view) {
        //Si el view seleccionado es igual al que anteriormente se habia
        //asignado como tabSeleccionado, entonces se retorna inmediatamente.
        if(view.equals(tabSeleccionado))
            return;

        //Se inicia la transacción de fragmento
        FragmentTransaction ft = fm.beginTransaction();

        //Dependiendo del tab seleccionado, se reemplaza cualquiera que sea el
        //fragmento actual, con el fragmentUno, fragmentDos o fragmentTres.
        if(view.equals(tab1)){
            ft.replace(R.id.contenedor, fragmentUno);
            //Ejemplo de como llamar un metodo en un fragment (no hace nada)
            fragmentUno.actualizarInfo("titulo", "descripcion");
        }
        else if(view.equals(tab2)){
            ft.replace(R.id.contenedor, fragmentDos);
        }
        else if(view.equals(tab3)){
            ft.replace(R.id.contenedor, fragmentTres);
        }
        //Se finaliza la transaccion
        ft.commit();

        //El tab previamente seleccionado se pone de color negro
        tabSeleccionado.setTextColor(getResources().getColor(R.color.negro));
        //Se asigna nuevo tabSeleccionado al que el usuario selecciono
        tabSeleccionado = (TextView)view;
        //Se pone dicho nuevo tab en color rojo
        tabSeleccionado.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    //Estos dos metodos corresponden a los dos metodos que esta clase esta
    //obligada a implementar por haberse declarado como implementador de la
    //interfaz declarada en el Fragment (GestorBotones).
    @Override
    public void accionBoton1() {
        Toast.makeText(this, "Boton 1 Presionado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void accionBoton2() {
        Toast.makeText(this, "Boton 2 Presionado", Toast.LENGTH_SHORT).show();
    }
}
