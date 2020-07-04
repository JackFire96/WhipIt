package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import fr.mds.whipit.R;

public class MessagesActivity extends Activity implements View.OnClickListener {

    CardView discussion1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        discussion1 = findViewById(R.id.cv_disscussion1);
        discussion1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MessagesActivity.this, DiscussionActivity.class);
        startActivity(intent);
    }
}
