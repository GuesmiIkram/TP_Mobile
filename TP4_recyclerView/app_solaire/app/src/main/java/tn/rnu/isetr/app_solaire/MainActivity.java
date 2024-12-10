package tn.rnu.isetr.app_solaire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPlanetes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Planete> planetes = new ArrayList<>();
        planetes.add(new Planete("Mercure", R.drawable.mercure, "57.91 million km", "3.3011×10^23 kg", "88 jours"));
        planetes.add(new Planete("Vénus", R.drawable.venus, "108.2 million km", "4.8675×10^24 kg", "225 jours"));
        planetes.add(new Planete("La Terre", R.drawable.terre, "149.6 million km", "5.972×10^24 kg", "365.25 jours"));
        planetes.add(new Planete("Mars", R.drawable.mars, "227.9 million km", "6.4171×10^23 kg", "687 jours"));

        PlaneteAdapter adapter = new PlaneteAdapter(planetes,this);
        recyclerView.setAdapter(adapter);
    }
}
