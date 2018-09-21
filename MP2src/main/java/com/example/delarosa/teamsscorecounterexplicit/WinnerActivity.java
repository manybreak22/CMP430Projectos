package com.example.delarosa.teamsscorecounterexplicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    private TextView winnerT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        winnerT = findViewById(R.id.winner);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String winner = extras.getString("Winner");
        String bypoints = extras.getString("bypoints");
        winnerT.setText(" "+winner + "\n won the game \n by " +bypoints+" points.");

    }

    public void backMain (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
