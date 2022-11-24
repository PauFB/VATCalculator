package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView priceEditText;
    private TextView vatEditText;
    private TextView totalEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceEditText = findViewById(R.id.price_editText);
        vatEditText = findViewById(R.id.vat_editText);
        totalEditText = findViewById(R.id.total_editText);
        calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double resultat = Double.valueOf(priceEditText.getText().toString())
                        + (Double.valueOf(priceEditText.getText().toString()) * Double.valueOf(vatEditText.getText().toString())) / 100;
                totalEditText.setText(resultat.toString());
            }
        });
    }
}
