package com.example.yoapp;

public class Converter {

    //Set the fields for storing the
    // obtained values​of length,
    // weight and temperature.
    //Length
    public double Centimetre =0.0;
    public double Foot = 0.0;
    public double Inch = 0.0;
    //Weight
    public double Gram =0.0;
    public double Ounce = 0.0;
    public double Pound = 0.0;
    //Temperature
    public double Fahreheit =0.0;
    public double Kelvin = 0.0;

    /**
     * define three methods that will change the values
     * ​​of these fields. The fields
     * will accordingly change from the
     * work of the corresponding methods.
     * @param unit
     */
    /**
     * this method takes the number of meters
     * as parameters, and changes the
     * appropriate measures of length
     * @param unit
     */
    public void InputMetre(double unit){

        Centimetre = unit*100;
        Foot =  unit*3.28;
        Inch = unit*39.37;
    }

    /**
     * This method takes as parameters the
     * number of degrees Celsius, and changes
     * the corresponding temperature
     * @param unit
     */
    public void InputCelsius(double unit){

        Fahreheit = (unit * 9/5) + 32;
        Kelvin =  unit + 273.15;
    }

    /**
     * This method accepts the number of kilograms
     * as parameters, and changes the
     * corresponding mass values.
     * @param unit
     */
    public void InputKilogramm(double unit){

        Gram = unit*1000;
        Pound = unit*2.20462;
        Ounce = unit*35.274;
    }


}
