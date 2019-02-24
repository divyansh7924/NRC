package info.androidhive.recyclerview;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class registration extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        btn = (Button)findViewById(R.id.file);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browsefile();
            }
        });
    }

    public void browsefile(){
    }
}
