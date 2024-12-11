package tn.rnu.isetr.myapplication.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import tn.rnu.isetr.myapplication.R;
import tn.rnu.isetr.myapplication.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    private Controle controle;
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private RadioButton rdFemme;
    private TextView lblIMG;
    private ImageView imgSmiley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        ecouteCalcul();
    }

    private void init() {
        txtPoids = (EditText) findViewById(R.id.editTextNumber6);
        txtTaille = (EditText) findViewById(R.id.editTextNumber7);
        txtAge = (EditText) findViewById(R.id.editTextNumber8);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        rdFemme = (RadioButton) findViewById(R.id.rdFemme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgsmiley);
        this.controle = Controle.getInstance(this);
        ecouteCalcul();
        recupProfil();
    }

    private void ecouteCalcul() {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;

                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                    return; // Sortir si la saisie est incorrecte
                }

                if (rdHomme.isChecked()) {
                    sexe = 1;
                }

                if (poids == 0 || taille == 0 || age == 0) {
                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                } else {
                    afficheResult(poids, taille, age, sexe);
                }
            }
        });
    }

    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe) {
        controle.creerProfil(poids, taille, age, sexe, this);
        float img = controle.getImg();
        String message = controle.getMessage();

        if (message.equals("normal")) {
            imgSmiley.setImageResource(R.drawable.normale);
            lblIMG.setTextColor(Color.GREEN);
        } else {
            lblIMG.setTextColor(Color.RED);
            if (message.equals("trop faible")) {
                imgSmiley.setImageResource(R.drawable.maigre);
            } else {
                imgSmiley.setImageResource(R.drawable.graisse);
            }
        }
        lblIMG.setText(String.format("%.2f : IMG %s", img, message));
    }

    private void recupProfil() {
        if (controle.getPoids() != null) {
            txtPoids.setText(controle.getPoids().toString());
            txtTaille.setText(controle.getTaille().toString());
            txtAge.setText(controle.getAge().toString());
            rdFemme.setChecked(true);
            if (controle.getSexe() == 1) {
                rdHomme.setChecked(true);
            }
            ((Button) findViewById(R.id.btnCalc)).performClick();
        }
    }
}