package com.example.codetmn17.geomcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TreygActivity extends AppCompatActivity {
    private int key;
    private EditText editTextTreygA;
    private EditText editTextTreygB;
    private EditText editTextTreygC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treyg);

        key = getIntent().getExtras().getInt("key");
        editTextTreygA = (EditText)findViewById(R.id.editTextTreygA);
        editTextTreygB = (EditText)findViewById(R.id.editTextTreygB);
        editTextTreygC = (EditText)findViewById(R.id.editTextTreygC);
    }

    public void onClickTreygRez(View view) {
        double a = Double.parseDouble(editTextTreygA.getText().toString());
        double b = Double.parseDouble(editTextTreygB.getText().toString());
        double c = Double.parseDouble(editTextTreygC.getText().toString());
        double rez;
        if (key == 1){
            rez = a + b + c;
        }
        else{
            double pp = (a + b + c) / 2;
            rez = Math.sqrt(pp * (pp - a) * (pp - b) + (pp - c));
        }
        Toast.makeText(getApplicationContext(), Double.toString(rez), Toast.LENGTH_LONG).show();
    }
}
