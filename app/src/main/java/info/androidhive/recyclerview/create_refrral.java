package info.androidhive.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class create_refrral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_refrral);
    }

    public void onRadioButtonClicked(View v) {


        //is the current radio button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch (v.getId()) {

            case R.id.child_male:
                if (checked)

                    break;

            case R.id.child_female:
                if (checked)

                    break;

            case R.id.child_other:
                if (checked)

                    break;
        }
    }
}
