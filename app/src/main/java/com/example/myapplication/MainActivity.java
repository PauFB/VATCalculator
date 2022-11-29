package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView priceEditText;
    public static TextView vatEditText;
    private TextView totalEditText;
    private Button selectVATButton;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceEditText = findViewById(R.id.price_editText);
        vatEditText = findViewById(R.id.vat_editText);
        totalEditText = findViewById(R.id.total_editText);
        selectVATButton = findViewById(R.id.select_vat_button);
        selectVATButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VATSelectionActivity.class);
                startActivity(intent);
            }
        });
        calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] str = vatEditText.getText().toString().split(" - ");
                String percentageStr = str[1].substring(0, str[1].length() - 1).replace(",", ".");
                Double percentage = Double.parseDouble(percentageStr);
                Double resultat = Double.valueOf(priceEditText.getText().toString())
                        + (Double.valueOf(priceEditText.getText().toString()) * percentage) / 100;
                totalEditText.setText(resultat.toString());
            }
        });

    }
}
