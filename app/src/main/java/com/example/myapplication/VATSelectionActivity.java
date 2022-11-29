package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class VATSelectionActivity extends AppCompatActivity {

    private RadioButton selectedVatRadioButton;
    private RadioGroup vatRadioGroup;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vat_selection);
        vatRadioGroup = findViewById(R.id.vatRadioGroup);
        okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = vatRadioGroup.getCheckedRadioButtonId();
                selectedVatRadioButton = findViewById(selectedRadioButtonId);
                MainActivity.vatEditText.setText(selectedVatRadioButton.getText());
                finish();
            }
        });
    }
}
