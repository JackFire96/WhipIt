package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;
import fr.mds.whipit.R;

public class AllCakesActivity extends Activity implements View.OnClickListener {

    ImageView imageLayerCakes;
    ImageView imageCupCakes;
    ImageView imageWeddingCakes;
    ImageView imageMacarons;
    ImageView imageTartelettes;
    ImageView imageNumberCakes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cakes);
        imageLayerCakes = findViewById(R.id.iv_layer);
        imageCupCakes = findViewById(R.id.iv_cup);
        imageWeddingCakes = findViewById(R.id.iv_wedding);
        imageMacarons = findViewById(R.id.iv_macaron);
        imageTartelettes = findViewById(R.id.iv_tartelettes);
        imageNumberCakes = findViewById(R.id.iv_number);
        imageLayerCakes.setOnClickListener(this);
        imageCupCakes.setOnClickListener(this);
        imageWeddingCakes.setOnClickListener(this);
        imageMacarons.setOnClickListener(this);
        imageTartelettes.setOnClickListener(this);
        imageNumberCakes.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_layer :
                Intent intent = new Intent(AllCakesActivity.this, LayercakeActivity.class);
                startActivity(intent);
                break;

            case R.id.iv_cup:
                intent = new Intent(AllCakesActivity.this, CupcakeActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_wedding:
                intent = new Intent(AllCakesActivity.this, WeddingcakeActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_macaron:
                intent = new Intent(AllCakesActivity.this, MacaronsActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_tartelettes:
                intent = new Intent(AllCakesActivity.this, TartelettesActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_number:
                intent = new Intent(AllCakesActivity.this, NumberCakesActivity.class);
                startActivity(intent);
                break;
        }
    }
}
