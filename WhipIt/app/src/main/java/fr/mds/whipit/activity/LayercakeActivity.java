package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;
import fr.mds.whipit.R;

public class LayercakeActivity extends Activity implements View.OnClickListener {
    CircleImageView cake1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layercakes);
        cake1 = findViewById(R.id.profile_image);
        cake1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LayercakeActivity.this, CakeLayer1Activity.class);
        startActivity(intent);
    }
}