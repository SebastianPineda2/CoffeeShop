package co.edu.sena.coffeeshopsena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ApartUsuariosAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apart_usuarios_admin);
    }

    public void interPerfilAdmin(View view) {
        Intent iPerfilAdmin = new Intent(ApartUsuariosAdmin.this,PerfilAdmin.class);
        startActivity(iPerfilAdmin);
    }

    public void agregarCuentaAdmin(View view) {
        Intent iCrearCuentaAdmin = new Intent(ApartUsuariosAdmin.this,CrearCuentaAdmin.class);
        startActivity(iCrearCuentaAdmin);
    }

    public void usserRegistrados(View view) {
        Intent iRegistrados = new Intent(ApartUsuariosAdmin.this,ListTdUsuariosAdmin.class);
        startActivity(iRegistrados);
    }


}