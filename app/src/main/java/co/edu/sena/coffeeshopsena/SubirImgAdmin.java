package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import id.zelory.compressor.Compressor;

public class SubirImgAdmin extends AppCompatActivity {

    ImageView fotos;
    Button subir, seleccionar;
    DatabaseReference imgref;
    StorageReference storageReference;
    ProgressDialog cargando;

    Bitmap thumb_bitmap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_img_admin);

        fotos = findViewById(R.id.img_foto);
        seleccionar = findViewById(R.id.btn_selefoto);
        subir = findViewById(R.id.btn_subirfoto);
        imgref = FirebaseDatabase.getInstance().getReference().child("imgcarta");
        storageReference = FirebaseStorage.getInstance().getReference().child("imgcarta");
        cargando = new ProgressDialog(this);

        seleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.startPickImageActivity(SubirImgAdmin.this);
            }
        });


        //Menu de navegación
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

    }
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri imageuri = CropImage.getPickImageResultUri(this,data);


            CropImage.activity(imageuri)
                      .setGuidelines(CropImageView.Guidelines.ON)
                      .setRequestedSize(640,480)
                      .setAspectRatio(2,1).start(SubirImgAdmin.this);
            }
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK){
                Uri resultUri = result.getUri();
                File url = new File(resultUri.getPath());
                Picasso.get().load(url).into(fotos);
                //comprimiendo---

                try {
                    thumb_bitmap = new Compressor(this)
                            .setMaxWidth(640)
                            .setMaxHeight(480)
                            .setQuality(90)
                            .compressToBitmap(url);

                } catch (IOException e){
                    e.printStackTrace();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumb_bitmap.compress(Bitmap.CompressFormat.JPEG,90,byteArrayOutputStream);
                final byte [] thum_byte =byteArrayOutputStream.toByteArray();
                 //fin compresion
                int p = (int) (Math.random() * 25 + 1); int s = (int) (Math.random() * 25 + 1);
                int t = (int) (Math.random() * 25 + 1); int c = (int) (Math.random() * 25 + 1);
                int numero1 = (int) (Math.random() * 1012 + 2111);
                int numero2 = (int) (Math.random() * 1012 + 2111);

                String[] elementos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "y", "z"};

                final String   aleatorio = elementos[p] + elementos[s] + numero1 + elementos[t] + elementos[c] + numero2 + "img .jpg";

             subir.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     cargando.setTitle("Subiendo Imagen...");
                     cargando.setTitle("Espere por favor");
                     cargando.show();

                     StorageReference ref = storageReference.child(aleatorio);
                     UploadTask uploadTask = ref.putBytes(thum_byte);


                     Task<Uri> uriTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                         @Override
                         public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                             if(!task.isSuccessful()){
                                 throw Objects.requireNonNull(task.getException());

                             }

                             return ref.getDownloadUrl();
                         }
                     }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                         @Override
                         public void onComplete(@NonNull Task<Uri> task) {
                             Uri downloaduri = task.getResult();
                             imgref.push().child("urlfoto").setValue(downloaduri.toString());
                             cargando.dismiss();
                             Toast.makeText(SubirImgAdmin.this, "Imagen cargada", Toast.LENGTH_SHORT).show();

                         }
                     });
                 }
             });
            }
        }
    }

    public void atrasCartaUno(View view) {
        Intent aRegistrarPr = new Intent(SubirImgAdmin.this,CartaAdmin.class);
        startActivity(aRegistrarPr);
    }
}