package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ShipItem shipItem;

    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem();

        weightET = (EditText) findViewById(R.id.editWeight);

        baseCostTV = (TextView) findViewById(R.id.baseCostDisplay);
        addedCostTV = (TextView) findViewById(R.id.addedCostDisplay3);
        totalCostTV = (TextView) findViewById(R.id.totalCostDisplay);

        weightET.addTextChangedListener(weightTextWatcher);
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            } catch (NumberFormatException e) {
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };
    private void displayShipping() {
        baseCostTV.setText("$" + String.format("%.02f",shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f",shipItem.getAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f",shipItem.getTotalCost()));
    }
}
