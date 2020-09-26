package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView helloTextView;

    private boolean helloYes;

    private Button theButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTextView = findViewById(R.id.hello_world);
        helloYes = true;

        helloTextView = (TextView) findViewById(R.id.hello_world);
        theButton = (Button) findViewById(R.id.exclamation);
        theButton.setOnClickListener(helloListener);
    }

    private final View.OnClickListener helloListener = new View.OnClickListener() {
        public void onClick(View btn)
        {
            if (helloYes) {
                helloYes = false;
                helloTextView.setText("Goodbye");
            }
            else {
                helloYes = true;
                helloTextView.setText("Hello");
            }
        }
    };






}
