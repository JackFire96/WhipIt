package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class CakeLayer1Activity extends Activity implements View.OnClickListener {

    Button order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_layer1);
        order = findViewById(R.id.bt_order);
        order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         Intent intent = new Intent(CakeLayer1Activity.this, OrderActivity.class);
         startActivity(intent);
    }
}
