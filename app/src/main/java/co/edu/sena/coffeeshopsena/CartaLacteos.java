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

public class CartaLacteos extends AppCompatActivity {

    private ImageView img, img2;
    private Button btnyog1,btnyog2;
    private TextView yog1,yog2;
    private Spinner yogc1,yogc2;
    private TextView yogp1,yogp2;

    FirebaseAuth mAuth;

    private DatabaseReference Compras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_lacteos);
        mAuth = FirebaseAuth.getInstance();
        Compras= FirebaseDatabase.getInstance().getReference();


        yog1 = (TextView) findViewById(R.id.fazNombreUno);
        yogp1 = (TextView) findViewById(R.id.precioUno);
        btnyog1 = (Button) findViewById(R.id.btnComprarUno);
        yogc1 = (Spinner) findViewById(R.id.cantidad01);
        btnyog1.setOnClickListener(view -> {
            compraspnl();
        });
        yog2 = (TextView) findViewById(R.id.titulo01);
        yogp2 = (TextView) findViewById(R.id.precio02);
        btnyog2 = (Button) findViewById(R.id.btnComprarDos);
        yogc2 = (Spinner) findViewById(R.id.cantidad02);
        btnyog2.setOnClickListener(view -> {
            compraspnpm();
        });

        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgLacteos1);
        img2 = (ImageView) findViewById(R.id.imgLacteos2);

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fgs2537ps2760img%20.jpg?alt=media&token=7bad3c39-2fd7-4b37-bb2f-ed72f362c225").into(img);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnb2754qb2745img%20.jpg?alt=media&token=987211c1-d306-4142-897e-d6fb12bcf687").into(img2);

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

    private void  compraspnl() {
        String nomesp = yog1.getText().toString();
        String cantisp = yogc1.getSelectedItem().toString();
        String precilp = yogp1.getText().toString();

        if (!TextUtils.isEmpty(nomesp)&& !TextUtils.isEmpty(cantisp)&& !TextUtils.isEmpty(precilp)){
            String vnl = Compras.push().getKey();
            Compras leccionl = new Compras(nomesp, cantisp, precilp);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaLacteos.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaLacteos.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void compraspnpm() {
        String nomesp = yog2.getText().toString();
        String cantisp = yogc1.getSelectedItem().toString();
        String precilp = yogp1.getText().toString();

        if (!TextUtils.isEmpty(nomesp)&& !TextUtils.isEmpty(cantisp)&& !TextUtils.isEmpty(precilp)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomesp, cantisp, precilp);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaLacteos.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaLacteos.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void desayunos(View view) {
        Intent supDesayunos = new Intent(CartaLacteos.this,CartaUsuarios.class);
        startActivity(supDesayunos);
    }

    public void bebidCalientes(View view) {
        Intent supBebidCalientes = new Intent(CartaLacteos.this,CartaBebidCalientes.class);
        startActivity(supBebidCalientes);
    }

    public void almuerzos(View view) {
        Intent supAlmuerzos = new Intent(CartaLacteos.this,CartaAlmuerzos.class);
        startActivity(supAlmuerzos);
    }

    public void bebidFrias(View view) {
        Intent supBebidFrias = new Intent(CartaLacteos.this,CartaBebidFrias.class);
        startActivity(supBebidFrias);
    }

    public void helados(View view) {
        Intent supHelados = new Intent(CartaLacteos.this,CartaHelados.class);
        startActivity(supHelados);
    }

    public void lacteos(View view) {
        Intent supLacteos = new Intent(CartaLacteos.this,CartaLacteos.class);
        startActivity(supLacteos);
    }

    public void frutas(View view) {
        Intent supFrutas = new Intent(CartaLacteos.this,CartaFrutas.class);
        startActivity(supFrutas);
    }
}