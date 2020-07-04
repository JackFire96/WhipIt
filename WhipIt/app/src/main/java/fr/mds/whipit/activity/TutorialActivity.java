package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import fr.mds.whipit.R;

public class TutorialActivity extends Activity implements View.OnClickListener {

    public final static String TAG = "whipit";

    final int[] sampleImages = {R.mipmap.explications1, R.mipmap.explication2, R.mipmap.explication3, R.mipmap.explication4};


    private CarouselView carouselView;
    private Button btn_continuer;
    private Button btn_connexion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        carouselView = findViewById(R.id.carouselView);
        btn_continuer = findViewById(R.id.btn_continuer);
        btn_connexion = findViewById(R.id.btn_connexion);

        btn_continuer.setOnClickListener(this);
        btn_connexion.setOnClickListener(this);

        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_connexion:
                Intent intent = new Intent(TutorialActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_continuer:
                if (carouselView.getCurrentItem() < sampleImages.length-1) {
                    carouselView.setCurrentItem(carouselView.getCurrentItem() + 1);

                } else {
                    intent = new Intent(TutorialActivity.this, SigninActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
