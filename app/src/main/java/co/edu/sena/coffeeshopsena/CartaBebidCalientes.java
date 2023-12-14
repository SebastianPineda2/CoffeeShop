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

public class CartaBebidCalientes extends AppCompatActivity {

    private ImageView img, img2;

    private Button btnComprashj, btnComprasjs;
    private TextView mNombreproduhj, mNombreprodujs;
    private Spinner mCantidadproduhj, mCantidadprodujs;
    private TextView mPrecioproduhj, mPrecioprodujs;

    FirebaseAuth mAuth;
    private DatabaseReference Compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_bebid_calientes);

        mAuth = FirebaseAuth.getInstance();
        Compras= FirebaseDatabase.getInstance().getReference();

        //Datos 1
        mNombreproduhj = (TextView) findViewById(R.id.nombCalienteUno);
        mPrecioproduhj = (TextView) findViewById(R.id.preCalienteUno);
        btnComprashj = (Button) findViewById(R.id.btnComprarCalienteUno);
        mCantidadproduhj = (Spinner) findViewById(R.id.cantididaCalienteUno);
        btnComprashj.setOnClickListener(view -> {
            compraspsr();
        });

        //Datos 2
        btnComprasjs = (Button) findViewById(R.id.btnComprarCalienteDos);
        mNombreprodujs = (TextView) findViewById(R.id.nombCalienteDos);
        mCantidadprodujs = (Spinner) findViewById(R.id.cantididaCalienteDos);
        mPrecioprodujs = (TextView) findViewById(R.id.preCalienteDos);
        btnComprasjs.setOnClickListener(view -> {
            comprasagko();
        });



        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgBbCalientesUno);
        img2 = (ImageView) findViewById(R.id.imgBbCalientesDos);

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Ffp2347mw2474img%20.jpg?alt=media&token=324347bd-ae9d-454a-8318-987459ec36f3").into(img);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Ftz2319wz3100img%20.jpg?alt=media&token=1758ad73-23cd-4d1b-af88-ea3be808b978").into(img2);



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

    private void compraspsr() {
        String nomes = mNombreproduhj.getText().toString();
        String cantis = mCantidadproduhj.getSelectedItem().toString();
        String precil = mPrecioproduhj.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaBebidCalientes.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaBebidCalientes.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }


    private void comprasagko() {
        String nomes = mNombreprodujs.getText().toString();
        String cantis = mCantidadprodujs.getSelectedItem().toString();
        String precil = mPrecioprodujs.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaBebidCalientes.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaBebidCalientes.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }



    public void desayunos(View view) {
        Intent supDesayunos = new Intent(CartaBebidCalientes.this,CartaUsuarios.class);
        startActivity(supDesayunos);
    }

    public void bebidCalientes(View view) {
        Intent supBebidCalientes = new Intent(CartaBebidCalientes.this,CartaBebidCalientes.class);
        startActivity(supBebidCalientes);
    }

    public void almuerzos(View view) {
        Intent supAlmuerzos = new Intent(CartaBebidCalientes.this,CartaAlmuerzos.class);
        startActivity(supAlmuerzos);
    }

    public void bebidFrias(View view) {
        Intent supBebidFrias = new Intent(CartaBebidCalientes.this,CartaBebidFrias.class);
        startActivity(supBebidFrias);
    }

    public void helados(View view) {
        Intent supHelados = new Intent(CartaBebidCalientes.this,CartaHelados.class);
        startActivity(supHelados);
    }

    public void lacteos(View view) {
        Intent supLacteos = new Intent(CartaBebidCalientes.this,CartaLacteos.class);
        startActivity(supLacteos);
    }

    public void frutas(View view) {
        Intent supFrutas = new Intent(CartaBebidCalientes.this,CartaFrutas.class);
        startActivity(supFrutas);
    }
}