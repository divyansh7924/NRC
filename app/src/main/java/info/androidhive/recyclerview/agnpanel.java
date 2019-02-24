package info.androidhive.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class agnpanel extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agnpanel);
        btn = (Button)findViewById(R.id.btn_listnrc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrclist();
            }
        });
    }


    public void nrclist() {
        Intent intent = new Intent(this, States.class);
        startActivity(intent);
    }
}