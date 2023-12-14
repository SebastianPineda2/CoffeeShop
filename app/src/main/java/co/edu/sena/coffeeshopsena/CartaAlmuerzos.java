package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import co.edu.sena.coffeeshopsena.modelos.Compras;

public class CartaAlmuerzos extends AppCompatActivity {

    private ImageView img, img2, img3, img4, img5;

    FirebaseAuth mAuth;

    private DatabaseReference Compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_almuerzos);

        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgAlmuerzo01);
        img2 = (ImageView) findViewById(R.id.imgAlmuerzo02);
        img3 = (ImageView) findViewById(R.id.imgAlmuerzo03);
        img4 = (ImageView) findViewById(R.id.imgAlmuerzo04);
        img5 = (ImageView) findViewById(R.id.imgAlmuerzo05);

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b").into(img);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b").into(img2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b").into(img3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b").into(img4);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b").into(img5);


        //SupMenu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.carta);
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



    public void desayunos(View view) {
        Intent supDesayunos = new Intent(CartaAlmuerzos.this,CartaUsuarios.class);
        startActivity(supDesayunos);
    }

    public void bebidCalientes(View view) {
        Intent supBebidCalientes = new Intent(CartaAlmuerzos.this,CartaBebidCalientes.class);
        startActivity(supBebidCalientes);
    }

    public void almuerzos(View view) {
        Intent supAlmuerzos = new Intent(CartaAlmuerzos.this,CartaAlmuerzos.class);
        startActivity(supAlmuerzos);
    }

    public void bebidFrias(View view) {
        Intent supBebidFrias = new Intent(CartaAlmuerzos.this,CartaBebidFrias.class);
        startActivity(supBebidFrias);
    }

    public void helados(View view) {
        Intent supHelados = new Intent(CartaAlmuerzos.this,CartaHelados.class);
        startActivity(supHelados);
    }

    public void lacteos(View view) {
        Intent supLacteos = new Intent(CartaAlmuerzos.this,CartaLacteos.class);
        startActivity(supLacteos);
    }

    public void frutas(View view) {
        Intent supFrutas = new Intent(CartaAlmuerzos.this,CartaFrutas.class);
        startActivity(supFrutas);
    }
}