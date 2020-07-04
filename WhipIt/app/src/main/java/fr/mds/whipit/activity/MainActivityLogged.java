package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.mds.whipit.R;


public class MainActivityLogged extends Activity implements View.OnClickListener {

    CardView cakes;
    CardView bakers;
    CardView myorders;
    CardView demandeSpe;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_logged);
        cakes = findViewById(R.id.cv_all_cakes);
        bakers = findViewById(R.id.cv_bakers);
        myorders = findViewById(R.id.cv_my_orders);
        demandeSpe = findViewById(R.id.cv_custom_orders);
        bottomNavigationView = findViewById(R.id.bottomNav);
        cakes.setOnClickListener(this);
        bakers.setOnClickListener(this);
        myorders.setOnClickListener(this);
        demandeSpe.setOnClickListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.action_messages:
                                Intent intent = new Intent(MainActivityLogged.this, MessagesActivity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case R.id.action_help:
                                intent = new Intent(MainActivityLogged.this, HelpActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.action_profile:
                                intent = new Intent(MainActivityLogged.this, ProfileActivity.class);
                                startActivity(intent);
                                break;

                        }
                        return true;
                    }
        });
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_all_cakes:
                Intent intent = new Intent(MainActivityLogged.this, AllCakesActivity.class);
                startActivity(intent);
                break;

            case R.id.cv_bakers:
                 intent = new Intent(MainActivityLogged.this, BakersActivity.class);
                startActivity(intent);
                break;

            case R.id.cv_my_orders:
                intent = new Intent(MainActivityLogged.this, MyOrdersActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_custom_orders:
                intent = new Intent(MainActivityLogged.this, CustomOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
