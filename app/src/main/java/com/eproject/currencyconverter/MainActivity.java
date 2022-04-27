package com.eproject.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     * The Currency converter will be very simple in code and all of the different currencies will be converted using the US dollar as the base conversion unit
     */

    /*
        - The offline version of the application will use standard conversion rates that will be updated from an online currency converter api when an internet connection is established
        - The basic layout of the application will have cards with:
            > Country flag
            > Currency Abbreviations
            > Text Field for accepting the numbers as a float
            >
        - Once the required amount is input into any of the cards, all of the cards shown convert the value to their currency
        - The user can add any currency card of their choosing (Crypto currencies may be added).
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}