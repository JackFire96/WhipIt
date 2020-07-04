package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class ComfirmCodePasswordActivity extends Activity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm_code_password);
        button = findViewById(R.id.button12);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ComfirmCodePasswordActivity.this, NewPasswordActivity.class);
        startActivity(intent);
    }
}
