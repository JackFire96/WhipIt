package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import fr.mds.whipit.R;

public class MyOrdersActivity extends Activity implements View.OnClickListener {

    CardView order1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        order1 = findViewById(R.id.cv_disscussion1);
        order1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MyOrdersActivity.this, ActualOrderActivity.class);
        startActivity(intent);

    }
}
