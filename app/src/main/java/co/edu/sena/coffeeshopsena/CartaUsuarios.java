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

public class CartaUsuarios extends AppCompatActivity {

    private ImageView img, img2, img3, img4, img5;

    private Button btnCompras, btnComprasDos, btnComprasTres, btnComprasCuatro, btnComprasQuinto;
    private TextView mNombreprodu, nNombreproduDos, nNombreproduTres, nNombreproduCuatro, nNombreproduQuinto ;
    private Spinner mCantidadprodu, mCantidadproduDos, mCantidadproduTres, mCantidadproduCuatro, mCantidadproduQuinto;
    private TextView mPrecioprodu, mPrecioproduDos, mPrecioproduTres, mPrecioproduCuatro, mPrecioproduQuinto;

    FirebaseAuth mAuth;
    private DatabaseReference Compras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_usuarios);


        mAuth = FirebaseAuth.getInstance();
        Compras= FirebaseDatabase.getInstance().getReference();

        //Datos 1
        mNombreprodu = (TextView) findViewById(R.id.tituloProductoUno);
        mPrecioprodu = (TextView) findViewById(R.id.precioUno);
        btnCompras = (Button) findViewById(R.id.btnComprarUno);
        mCantidadprodu = (Spinner) findViewById(R.id.cantidadUno);
        btnCompras.setOnClickListener(view -> {
            comprasp();
        });

        //Datos 2
        btnComprasDos = (Button) findViewById(R.id.btnComprarDos);
        nNombreproduDos = (TextView) findViewById(R.id.tituloProductoDos);
        mCantidadproduDos = (Spinner) findViewById(R.id.cantidadDos);
        mPrecioproduDos = (TextView) findViewById(R.id.precioDos);
        btnComprasDos.setOnClickListener(view -> {
            comprasa();
        });

        //Datos 3
        btnComprasTres  = (Button) findViewById(R.id.btnComprarTres);
        nNombreproduTres = (TextView) findViewById(R.id.tituloProductoTres);
        mCantidadproduTres = (Spinner) findViewById(R.id.cantidadTres);
        mPrecioproduTres  = (TextView) findViewById(R.id.precioTres);
        btnComprasTres.setOnClickListener(view -> {
            comprasc();
        });

        //Datos 4
        btnComprasCuatro  = (Button) findViewById(R.id.btnComprarCuatro);
        nNombreproduCuatro = (TextView) findViewById(R.id.tituloCuatro);
        mCantidadproduCuatro = (Spinner) findViewById(R.id.cantidadCuatro);
        mPrecioproduCuatro  = (TextView) findViewById(R.id.precioCuatro);
        btnComprasCuatro.setOnClickListener(view -> {
            comprasd();
        });

        //Datos 5
        btnComprasQuinto  = (Button) findViewById(R.id.btnComprarQuinto);
        nNombreproduQuinto = (TextView) findViewById(R.id.tituloProductoQuinto);
        mCantidadproduQuinto = (Spinner) findViewById(R.id.cantidadQuinta);
        mPrecioproduQuinto  = (TextView) findViewById(R.id.precioQuinto);
        btnComprasQuinto.setOnClickListener(view -> {
            comprasf();
        });


        //Imagenes Servidor
        img = (ImageView) findViewById(R.id.imgDesayunos01);
        img2 = (ImageView) findViewById(R.id.imgDesayunos02);
        img3 = (ImageView) findViewById(R.id.imgDesayunos03);
        img4 = (ImageView) findViewById(R.id.imgDesayunos04);
        img5 = (ImageView) findViewById(R.id.imgDesayunos05);

        //Imagenes Servidor URL
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fgn2255mz2608img%20.jpg?alt=media&token=8d168df8-4f56-4311-8aeb-b4ec94968c36").into(img);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fff2715bz2372img%20.jpg?alt=media&token=2b56cdd2-1702-494b-8d72-62bbe22b4d34").into(img2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fir2161zh3016img%20.jpg?alt=media&token=82bab06a-562e-4f16-b9e3-c3f249e5c7ae").into(img3);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fcl2553qp2449img%20.jpg?alt=media&token=219e45d1-7db0-41b6-893e-30bb8d075943").into(img4);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fdy2197zc2969img%20.jpg?alt=media&token=21dd6d44-5362-46fc-b411-c66b0ee87ded").into(img5);


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

    private void comprasp() {
        String nomes = mNombreprodu.getText().toString();
        String cantis = mCantidadprodu.getSelectedItem().toString();
        String precil = mPrecioprodu.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaUsuarios.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaUsuarios.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void comprasa() {
        String nomes = nNombreproduDos.getText().toString();
        String cantis = mCantidadproduDos.getSelectedItem().toString();
        String precil = mPrecioproduDos.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaUsuarios.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaUsuarios.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void comprasc() {
        String nomes = nNombreproduTres.getText().toString();
        String cantis = mCantidadproduTres.getSelectedItem().toString();
        String precil = mPrecioproduTres.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaUsuarios.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaUsuarios.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void comprasd() {
        String nomes = nNombreproduCuatro.getText().toString();
        String cantis = mCantidadproduCuatro.getSelectedItem().toString();
        String precil = mPrecioproduCuatro.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaUsuarios.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaUsuarios.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }


    private void comprasf() {
        String nomes = nNombreproduQuinto.getText().toString();
        String cantis = mCantidadproduQuinto.getSelectedItem().toString();
        String precil = mPrecioproduQuinto.getText().toString();


        if (!TextUtils.isEmpty(nomes)&& !TextUtils.isEmpty(cantis)&& !TextUtils.isEmpty(precil)){
            String vnl = Compras.push().getKey();
            co.edu.sena.coffeeshopsena.modelos.Compras leccionl = new Compras(nomes, cantis, precil);
            Compras.child("bdcompras").child(vnl).setValue(leccionl);
            Toast.makeText(CartaUsuarios.this, "Compra Registrada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CartaUsuarios.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }





    public void desayunos(View view) {
        Intent supDesayunos = new Intent(CartaUsuarios.this,CartaUsuarios.class);
        startActivity(supDesayunos);
    }

    public void bebidCalientes(View view) {
        Intent supBebidCalientes = new Intent(CartaUsuarios.this,CartaBebidCalientes.class);
        startActivity(supBebidCalientes);
    }

    public void almuerzos(View view) {
        Intent supAlmuerzos = new Intent(CartaUsuarios.this,CartaAlmuerzos.class);
        startActivity(supAlmuerzos);
    }

    public void bebidFrias(View view) {
        Intent supBebidFrias = new Intent(CartaUsuarios.this,CartaBebidFrias.class);
        startActivity(supBebidFrias);
    }

    public void helados(View view) {
        Intent supHelados = new Intent(CartaUsuarios.this,CartaHelados.class);
        startActivity(supHelados);
    }

    public void lacteos(View view) {
        Intent supLacteos = new Intent(CartaUsuarios.this,CartaLacteos.class);
        startActivity(supLacteos);
    }

    public void frutas(View view) {
        Intent supFrutas = new Intent(CartaUsuarios.this,CartaFrutas.class);
        startActivity(supFrutas);
    }
}