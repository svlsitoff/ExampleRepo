package com.example.yoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Converter converter;
    String[] data = {"Metre", "Kilograms", "Celsius"};
    EditText inputUnits;
    TextView lb1,lb2,lb3, out1, out2, out3;
    ImageButton lnbtn,wtbtn,tempbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        converter = new Converter();
        inputUnits = (EditText) findViewById(R.id.inputUnit);
        /**
         * we find by id the values ​​of the elements
         * that will display the obtained values.
         */
        lb1 = (TextView) findViewById(R.id.lbfirst);
        lb2 = (TextView) findViewById(R.id.lbsecond);
        lb3 = (TextView) findViewById(R.id.lbthird);
        out1 = (TextView) findViewById(R.id.first);
        out2 = (TextView) findViewById(R.id.second);
        out3 = (TextView) findViewById(R.id.third);
        lnbtn = (ImageButton) findViewById(R.id.ButtonLength);
        wtbtn = (ImageButton) findViewById(R.id.ButtonWeight);
        tempbtn = (ImageButton) findViewById(R.id.ButtonTemperature);
        /**
         * we create an adapter class object
         * and put our data into it (a string array),
         * then further declare a spinner object
         * (drop-down list) and put our adapter into
         * it, so the spinner is filled with values.
         * And depending on the selected position,
         * we call the appropriate converter class
         * methods, passing it the values ​​of the
         * edittext field as parameters.
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Title");
        spinner.setSelection(2);
        /**
         * define an event handler for edittext,
         * when changing the entered text
         * we will call the method from the converter class,
         * thereby the values ​​
         * of the displayed fields will change,
         * depending on the number entered.
         */
        inputUnits.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                DecimalFormat df =  new DecimalFormat("##.##");

                if(s.length() != 0){
                    int position = spinner.getSelectedItemPosition();
                    if(position==0){
                        double unit = 0;
                        if(inputUnits.getText().length()>0){
                            unit = Double.parseDouble(inputUnits.getText().toString()) ;
                        }
                        converter.InputMetre(unit);
                        lb1.setText("Centimetre");
                        lb2.setText("Inch");
                        lb3.setText("Foot");
                        out1.setText(df.format(converter.Centimetre));
                        out2.setText(df.format(converter.Inch));
                        out3.setText(df.format(converter.Foot));
                    }
                    if(position==1){
                        double unit = 0;
                        if(inputUnits.getText().length()>0){
                            unit = Double.parseDouble(inputUnits.getText().toString()) ;
                        }
                        converter.InputKilogramm(unit);
                        lb1.setText("Gram");
                        lb2.setText("Pound");
                        lb3.setText("Ounce");
                        out1.setText(df.format(converter.Gram));
                        out2.setText(df.format(converter.Pound));
                        out3.setText(df.format(converter.Ounce));
                    }
                    if(position==2){
                        double unit = 0;
                        if(inputUnits.getText().length()>0){
                            unit = Double.parseDouble(inputUnits.getText().toString()) ;
                        }
                        converter.InputCelsius(unit);
                        lb1.setText("Fahreheit");
                        lb2.setText("Kelvin");
                        lb3.setText("");
                        out1.setText(df.format(converter.Fahreheit));
                        out2.setText(df.format(converter.Kelvin));
                        out3.setText("");
                    }

                }

            }
        });
        /**
         * we also define an event handler for the spinner.
         * When choosing a position, the corresponding converter
         * class method will also be called. In this way,
         * the application responds both to the
         * input of values ​​and to the choice of measured values.
         */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                DecimalFormat df =  new DecimalFormat("##.##");

                if(inputUnits.getText().length() != 0){
                    if(position==0){
                        double unit = 0;
                        if(inputUnits.getText().length()>0){
                            unit = Double.parseDouble(inputUnits.getText().toString()) ;
                        }
                        converter.InputMetre(unit);
                        lb1.setText("Centimetre");
                        lb2.setText("Inch");
                        lb3.setText("Foot");
                        out1.setText(df.format(converter.Centimetre));
                        out2.setText(df.format(converter.Inch));
                        out3.setText(df.format(converter.Foot));
                    }
                    if(position==1){
                        double unit = 0;
                        if(inputUnits.getText().length()>0){
                            unit = Double.parseDouble(inputUnits.getText().toString()) ;
                        }
                        converter.InputKilogramm(unit);
                        lb1.setText("Gram");
                        lb2.setText("Pound");
                        lb3.setText("Ounce");
                        out1.setText(df.format(converter.Gram));
                        out2.setText(df.format(converter.Pound));
                        out3.setText(df.format(converter.Ounce));
                    }
                    if(position==2){
                        double unit = 0;
                        if(inputUnits.getText().length()>0){
                            unit = Double.parseDouble(inputUnits.getText().toString()) ;
                        }
                        converter.InputCelsius(unit);
                        lb1.setText("Fahreheit");
                        lb2.setText("Kelvin");
                        lb3.setText("");
                        out1.setText(df.format(converter.Fahreheit));
                        out2.setText(df.format(converter.Kelvin));
                        out3.setText("");
                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        /**
         * Define event handlers for buttons
         */
        lnbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                DecimalFormat df =  new DecimalFormat("##.##");
                spinner.setSelection(0);
                double unit = 0;
                if(inputUnits.getText().length()>0){
                    unit = Double.parseDouble(inputUnits.getText().toString()) ;
                }
                converter.InputMetre(unit);
                lb1.setText("Centimetre");
                lb2.setText("Inch");
                lb3.setText("Foot");
                out1.setText(df.format(converter.Centimetre));
                out2.setText(df.format(converter.Inch));
                out3.setText(df.format(converter.Foot));
            }
        });
        wtbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                DecimalFormat df =  new DecimalFormat("##.##");
                spinner.setSelection(1);
                double unit = 0;
                if(inputUnits.getText().length()>0){
                    unit = Double.parseDouble(inputUnits.getText().toString()) ;
                    converter.InputKilogramm(unit);
                    lb1.setText("Gram");
                    lb2.setText("Pound");
                    lb3.setText("Ounce");
                    out1.setText(df.format(converter.Gram));
                    out2.setText(df.format(converter.Pound));
                    out3.setText(df.format(converter.Ounce));
                }

            }
        });
        tempbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                DecimalFormat df =  new DecimalFormat("##.##");
                spinner.setSelection(2);
                double unit = 0;
                if(inputUnits.getText().length()>0){
                    unit = Double.parseDouble(inputUnits.getText().toString()) ;
                    converter.InputCelsius(unit);
                    lb1.setText("Fahreheit");
                    lb2.setText("Kelvin");
                    lb3.setText("");
                    out1.setText(df.format(converter.Fahreheit));
                    out2.setText(df.format(converter.Kelvin));
                    out3.setText("");
                }

            }
        });

    }

}
