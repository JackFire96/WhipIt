package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import fr.mds.whipit.R;

public class BakersActivity extends Activity implements View.OnClickListener {

    CardView baker1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakers);
        baker1 = findViewById(R.id.cv_1);
        baker1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BakersActivity.this, Baker1Activity.class);
        startActivity(intent);

    }
}
