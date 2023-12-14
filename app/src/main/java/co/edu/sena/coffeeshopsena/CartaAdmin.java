package co.edu.sena.coffeeshopsena;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import co.edu.sena.coffeeshopsena.modelos.Productos;


public class CartaAdmin extends AppCompatActivity {

    private EditText mIdproducto;
    private EditText mNombreproducto;
    private EditText mCantidadproducto;
    private EditText mDescripcionproducto;
    private EditText mPrecioproducto;
    private Spinner spinnerC;
    private Button mButtonProducto;

    FirebaseAuth mAuth;

    private DatabaseReference Productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_admin);

        //supMenu de Navegación | Admin
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.carta);
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

        mAuth = FirebaseAuth.getInstance();
        Productos = FirebaseDatabase.getInstance().getReference();
        mIdproducto = (EditText) findViewById(R.id.idproducto);
        mNombreproducto = (EditText) findViewById(R.id.nombreproducto);
        mCantidadproducto= (EditText) findViewById(R.id.cantidadproducto);
        mDescripcionproducto = (EditText) findViewById(R.id.descripcionproducto);
        mPrecioproducto = (EditText) findViewById(R.id.precioproducto);
        mButtonProducto = (Button) findViewById(R.id.btnEnviarProducto);
        spinnerC = (Spinner) findViewById(R.id.opProductos);

        mButtonProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarProductos();
            }
        });
    }

    private void registrarProductos() {
        String seccion = spinnerC.getSelectedItem().toString();
        String tema = mIdproducto.getText().toString();
        String  nom = mNombreproducto.getText().toString();
        String cant = mCantidadproducto.getText().toString();
        String descrip = mDescripcionproducto.getText().toString();
        String preci = mPrecioproducto.getText().toString();

        if (!TextUtils.isEmpty(nom)&& !TextUtils.isEmpty(tema)&& !TextUtils.isEmpty(cant)&& !TextUtils.isEmpty(descrip)&& !TextUtils.isEmpty(preci)){
            String vn = Productos.push().getKey();
            Productos leccion = new Productos(vn, seccion, tema, nom, cant, descrip, preci);
            Productos.child("bdproductos").child(vn).setValue(leccion);
            Toast.makeText(this, "Producto registrado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void siguienteCartaUno(View view) {
        Intent aSubirImg = new Intent(CartaAdmin.this,SubirImgAdmin.class);
        startActivity(aSubirImg);
    }
}
