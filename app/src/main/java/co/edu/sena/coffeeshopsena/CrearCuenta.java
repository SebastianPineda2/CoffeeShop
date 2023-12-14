package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import co.edu.sena.coffeeshopsena.modelos.Usuarios;

public class CrearCuenta extends AppCompatActivity {

    private EditText mEditTextNombre;
    private EditText mEditTextApellido;
    private EditText mEditTextCorreo;
    private EditText mEditTextPassword;
    private EditText mEditTextNumeroDocumento;

    private Button mButtonRegistro;
    private Spinner spinnerTipo;

    private Spinner spinnerperfil;
    private RadioButton buttonMasculino;
    private RadioButton buttonFemenino;
    private RadioButton buttonOtros;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    private Usuarios usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        //Menu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.crearcuenta);

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


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        usuario = new Usuarios();

        mEditTextNombre=(EditText) findViewById(R.id.editTextNombre);
        mEditTextApellido=(EditText) findViewById(R.id.edtTextApelliido);
        mEditTextCorreo=(EditText) findViewById(R.id.editTextCorreo);
        mEditTextPassword=(EditText) findViewById(R.id.editTextPassword);
        mEditTextNumeroDocumento=(EditText) findViewById(R.id.txtNumeroDocumento);

        mButtonRegistro=(Button) findViewById(R.id.btnRegistro);
        spinnerTipo = findViewById(R.id.tipoDocumento);
        spinnerperfil = findViewById(R.id.perfil);
        buttonMasculino = findViewById(R.id.masculino);
        buttonFemenino = findViewById(R.id.femenino);
        buttonOtros = findViewById(R.id.otro);

        mButtonRegistro.setOnClickListener(view -> {

            usuario.setNombre(mEditTextNombre.getText().toString());
            usuario.setApellido(mEditTextApellido.getText().toString());
            usuario.setCorreo(mEditTextCorreo.getText().toString());
            usuario.setPassword(mEditTextPassword.getText().toString());
            usuario.setMumeroDocumento(mEditTextNumeroDocumento.getText().toString());
            usuario.setTipoCedula(spinnerTipo.getSelectedItem().toString());
            usuario.setRol(spinnerperfil.getSelectedItem().toString());
            if(buttonMasculino.isChecked()){
                usuario.setGenero("Masculino");
            }else {
                if (buttonFemenino.isChecked()) {
                    usuario.setGenero("Femenino");
                } else {
                    if (buttonOtros.isChecked()) {
                        usuario.setGenero("Otros");
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                if (!usuario.getNombre().isEmpty() && !usuario.getApellido().isEmpty() && !usuario.getCorreo().isEmpty() && !usuario.getPassword().isEmpty()) {
                    if (usuario.getPassword().length() >= 6) {
                        registerUser();
                    } else {
                        Toast.makeText(CrearCuenta.this, "Error la contraseña debe tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CrearCuenta.this, "Error campo no puede estar vacío", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void registerUser() {
        mAuth.createUserWithEmailAndPassword(usuario.getCorreo(), usuario.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {


                    //DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Productos");
                   // reference.child(obj.getId()).setvalue(obj);
                     //reference.child(fecha).
                    //
                    // child(obj.getId()).setvalue(obj);
                    //
                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task1) {
                            if(task1.isSuccessful()) {
                                startActivity( new Intent(CrearCuenta.this,InicioSesion.class));
                                finish();
                            }
                        }
                    });

                }
                else {
                    Toast.makeText( CrearCuenta.this,"Este usuario ya está registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}