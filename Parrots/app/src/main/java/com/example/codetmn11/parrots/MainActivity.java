package com.example.codetmn11.parrots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mInputEditText;
    private RadioButton meterRadioButton;
    private RadioButton parrotRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputEditText = (EditText)findViewById(R.id.editText);
        meterRadioButton = (RadioButton)findViewById(R.id.radioButtonMeter);
        parrotRadioButton = (RadioButton)findViewById(R.id.radioButtonParrot);
    }

    //Конвертируем в метры
    private float convertParrotToMeter(float parrot) {
        return (float) (parrot/7.6);
    }

    //Конвертируем в попугаи
    private float convertMeterToParrot(float meter) {
        return (float) (meter*7.6);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonConverter:
                RadioButton meterRadioButton = (RadioButton)findViewById(R.id.radioButtonMeter);

                if (mInputEditText.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Введите длину кота", Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(mInputEditText.getText().toString());
                if (meterRadioButton.isChecked()) {
                    mInputEditText.setText(String.valueOf(convertParrotToMeter(inputValue)));
                } else {
                    mInputEditText.setText(String.valueOf(convertMeterToParrot(inputValue)));
                }
                break;
        }
    }
}
