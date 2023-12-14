package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        //Menu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.usuario);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.inicio:
                        startActivity(new Intent(getApplicationContext(), InicioUsuarios.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.carta:
                        startActivity(new Intent(getApplicationContext(), CartaUsuarios.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.pedidos:
                        startActivity(new Intent(getApplicationContext(), PedidosUsuarios.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.usuario:
                        startActivity(new Intent(getApplicationContext(), PerfilUsuario.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    public void ubicacion(View view) {
        Intent iUbicacion = new Intent(PerfilUsuario.this,MapaUsuarios.class);
        startActivity(iUbicacion);
    }

    public void ayuda(View view) {
        Intent iAyuda = new Intent(PerfilUsuario.this,AyudaUsuario.class);
        startActivity(iAyuda);
    }

    public void desarrolladores(View view) {
        Intent iDesarrolladores = new Intent(PerfilUsuario.this,AcercaDe.class);
        startActivity(iDesarrolladores);
    }

    public void cerrarSesion(View view) {
        startActivity(new Intent(PerfilUsuario.this,InicioSesion.class));
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