package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class InicioUsuarios extends AppCompatActivity {


    private ImageView img, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuarios);

        img2 = (ImageView) findViewById(R.id.imgInicio2);

        //Menu de navegación
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

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

        /*magen -> Covid
        img1 = (ImageView) findViewById(R.id.img001);
        String url = ""; */

        //Img Deslizable
        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fimgcovid1901.jpg?alt=media&token=d8b05aa0-007e-4056-ac2a-9aaadfa0288c"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Flunesma%C3%B1ana.jpg?alt=media&token=1f4af238-9ae5-4623-9d2d-62f4760df166","Lunes | Mañana"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fmartesma%C3%B1ana.jpg?alt=media&token=ab3173e4-f0b7-4120-80dc-aac02f4327da","Martes | Mañana"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fmiercolesma%C3%B1ana.jpg?alt=media&token=ab8d5b1a-b1ca-453b-86e3-bb46df5b17dc","Miercoles | Mañana"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fjuevesma%C3%B1ana.jpg?alt=media&token=7d71d98c-fa38-4bb6-a9a3-7023399a63ab","Jueves | Mañana"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fviernesma%C3%B1ana.jpg?alt=media&token=8ccdf3f2-a059-4c83-8cd2-df1ecaff1d0f","Viernes | Mañana"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b","Lunes | Tarde"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b","Martes | Tarde"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b","Miercoles | Tarde"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b","Jueves | Tarde"));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fnoestadisponible.jpg?alt=media&token=b43028bb-8046-4dfa-9e61-f52a42dfb15b","Viernes | Tarde"));
        imageSlider.setImageList(slideModels,true);


        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/coffeeshopsena-a91ff.appspot.com/o/imgcarta%2Fbienvenidousuario.png?alt=media&token=2cf72766-951a-4dbb-a5d8-87f776b8a2ff").into(img2);

    }


    public void verUsuario(View view) {
        Intent aUsuario = new Intent(InicioUsuarios.this,AyudaUsuario.class);
        startActivity(aUsuario);
    }
}