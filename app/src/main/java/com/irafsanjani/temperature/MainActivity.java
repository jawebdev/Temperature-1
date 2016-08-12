package com.irafsanjani.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText celsius;
    private EditText fahrenheit;
    private TextView cText,fText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celsius = (EditText) findViewById(R.id.celsiusEdit);
        fahrenheit = (EditText) findViewById(R.id.fahrenheitEdit);
    }

    public void convertTemperature(View view){

        cText = (TextView) findViewById(R.id.cText);
        fText = (TextView) findViewById(R.id.fText);

        if(celsius.getText().toString().isEmpty() && fahrenheit.getText().toString().isEmpty()){
            Toast.makeText(getBaseContext(),"Input at least one value", Toast.LENGTH_SHORT).show();
        }

        if(fahrenheit.getText().toString().isEmpty()){
            fText.setText(null);
        }
        else{
            double c = Converter.fahrenheitToCelsius(Double.parseDouble(fahrenheit.getText().toString()));
            cText.setText("Celsius = " + String.valueOf(c) + " C");
        }

        if(celsius.getText().toString().isEmpty()){
            cText.setText(null);
        }
        else{
            double f = Converter.celsiusToFahrenheit(Double.parseDouble(celsius.getText().toString()));
            fText.setText("Fahrenheit = " + String.valueOf(f) + " F");
        }
    }
}
