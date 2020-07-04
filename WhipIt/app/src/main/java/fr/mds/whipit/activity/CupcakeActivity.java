package fr.mds.whipit.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;
import fr.mds.whipit.R;

public class CupcakeActivity extends Activity implements View.OnClickListener {

    CircleImageView cake1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakes);
        cake1 = findViewById(R.id.profile_image);
    }

    @Override
    public void onClick(View v) {

    }
}
