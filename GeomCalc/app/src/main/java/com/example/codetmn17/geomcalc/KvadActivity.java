package com.example.codetmn17.geomcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class KvadActivity extends AppCompatActivity {
    private int key;
    private EditText editTextKvadA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kvad);

        key = getIntent().getExtras().getInt("key");
        editTextKvadA = (EditText)findViewById(R.id.editTextKvadA);
    }

    public void onClickKvadRez(View view) {
        double a = Double.parseDouble(editTextKvadA.getText().toString());
        double rez;
        if (key == 1){
            rez = a * 4;
        }
        else{
            rez = a * a;
        }
        Toast.makeText(getApplicationContext(), Double.toString(rez), Toast.LENGTH_LONG).show();
    }
}
