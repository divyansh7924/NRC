package info.androidhive.recyclerview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class registration extends AppCompatActivity {

    private Button btn;
    private Button btn2;
    private StorageReference mStorageRef;
    private static final int PICK_PDF_REQUEST = 234;
    private Uri filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        btn = (Button)findViewById(R.id.file_nrc);
        btn2 = (Button)findViewById(R.id.submit_nrc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browsefile();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadfile();
            }
        });
    }

    public void browsefile(){
        Intent intent= new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select a PDF"), PICK_PDF_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_PDF_REQUEST && resultCode == RESULT_OK && data.getData() != null){
                filepath = data.getData();
            }
    }

    private void uploadfile() {
        if (filepath != null) {

            final ProgressDialog progressdialog = new ProgressDialog(this);
            progressdialog.setTitle("Uploading....");
            progressdialog.show();
            StorageReference regsRef = mStorageRef.child("regpdfs/");

            regsRef.putFile(filepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressdialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Application uploaded for review", Toast.LENGTH_LONG).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            progressdialog.dismiss();
                            Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    })
            .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    progressdialog.setMessage(((int)progress) + "%uploaded...");
                }
            });
        }
    }
}
