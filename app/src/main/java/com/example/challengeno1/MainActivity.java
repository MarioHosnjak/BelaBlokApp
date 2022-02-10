package com.example.challengeno1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<GameResult> results = new ArrayList<>();;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recView);

        //setResults();
        setAdapter();

        Intent resultIntent = getIntent();
        int miResultNew = resultIntent.getIntExtra("miResult", 0);
        int viResultNew = resultIntent.getIntExtra("viResult", 0);
        System.out.println(miResultNew);
        System.out.println(viResultNew);

        System.out.println(results);
        if(!(miResultNew == 0 && viResultNew == 0))
        results.add(new GameResult(miResultNew, viResultNew));

        System.out.println(results);

        Button newWindowButton = findViewById(R.id.newWindowBtn);
        newWindowButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        });

    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private void setResults() {

        results.add(new GameResult(100, 62));
        results.add(new GameResult(120, 62));
        results.add(new GameResult(60, 122));
    }
}