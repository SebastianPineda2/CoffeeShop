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


public class CartaFrutas extends AppCompatActivity {

    private ImageView img;

    private Button btnComprasYh;
    private TextView mNombreproduYh;
    private Spinner mCantidadproduYh;
    private TextView mPrecioproduYh;


    FirebaseAuth mAuth;
    private DatabaseReference Compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_frutas);

        mAuth = FirebaseAuth.getInstance();
        Compras= FirebaseDatabase.getInstance().getReference();

        //Datos 1
        mNombreproduYh = (TextView) findViewById(R.id.fruNombreUno);
        mPrecioproduYh = (TextView) findViewById(R.id.frutPrecioUno);
        btnComprasYh = (Button) findViewById(R.id.btnComprarUnoF);
        mCantidadproduYh = (Spinner) findViewById(R.id.frutCantidadUno);
        btnComprasYh.setOnClickListener(view -> {
            comprasos();
        });


        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgFrutas1);

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fis3016zv2502img%20.jpg?alt=media&token=3f8dbfd5-0a29-4de7-bd52-5005faa56106").into(img);

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
        Intent supDesayunos = new Intent(CartaFrutas.this,CartaUsuarios.class);
        startActivity(supDesayunos);
    }

    public void bebidCalientes(View view) {
        Intent supBebidCalientes = new Intent(CartaFrutas.this,CartaBebidCalientes.class);
        startActivity(supBebidCalientes);
    }

    public void almuerzos(View view) {
        Intent supAlmuerzos = new Intent(CartaFrutas.this,CartaAlmuerzos.class);
        startActivity(supAlmuerzos);
    }

    public void bebidFrias(View view) {
        Intent supBebidFrias = new Intent(CartaFrutas.this,CartaBebidFrias.class);
        startActivity(supBebidFrias);
    }

    public void helados(View view) {
        Intent supHelados = new Intent(CartaFrutas.this,CartaHelados.class);
        startActivity(supHelados);
    }

    public void lacteos(View view) {
        Intent supLacteos = new Intent(CartaFrutas.this,CartaLacteos.class);
        startActivity(supLacteos);
    }

    public void frutas(View view) {
        Intent supFrutas = new Intent(CartaFrutas.this,CartaFrutas.class);
        startActivity(supFrutas);
    }

    private void comprasos() {
        String nomes = mNombreproduYh.getText().toString();
        String cantis = mCantidadproduYh.getSelectedItem().toString();
        String precil = mPrecioproduYh.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaFrutas.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaFrutas.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}