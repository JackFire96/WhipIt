package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

import fr.mds.whipit.R;



public class MainActivity extends Activity implements View.OnClickListener {

    CardView cakes;
    CardView bakers;
    CardView signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cakes = findViewById(R.id.cv_all_cakes);

        bakers = findViewById(R.id.cv_bakers);
        signin = findViewById(R.id.cv_signin);
        cakes.setOnClickListener(this);
        bakers.setOnClickListener(this);
        signin.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_all_cakes:
                Intent intent = new Intent(MainActivity.this, AllCakesActivity.class);
                startActivity(intent);
                break;

            case R.id.cv_bakers:
                 intent = new Intent(MainActivity.this, BakersActivity.class);
                startActivity(intent);
                break;

            case R.id.cv_signin:
                intent = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(intent);
                break;

        }
    }
}
