package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class ModifyInfoActivity extends Activity implements View.OnClickListener {

    Button modif;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_info);
        modif = findViewById(R.id.bt_modif);
        modif.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ModifyInfoActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
