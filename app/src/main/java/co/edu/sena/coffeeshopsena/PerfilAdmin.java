package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_admin);

        //Menu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.usuario);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.inicio:
                        startActivity(new Intent(getApplicationContext(), InicioAdmin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.carta:
                        startActivity(new Intent(getApplicationContext(), CartaAdmin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.pedidos:
                        startActivity(new Intent(getApplicationContext(), PedidosAdmin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.usuario:
                        startActivity(new Intent(getApplicationContext(), PerfilAdmin.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    public void ayudaAdmin(View view) {
        Intent aAyuda = new Intent(PerfilAdmin.this,AyudaAdmin.class);
        startActivity(aAyuda);
    }


    public void ubicacion(View view) {
        Intent aUbicacion = new Intent(PerfilAdmin.this,MapaUsuarios.class);
        startActivity(aUbicacion);
    }


    public void comprar(View view) {
        Intent aComprar = new Intent(PerfilAdmin.this,CartaUsuarios.class);
        startActivity(aComprar);
    }

    public void dtsUsuarios(View view) {
        Intent aUsuariosRegistrado = new Intent(PerfilAdmin.this,ApartUsuariosAdmin.class);
        startActivity(aUsuariosRegistrado);
    }

    public void acercaDeDos(View view) {
        Intent aCreditos = new Intent(PerfilAdmin.this,AcercaDeDos.class);
        startActivity(aCreditos);
    }

    public void cerrarSesion(View view) {
        startActivity(new Intent(PerfilAdmin.this,InicioSesion.class));
        finish();
    }



    public void facebook(View view) {
        Intent enlaceFacebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Coffee-Shop-100428002200924"));
        startActivity(enlaceFacebook);
    }

    public void instagram(View view) {
        Intent enlaceInstagram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/coffeeshopsena?igshid=3hcm3l67zrkd"));
        startActivity(enlaceInstagram);
    }



}