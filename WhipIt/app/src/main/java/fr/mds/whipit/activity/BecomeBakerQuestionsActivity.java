package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class BecomeBakerQuestionsActivity extends Activity implements View.OnClickListener {

    Button demande;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_baker_questions);
        demande = findViewById(R.id.bt_demande);
        demande.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BecomeBakerQuestionsActivity.this, BecomeBakerRequestSentActivity.class);
        startActivity(intent);
    }
}
