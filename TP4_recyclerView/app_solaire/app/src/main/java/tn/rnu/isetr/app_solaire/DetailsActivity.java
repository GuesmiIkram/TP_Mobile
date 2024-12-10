package tn.rnu.isetr.app_solaire;

import android.content.Context;
import android.content.Intent;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class DetailsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView imageViewPhoto = findViewById(R.id.imageViewDetailPhoto);
        TextView textViewNom = findViewById(R.id.textViewDetailNom);
        TextView textViewDistance = findViewById(R.id.textViewDetailDistance);
        TextView textViewMasse = findViewById(R.id.textViewDetailMasse);
        TextView textViewPeriode = findViewById(R.id.textViewDetailPeriode);
        Button buttonRetour = findViewById(R.id.buttonRetour);

        Intent intent = getIntent();
        textViewNom.setText(intent.getStringExtra("nom"));
        imageViewPhoto.setImageResource(intent.getIntExtra("photoResId", 0));
        textViewDistance.setText("Distance au Soleil : " + intent.getStringExtra("distanceSoleil"));
        textViewMasse.setText("Masse : " + intent.getStringExtra("masse"));
        textViewPeriode.setText("Période de révolution : " + intent.getStringExtra("periodeRevolution"));

        buttonRetour.setOnClickListener(v -> {
            // Revenir à la MainActivity
            Intent retourIntent = new Intent(DetailsActivity.this, MainActivity.class);
            startActivity(retourIntent);
            finish(); // Optionnel : pour fermer la page de détails et éviter de revenir à elle si l'utilisateur appuie sur retour
        });

    }
}
