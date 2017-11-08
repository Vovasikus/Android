package com.example.codetmn17.geomcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class KrugActivity extends AppCompatActivity {
    private int key;
    private EditText editTextKrugR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krug);

        key = getIntent().getExtras().getInt("key");
        editTextKrugR = (EditText)findViewById(R.id.editTextKrugR);
    }

    public void onClickKrugRez(View view) {
        double r = Double.parseDouble(editTextKrugR.getText().toString());
        double rez;
        if (key == 1){
            rez = 2 * Math.PI * r;
        }
        else{
            rez = Math.PI * r * r;
        }
        Toast.makeText(getApplicationContext(), Double.toString(rez), Toast.LENGTH_LONG).show();
    }
}
