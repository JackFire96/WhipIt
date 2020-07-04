package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class Baker1Activity extends Activity implements View.OnClickListener {

    Button contact;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baker1);
        contact = findViewById(R.id.bt_contact);
        contact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Baker1Activity.this, DiscussionActivity.class);
        startActivity(intent);
    }
}
