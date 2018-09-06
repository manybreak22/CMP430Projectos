package com.example.delarosa.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements TextWatcher,
        SeekBar.OnSeekBarChangeListener{

    private EditText amounttext;
    private TextView amountviewer;
    private TextView percentamountlb;
    private TextView tipviewer;
    private TextView totalviewer;
    private SeekBar percentbar;

    private double billAmount = 0.0;
    private double percent = .15;

    private static final NumberFormat numberFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amounttext = (EditText)findViewById(R.id.amounttext);
        amounttext.addTextChangedListener(this);
        amountviewer = (TextView)findViewById(R.id.amountviewer);
        percentamountlb = (TextView)findViewById(R.id.percentamountlb);
        tipviewer = (TextView)findViewById(R.id.tipviewer);
        totalviewer = (TextView)findViewById(R.id.totalviewer);
        tipviewer.setText(numberFormat.format(0));
        totalviewer.setText(numberFormat.format(0));
        percentbar = findViewById(R.id.percentbar);
        percentbar.setOnSeekBarChangeListener(this);
        percentamountlb.setText(percentFormat.format(percent));
    }


private void calc() {
    percentamountlb.setText(percentFormat.format(percent));

    double tip = billAmount * percent;
    double total = billAmount + tip;

    tipviewer.setText(numberFormat.format(tip));
    totalviewer.setText(numberFormat.format(total));
}
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }


    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Log.d("MainActivity", "inside onTextChanged method: charSequence= "+charSequence);
        try
        {
            billAmount = Double.parseDouble(charSequence.toString());

        }
        catch (NumberFormatException e)
        {
            amountviewer.setText("");
            billAmount = 0.0;
        }

        calc();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        percent = (double) progress / 100; //calculate percent based on seeker value
        calc();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}

    ;
