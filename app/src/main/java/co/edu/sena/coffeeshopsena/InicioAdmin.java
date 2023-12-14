package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class InicioAdmin extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_admin);

        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgInicioAdmin1);

        //Menu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.inicio);

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

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fbienvenidaadmin.png?alt=media&token=e21a5c21-5e56-43a6-a5bf-7711d8e8837a").into(img);

    }

    public void verAdmin(View view) {
        Intent dUsuario = new Intent(InicioAdmin.this,AyudaAdmin.class);
        startActivity(dUsuario);
    }
}