package com.eproject.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new currency_fragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_currency);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch(item.getItemId()){
                case R.id.nav_currency:
                    fragment = new currency_fragment();
                    break;
                case R.id.nav_crypto:
                    fragment = new CryptoFragment();
                    break;
                case R.id.nav_aboutus:
                    fragment = new AboutUsFragment();
                    break;
                case R.id.nav_settings:
                    fragment = new SettingFragment();
                    break;
            }
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
            return true;
        });
    }
}