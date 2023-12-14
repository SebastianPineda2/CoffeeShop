package co.edu.sena.coffeeshopsena;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class storage extends AppCompatActivity {
    private ImageView mImageView;
    private Button mUploadBtn;
    private StorageReference mStorage;
    private static final int GALLERY_INTENT=1;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

         mUploadBtn= (Button) findViewById(R.id.btnSubir);
         mStorage = FirebaseStorage.getInstance().getReference();
         mImageView = (ImageView) findViewById(R.id.SubirImagen);
         mProgressDialog = new ProgressDialog(this);

         mUploadBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent = new Intent( Intent.ACTION_PICK);
                 intent.setType("image/*");
                 startActivityForResult(intent,GALLERY_INTENT);
             }
         });
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);

        if (resultCode == GALLERY_INTENT && resultCode == RESULT_OK){
            mProgressDialog.setTitle("SUBIENDO");
            mProgressDialog.setMessage("Subiendo foto");
            mProgressDialog.setCancelable(false);
            Uri uri = data.getData();

            StorageReference filePath = mStorage.child("fotos").child(uri.getLastPathSegment());

            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mProgressDialog.dismiss();
                    Toast.makeText(storage.this, "Se subio exitosamente", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}