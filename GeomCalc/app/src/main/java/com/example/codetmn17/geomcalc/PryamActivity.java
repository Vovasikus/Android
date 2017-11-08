package com.example.codetmn17.geomcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PryamActivity extends AppCompatActivity {
    private int key;
    private EditText editTextPryamA;
    private EditText editTextPryamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pryam);

        key = getIntent().getExtras().getInt("key");
        editTextPryamA = (EditText)findViewById(R.id.editTextPryamA);
        editTextPryamB = (EditText)findViewById(R.id.editTextPryamB);
    }

    public void onClickPryamRez(View view) {
        double a = Double.parseDouble(editTextPryamA.getText().toString());
        double b = Double.parseDouble(editTextPryamB.getText().toString());
        double rez;
        if (key == 1){
            rez = (a + b) * 2;
        }
        else{
            rez = a * b;
        }
        Toast.makeText(getApplicationContext(), Double.toString(rez), Toast.LENGTH_LONG).show();
    }
}
