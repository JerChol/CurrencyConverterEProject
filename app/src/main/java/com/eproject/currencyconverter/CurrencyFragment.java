package com.eproject.currencyconverter;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrencyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrencyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrencyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrencyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrencyFragment newInstance(String param1, String param2) {
        CurrencyFragment fragment = new CurrencyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    LinearLayout layoutList;
    Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_currency_fragment, container, false);

        layoutList = view.findViewById(R.id.currency_cards);
        addButton = (Button) view.findViewById(R.id.button_add_currency);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addView();
            }
        });

        return view;
    }

    private void addView() {
        final View currencyCardView = getLayoutInflater().inflate(R.layout.adding_currency_card,null,false);

        EditText editText = (EditText) currencyCardView.findViewById(R.id.enter_amount_currency);
        AppCompatSpinner spinnerCurrency = (AppCompatSpinner) currencyCardView.findViewById(R.id.currency_selector_spinner);
        ImageView imageRemove = (ImageView) currencyCardView.findViewById(R.id.imageView_remove_currency);

        /*
            The the information from the currencyconvrates.xml will be fed into an array that will
            be used by the spinner to generate the required selections
         */

        imageRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(currencyCardView);
            }
        });

        layoutList.addView(currencyCardView);
    }

    private void removeView(View view){

        layoutList.removeView(view);

    }

}