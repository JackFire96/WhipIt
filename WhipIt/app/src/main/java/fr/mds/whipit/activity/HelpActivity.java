package fr.mds.whipit.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import fr.mds.whipit.R;

public class HelpActivity extends Activity implements View.OnClickListener {

    ImageView infos;
    ImageView livraison;
    ImageView commande;
    ImageView paiement;
    ImageView question;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        infos = findViewById(R.id.infoGenerales);
        livraison = findViewById(R.id.livraison);
        commande = findViewById(R.id.commande);
        paiement = findViewById(R.id.paiement);
        question =findViewById(R.id.question);
        infos.setOnClickListener(this);
        livraison.setOnClickListener(this);
        commande.setOnClickListener(this);
        paiement.setOnClickListener(this);
        question.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.infoGenerales:
                Intent intent = new Intent(HelpActivity.this, HelpInfoActivity.class);
                startActivity(intent);
                break;

            case R.id.livraison:
                intent = new Intent(HelpActivity.this, HelpLivraisonActivity.class);
                startActivity(intent);
                break;
            case R.id.commande:
                intent = new Intent(HelpActivity.this, HelpCommandeActivity.class);
                startActivity(intent);
                break;
            case R.id.paiement:
                intent = new Intent(HelpActivity.this, HelpPaiementActivity.class);
                startActivity(intent);
                break;
            case R.id.question:
                intent = new Intent(HelpActivity.this, HelpChatActivity.class);
                startActivity(intent);
                break;
        }
    }
}
