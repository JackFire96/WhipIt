package fr.mds.whipit.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class CustomOrderCompleteActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order_complete);
    }
}
