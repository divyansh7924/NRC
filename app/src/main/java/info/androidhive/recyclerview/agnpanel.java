package info.androidhive.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class agnpanel extends AppCompatActivity {

    private Button btn;
    private Button btn2;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agnpanel);
        btn = (Button)findViewById(R.id.btn_listnrc);
        btn2 = (Button) findViewById(R.id.btn_manageprofiles);
        btn1 = (Button) findViewById(R.id.btn_createprofile);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrclist();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageprofiles();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createchildprofile();
            }
        });
    }


    public void nrclist() {
        Intent intent = new Intent(this, States.class);
        startActivity(intent);
    }

    public void manageprofiles() {
        Intent intent = new Intent(this, agn_manage_profile.class);
        startActivity(intent);
    }

    public void createchildprofile() {
        Intent intent = new Intent(this, create_refrral.class);
        startActivity(intent);
    }
}

