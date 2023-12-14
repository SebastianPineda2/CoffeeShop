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

public class CartaBebidFrias extends AppCompatActivity {

    private ImageView img, img2, img3;

    private Button btnComp1,btnComp2,btnComp3;
    private TextView pro1,pro2,pro3;
    private Spinner can1,can2,can3;
    private TextView pre1,pre2,pre3;

    FirebaseAuth mAuth;

    private DatabaseReference Compras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_bebid_frias);

        mAuth = FirebaseAuth.getInstance();
        Compras= FirebaseDatabase.getInstance().getReference();


        pro1 = (TextView) findViewById(R.id.proc1);
        pre1 = (TextView) findViewById(R.id.prec1);
        btnComp1 = (Button) findViewById(R.id.btnCompc1);
        can1 = (Spinner) findViewById(R.id.canc1);
        btnComp1.setOnClickListener(view -> {
            compraspn();
        });


        pro2 = (TextView) findViewById(R.id.proc2);
        pre2 = (TextView) findViewById(R.id.prec2);
        btnComp2 = (Button) findViewById(R.id.btnCompc2);
        can2 = (Spinner) findViewById(R.id.canc2);
        btnComp2.setOnClickListener(view -> {
            compraspl();
        });

        pro3 = (TextView) findViewById(R.id.proc3);
        pre3 = (TextView) findViewById(R.id.prec3);
        btnComp3 = (Button) findViewById(R.id.btnCompc3);
        can3 = (Spinner) findViewById(R.id.canc3);
        btnComp3.setOnClickListener(view -> {
            comprasplo();
        });




        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgBbFria1);
        img2 = (ImageView) findViewById(R.id.imgBbFria2);
        img3 = (ImageView) findViewById(R.id.imgBbFria3);

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fuq2933yk2850img%20.jpg?alt=media&token=b604b2bf-90bc-4d33-b325-6d5cd0de343e").into(img);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Frm2176mb2251img%20.jpg?alt=media&token=127e48c0-d796-44ac-b618-351d73fa4baf").into(img2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fcg2945fn3014img%20.jpg?alt=media&token=40ea9989-d240-462d-9da5-38f74ad8b70f").into(img3);


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
    private void compraspn() {
        String nomesp = pro1.getText().toString();
        String cantisp = can1.getSelectedItem().toString();
        String precilp = pre1.getText().toString();

        if (!TextUtils.isEmpty(nomesp)&& !TextUtils.isEmpty(cantisp)&& !TextUtils.isEmpty(precilp)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomesp, cantisp, precilp);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaBebidFrias.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaBebidFrias.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    private void compraspl() {
        String nomesp = pro2.getText().toString();
        String cantisp = can2.getSelectedItem().toString();
        String precilp = pre2.getText().toString();

        if (!TextUtils.isEmpty(nomesp)&& !TextUtils.isEmpty(cantisp)&& !TextUtils.isEmpty(precilp)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomesp, cantisp, precilp);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaBebidFrias.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaBebidFrias.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    private void comprasplo() {
        String nomesp = pro3.getText().toString();
        String cantisp = can3.getSelectedItem().toString();
        String precilp = pre3.getText().toString();

        if (!TextUtils.isEmpty(nomesp)&& !TextUtils.isEmpty(cantisp)&& !TextUtils.isEmpty(precilp)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomesp, cantisp, precilp);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaBebidFrias.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaBebidFrias.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void desayunos(View view) {
        Intent supDesayunos = new Intent(CartaBebidFrias.this,CartaUsuarios.class);
        startActivity(supDesayunos);
    }

    public void bebidCalientes(View view) {
        Intent supBebidCalientes = new Intent(CartaBebidFrias.this,CartaBebidCalientes.class);
        startActivity(supBebidCalientes);
    }

    public void almuerzos(View view) {
        Intent supAlmuerzos = new Intent(CartaBebidFrias.this,CartaAlmuerzos.class);
        startActivity(supAlmuerzos);
    }

    public void bebidFrias(View view) {
        Intent supBebidFrias = new Intent(CartaBebidFrias.this,CartaBebidFrias.class);
        startActivity(supBebidFrias);
    }

    public void helados(View view) {
        Intent supHelados = new Intent(CartaBebidFrias.this,CartaHelados.class);
        startActivity(supHelados);
    }

    public void lacteos(View view) {
        Intent supLacteos = new Intent(CartaBebidFrias.this,CartaLacteos.class);
        startActivity(supLacteos);
    }

    public void frutas(View view) {
        Intent supFrutas = new Intent(CartaBebidFrias.this,CartaFrutas.class);
        startActivity(supFrutas);
    }
}