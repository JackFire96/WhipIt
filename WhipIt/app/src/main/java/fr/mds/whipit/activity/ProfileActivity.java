package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class ProfileActivity extends Activity implements View.OnClickListener {

    Button info;
    Button orders;
    Button payment;
    TextView password_change;
    TextView becomeBaker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        info = findViewById(R.id.myInfo);
        orders = findViewById(R.id.myOrders);
        payment = findViewById(R.id.payment_method);
        password_change = findViewById(R.id.password_change);
        becomeBaker = findViewById(R.id.becomeBaker);
        info.setOnClickListener(this);
        orders.setOnClickListener(this);
        payment.setOnClickListener(this);
        password_change.setOnClickListener(this);
        becomeBaker.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myInfo:
                Intent intent = new Intent(ProfileActivity.this, ModifyInfoActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.myOrders:
                intent = new Intent(ProfileActivity.this, MyOrdersActivity.class);
                startActivity(intent);
                break;

            case R.id.password_change:
                intent = new Intent(ProfileActivity.this, PasswordChangeActivity.class);
                startActivity(intent);
                break;
            case R.id.becomeBaker:
                intent = new Intent(ProfileActivity.this, BecomeBakerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
