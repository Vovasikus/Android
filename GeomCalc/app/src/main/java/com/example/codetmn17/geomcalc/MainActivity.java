package com.example.codetmn17.geomcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButtonP;
    RadioButton radioButtonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonP = (RadioButton)findViewById(R.id.radioButtonP);
        radioButtonS = (RadioButton)findViewById(R.id.radioButtonS);
    }

    public void onClickFigure(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.buttonTreyg:
                intent = new Intent(MainActivity.this, TreygActivity.class);
                break;
            case R.id.buttonKvad:
                intent = new Intent(MainActivity.this, KvadActivity.class);
                break;
            case R.id.buttonPryam:
                intent = new Intent(MainActivity.this, PryamActivity.class);
                break;
            case R.id.buttonKrug:
                intent = new Intent(MainActivity.this, KrugActivity.class);
                break;
            default:
                intent = new Intent(MainActivity.this, TreygActivity.class);
        }
        if (radioButtonP.isChecked()){
            intent.putExtra("key", 1);
        }
        else{
            intent.putExtra("key", 2);
        }
        startActivity(intent);
    }
}
