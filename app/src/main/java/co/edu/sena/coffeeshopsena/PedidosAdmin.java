package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import co.edu.sena.coffeeshopsena.modelos.Compras;

public class PedidosAdmin extends AppCompatActivity {

    List<Compras> list = new ArrayList<>();
    ArrayAdapter<Compras> adapter;
    ListView listCompras;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_admin);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.pedidos);
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
        referenciar();
        listarC();
    }

    private List <Compras> listarC() {
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        Query query1 = reference.child("bdcompras").limitToFirst(100);
        query1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objSnaptshot : snapshot.getChildren()){
                    Compras datos = objSnaptshot.getValue(Compras.class);
                    list.add(datos);
                }
                adapter = new ArrayAdapter<Compras>(PedidosAdmin.this, android.R.layout.simple_list_item_1, list);
                listCompras.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return list;
    }

    private void referenciar() {
        listCompras=findViewById(R.id.pedidosComprados); }
}