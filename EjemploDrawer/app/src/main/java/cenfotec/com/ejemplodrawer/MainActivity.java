package cenfotec.com.ejemplodrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Layout para uso del drawer
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se recupera referencia al layout utilizado
        drawerLayout = findViewById(R.id.drawer);
        NavigationView navView= findViewById(R.id.nav);

        //Se recupera referencia al toolbar que esta declarado en el
        //layout a utilizar, y va a reemplazar el toolbar por defecto
        //de la aplicacion. Notar el uso de "noActionBar" en el archivo
        //de styles bajo el directorio de recursos (res)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Se establece el boton de "home" dentro del ActionBar que
        //acabamos de establecer
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        //Establecemos este activity como el responsable de manejar
        //las acciones de seleccion de items en el panel de navegacion.
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Al seleccionar alguno de los elementos del panel de
        //navegacion, cerramos dicho panel
        drawerLayout.closeDrawers();

        //Dependiendo del ID del elemento seleccionado
        //(ver menu_drawer.xml en el directorio de res/menu)
        //realizamos una accion diferente.
        if(item.getItemId() == R.id.uno){
            //Realizar respuesta a seleccion en drawer
        } else if(item.getItemId() == R.id.dos){
            //Realizar respuesta a seleccion en drawer
        } else {
            //Realizar respuesta a seleccion en drawer
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Este metodo determina la accion al realizarse cuando
        //el usuario elige una opcion en el toolbar.
        switch (item.getItemId()){
            //Si el usuario selecciona la opcion android.R.id.home
            //que es una constante del sistema que representa el boton
            //de home, hacemos que se abra el drawer.
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
