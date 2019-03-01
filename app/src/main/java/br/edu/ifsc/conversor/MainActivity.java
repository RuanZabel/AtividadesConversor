package br.edu.ifsc.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void converter(View view) {
        double result = 0;
        Spinner sp1 =(Spinner) findViewById(R.id.spinner);
        Spinner sp2 =(Spinner) findViewById(R.id.spinner3);
        EditText valor1 =(EditText) findViewById(R.id.editText3);

        if(sp1.getSelectedItem().toString().equals("Celsius")){
            if(sp2.getSelectedItem().toString().equals("Fahrenheit")){
                result = converterCelsiusF(Double.parseDouble(valor1.getText().toString()));


            }else{
                if(sp2.getSelectedItem().toString().equals("Kelvin")){
                    result = converterCpF(Double.parseDouble(valor1.getText().toString()));
                }
            }
        }else{
            if(sp1.getSelectedItem().toString().equals("Fahrenheit")){
                if(sp2.getSelectedItem().toString().equals("Kelvin")){
                    result = converterFpK(Double.parseDouble(valor1.getText().toString()));
                }else{
                    if(sp2.getSelectedItem().toString().equals("Celsius")){
                        result = converterFpc(Double.parseDouble(valor1.getText().toString()));
                    }
                }
            }else{
                if(sp2.getSelectedItem().toString().equals("Celsius")){
                    result = converterkpc(Double.parseDouble(valor1.getText().toString()));
                }else{
                    if(sp2.getSelectedItem().toString().equals("Fahrenheit")){
                        result = converterKpf(Double.parseDouble(valor1.getText().toString()));
                    }
                }

            }
        }

        TextView res = (TextView) findViewById(R.id.textView3);
        res.setText(""+result);

    }

    private double converterKpf(double v) {
        return (v - 273.15) * 9/5 + 32;
    }

    private double converterkpc(double v) {
        return v - 273.15;
    }

    private double converterFpc(double v) {
        return v -32* 5/9;
    }

    private double converterFpK(double v) {


        return (v - 32) * 5/9 + 273.15;
    }

    private double converterCpF(double v) {
        return v + 273.15;
    }

    private double converterCelsiusF(double v1) {
        return  (v1 * 9/5) + 32;
    }
}
