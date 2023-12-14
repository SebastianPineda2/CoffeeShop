package co.edu.sena.coffeeshopsena;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Flash extends AppCompatActivity {

    private final int DURACION_SPLASH = 4000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        TimerTask destello = new TimerTask() {
            @Override
            public void run() {
                Intent inter = new Intent(Flash.this, InicioSesion.class);
                startActivity(inter);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(destello, 4000);
    }

}