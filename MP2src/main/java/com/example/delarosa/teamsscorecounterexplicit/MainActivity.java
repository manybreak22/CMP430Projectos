package com.example.delarosa.teamsscorecounterexplicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView Aguilas;
    private TextView Licey;
    private Button licey;
    private Button aguilas;
    private Button reset;
    MediaPlayer merenguito;

    private int scoreAguilas = 0;
    private int scoreLicey = 0;
    private int bypoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Aguilas = (TextView) findViewById(R.id.Aguilas);
        aguilas = (Button) findViewById(R.id.button_AC);
        aguilas.setOnClickListener(this);
        Aguilas.setText("0" + scoreAguilas);
        Licey = (TextView) findViewById(R.id.Licey);
        licey = (Button) findViewById(R.id.button_TL);
        licey.setOnClickListener(this);
        Licey.setText("0" + scoreLicey);
        reset = (Button) findViewById(R.id.button_reset);
        reset.setOnClickListener(this);
        //merenguito = MediaPlayer.create(MainActivity.this, R.raw.mipueblo);
        //merenguito.start();
    }


    public void play(View view) {
        if (merenguito == null) {
            merenguito = MediaPlayer.create(MainActivity.this, R.raw.mipueblo);
            merenguito.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });

        }
        merenguito.start();
    }
    public void pause(View view) {
        if (merenguito != null) {
            merenguito.pause();
        }
    }

    public void stop(View view) {
        stopPlayer();
    }
    private void stopPlayer() {
        if (merenguito != null) {
            merenguito.release();
            merenguito = null;
        }

}

    public void onClick(View view) {
        if (reset.equals(view)) {
            reset();
        }
        if (aguilas.equals(view)) {
            scoreAguilas++;
            Aguilas.setText("0" + scoreAguilas);

            if (scoreAguilas == 5) {
                bypoints = scoreAguilas - scoreLicey;
                reset();
                Intent intent = new Intent(this, WinnerActivity.class);
                Bundle extras = new Bundle();
                extras.putString("Winner", "Aguilas Cibaeñas");
                extras.putString("bypoints", Integer.toString(bypoints));
                intent.putExtras(extras);
                startActivity(intent);
            }
        }
        if (licey.equals(view)) {
            scoreLicey++;
            Licey.setText("0" + scoreLicey);

            if (scoreLicey == 5) {
                bypoints = scoreLicey - scoreAguilas;
                reset();
                Intent intent = new Intent(this, WinnerActivity.class);
                Bundle extras = new Bundle();
                extras.putString("Winner", "Tigueres Del Licey");
                extras.putString("bypoints", Integer.toString(bypoints));
                intent.putExtras(extras);
                startActivity(intent);
            }
        }
    }

    public void reset() {
        scoreAguilas = 0;
        scoreLicey = 0;
        Aguilas.setText("0" + scoreAguilas);
        Licey.setText("0" + scoreLicey);
    }
        @Override
        protected void onStop() {
            super.onStop();
            stopPlayer();
        }


}


