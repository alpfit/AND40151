package com.apillay.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private float altura;
    private float peso;
    private float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button computebtn = (Button) findViewById(R.id.compute_button);
        final EditText heightet = (EditText)findViewById(R.id.height);
        final EditText weightet = (EditText)findViewById(R.id.weight);
        final TextView result = (TextView)findViewById(R.id.result);
        computebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = "";
                if (heightet.getText().length() > 0 && weightet.getText().length() > 0) {
                    altura = Float.parseFloat(heightet.getText().toString());
                    peso = Float.parseFloat(weightet.getText().toString());
                    bmi = calculateBMI(peso, altura);
                    resultado = String.format("Your BMI: %1$f ( ",bmi);
                    if (bmi < 16) {
                        resultado += "Severely underweight )";
                    }
                    else if (bmi < 18.5) {
                        resultado += "underweight )";
                    }
                    else if (bmi < 25) {
                        resultado += "Normal )";
                    }
                    else if (bmi < 30) {
                        resultado += "Overweight )";
                    }
                    else {
                        resultado += "Obese )";
                    }
                }
                result.setText(resultado);
            }
        });
    }

    private float calculateBMI(float peso, float altura) {
        altura = altura/100;
        return (float)(peso/Math.pow(altura,2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
