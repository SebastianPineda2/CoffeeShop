package co.edu.sena.coffeeshopsena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SubMenuUno extends AppCompatActivity {

    BottomNavigationView bottomNavigationView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_uno);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNav1);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Intent i;
            Intent e;
            switch (item.getItemId()) {
                case R.id.iniciarsesion:
                    e = new Intent(SubMenuUno.this,InicioSesion.class);
                    startActivity(e);
                    break;
                case R.id.crearcuenta:
                    i = new Intent(SubMenuUno.this,CrearCuenta.class);
                    startActivity(i);
                    break;
            }
            return true;
        }


    };

    /*public void RelativeLayout (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container1, fragment);
        transaction.commit();
    } */

}