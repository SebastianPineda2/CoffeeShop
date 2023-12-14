package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.edu.sena.coffeeshopsena.modelos.Usuarios;

public class InicioSesion extends AppCompatActivity {

    private EditText mEditTextCorreo;
    private EditText mEditTextContraseña;

    //Conexión Firebase
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;

    //Valor de almacenamiento de permisos App
    int REQUEST_CODE = 200;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);


        //Menu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.iniciarsesion);

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


        //Conexión Firebase
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");

        mEditTextCorreo = findViewById(R.id.txtEmail);
        mEditTextContraseña = findViewById(R.id.txtPassword);

        //Permisos de la App
        verificarPermisos();
    }

    //Permisos de la App
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarPermisos(){

        int permiMaps = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permiInternet = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int permiEscribirAlmcExterno = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permiLeerAlmcInterno = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permiCamara = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if(permiMaps ==  PackageManager.PERMISSION_GRANTED && permiInternet == PackageManager.PERMISSION_GRANTED && permiEscribirAlmcExterno == PackageManager.PERMISSION_GRANTED && permiLeerAlmcInterno == PackageManager.PERMISSION_GRANTED && permiCamara == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permisos con exito", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},REQUEST_CODE);
        }
    }

    public void onStar(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void login (View view){
        mAuth.signInWithEmailAndPassword(mEditTextCorreo.getText().toString(), mEditTextContraseña.getText().toString())
                .addOnCompleteListener(InicioSesion.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            //startActivity( new Intent(InicioSesion.this,InicioUsuarios.class));
                            FirebaseUser user = mAuth.getCurrentUser();
                            reference.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    Usuarios copiaBd = snapshot.getValue(Usuarios.class);
                                    if(copiaBd.getRol().equals("Usuario")){
                                        Intent intent = new Intent(InicioSesion.this,InicioUsuarios.class);
                                        startActivity(intent);
                                    } else{
                                        if(copiaBd.getRol().equals("Administrador")){
                                            Intent intent = new Intent(InicioSesion.this,InicioAdmin.class);
                                            startActivity(intent);
                                        }
                                        else{
                                            if(copiaBd.getRol().equals("Empleado")){
                                                Intent intent = new Intent(InicioSesion.this,PedidosEmpleado.class);
                                                startActivity(intent);
                                            }
                                        }
                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        }else{
                            Toast.makeText(getApplicationContext(),"Correo o contraseña es incorrecta",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    //Interfaz de Restablecer Contraseña
    public void restablecerPassword(View view) {
        Intent rPassword = new Intent(InicioSesion.this,RecuperarPassword.class);
        startActivity(rPassword);
    }

}