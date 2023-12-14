package co.edu.sena.coffeeshopsena;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import co.edu.sena.coffeeshopsena.modelos.Compras;

public class CartaHelados extends AppCompatActivity {

    private ImageView img, img2;
    private Button btnComH,btnCompHel;
    private TextView hel1,hel2;
    private Spinner hcan1,hcan2;
    private TextView hpre1,hpre2;

    FirebaseAuth mAuth;

    private DatabaseReference Compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_helados);

        mAuth = FirebaseAuth.getInstance();
        Compras= FirebaseDatabase.getInstance().getReference();

        hel1 = (TextView) findViewById(R.id.helad1);
        hpre1 = (TextView) findViewById(R.id.fazNombr1);
        btnComH = (Button) findViewById(R.id.btnComHel);
        hcan1 = (Spinner) findViewById(R.id.cantid1);
        btnComH.setOnClickListener(view -> {
            compraspnp();
        });

        hel2= (TextView) findViewById(R.id.precio02);
        hpre2 = (TextView) findViewById(R.id.titulo01);
        btnCompHel = (Button) findViewById(R.id.btnCompH1);
        hcan2 = (Spinner) findViewById(R.id.cantid1);
        btnCompHel.setOnClickListener(view -> {
            compraspnpi();
        });
        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgHelados1);
        img2 = (ImageView) findViewById(R.id.imgHelados2);

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fqd2145el2791img%20.jpg?alt=media&token=8f8f0a96-24b7-4897-ba66-a624ade72b16").into(img);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fef2363kp2294img%20.jpg?alt=media&token=4e77caa0-b658-4f4a-90ae-4d450c9f9235").into(img2);



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
    private void compraspnp() {
        String nomesp =   hel1.getText().toString();
        String cantisp =  hcan1.getSelectedItem().toString();
        String precilp = hpre1.getText().toString();

        if (!TextUtils.isEmpty(nomesp)&& !TextUtils.isEmpty(cantisp)&& !TextUtils.isEmpty(precilp)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomesp, cantisp, precilp);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaHelados.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaHelados.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }


    private void compraspnpi() {
        String nomesp =  hel2.getText().toString();
        String cantisp =  hcan2.getSelectedItem().toString();
        String precilp = hpre2 .getText().toString();

        if (!TextUtils.isEmpty(nomesp)&& !TextUtils.isEmpty(cantisp)&& !TextUtils.isEmpty(precilp)){
            String vnl = Compras.push().getKey();
            Compras leccionl = new Compras(nomesp, cantisp, precilp);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaHelados.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaHelados.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    public void desayunos(View view) {
        Intent supDesayunos = new Intent(CartaHelados.this,CartaUsuarios.class);
        startActivity(supDesayunos);
    }

    public void bebidCalientes(View view) {
        Intent supBebidCalientes = new Intent(CartaHelados.this,CartaBebidCalientes.class);
        startActivity(supBebidCalientes);
    }

    public void almuerzos(View view) {
        Intent supAlmuerzos = new Intent(CartaHelados.this,CartaAlmuerzos.class);
        startActivity(supAlmuerzos);
    }

    public void bebidFrias(View view) {
        Intent supBebidFrias = new Intent(CartaHelados.this,CartaBebidFrias.class);
        startActivity(supBebidFrias);
    }

    public void helados(View view) {
        Intent supHelados = new Intent(CartaHelados.this,CartaHelados.class);
        startActivity(supHelados);
    }

    public void lacteos(View view) {
        Intent supLacteos = new Intent(CartaHelados.this,CartaLacteos.class);
        startActivity(supLacteos);
    }

    public void frutas(View view) {
        Intent supFrutas = new Intent(CartaHelados.this,CartaFrutas.class);
        startActivity(supFrutas);
    }
}