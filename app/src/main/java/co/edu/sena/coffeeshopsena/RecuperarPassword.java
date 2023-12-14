package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class RecuperarPassword extends AppCompatActivity {

    private EditText correorecuperar;
    private FirebaseAuth conexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_password);

        //Menu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.pedidos);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.iniciarsesion:
                        startActivity(new Intent(getApplicationContext(), InicioSesion.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.crearcuenta:
                        startActivity(new Intent(getApplicationContext(), CrearCuenta.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        correorecuperar = findViewById(R.id.txtRecuperarCuenta);
        conexion = FirebaseAuth.getInstance();

    }


    public void btnEnviar(View view) {
        String correo = correorecuperar.getText().toString();
        conexion.sendPasswordResetEmail(correo).addOnCompleteListener(RecuperarPassword.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RecuperarPassword.this, "Revisa tu correo electronico", Toast.LENGTH_LONG).show();}

                else{Toast.makeText(RecuperarPassword.this, "No se encontro el correo electronico", Toast.LENGTH_LONG).show();}
            }
        });
    }

    public void interPrincipal(View view) {
        Intent iPrincipal = new Intent(RecuperarPassword.this,InicioSesion.class);
        startActivity(iPrincipal);
    }
}