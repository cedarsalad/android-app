package com.example.chads.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class TipCalculatorActivity extends AppCompatActivity {

    EditText txtBill;
    EditText txtGst;
    EditText txtPst;
    EditText txtTip;
    EditText txtPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        txtBill = (EditText) findViewById(R.id.editText);
        txtGst = (EditText) findViewById(R.id.editText2);
        txtPst = (EditText) findViewById(R.id.editText3);
        txtTip = (EditText) findViewById(R.id.editText4);
        txtPerson = (EditText) findViewById(R.id.editText5);

        txtGst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button btnBack = findViewById(R.id.btn_back3);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TipCalculatorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnCalculate = (Button) findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make sure first that no text box is empty
                if (TextUtils.isEmpty(txtBill.getText()) ||
                        TextUtils.isEmpty(txtGst.getText()) ||
                        TextUtils.isEmpty(txtGst.getText())||
                        TextUtils.isEmpty(txtTip.getText())||
                        TextUtils.isEmpty(txtPerson.getText())){
                    Toast.makeText(TipCalculatorActivity.this, "Please fill out all fields!", Toast.LENGTH_LONG).show();
                } else {
                    //Calculation
                    //get numbers from text boxes
                    double bill = Double.parseDouble(txtBill.getText().toString());
                    double gst = Double.parseDouble(txtGst.getText().toString());
                    double pst = Double.parseDouble(txtPst.getText().toString());
                    double tip = Double.parseDouble(txtTip.getText().toString());
                    double person = Double.parseDouble(txtPerson.getText().toString());

                    //check that the values are not negative
                    if (bill < 0){
                        Toast.makeText(TipCalculatorActivity.this, "Enter a valid bill amount.", Toast.LENGTH_LONG).show();
                    } else if (gst < 0 || pst < 0){
                        Toast.makeText(TipCalculatorActivity.this, "Negative taxes? If only!", Toast.LENGTH_LONG).show();
                    } else if (tip < 0) {
                        Toast.makeText(TipCalculatorActivity.this, "I don't think you understand how tipping works...", Toast.LENGTH_LONG).show();
                    } else if (person < 0) {
                        Toast.makeText(TipCalculatorActivity.this, "One of you bastards killed my wife. And somebody's gotta pay.", Toast.LENGTH_LONG).show();
                    } else {
                        //agree on the fluent ratios
                        if (tip > 1) {
                            tip /= 100;
                        }
                        if (gst > 1) {
                            gst /= 100;
                        }
                        if (pst > 1) {
                            pst /= 100;
                        }
                        //get both totals
                        double total = bill + (bill*gst) + (bill*pst) + (bill*tip);
                        double totalPer = total/person;
                        //convert to proper format for display
                        DecimalFormat df = new DecimalFormat("#.##");

                        //display totals
                        TextView tipPer = (TextView) findViewById(R.id.txt_ind_tip);
                        tipPer.setText("Tip:  $" + df.format(totalPer) +"/per");

                        TextView tipTotal = (TextView) findViewById(R.id.txt_total_tip);
                        tipTotal.setText("Total:  $" + df.format(total));

                        Toast.makeText(TipCalculatorActivity.this, "Alakazam!", Toast.LENGTH_SHORT).show();
                    }






                }

            }
        });

    }

    private Boolean numberValidator(String n){

//        if(android.text.TextUtils.isDigitsOnly())
//        int num = Integer.parseInt(n);
        return false;
    }

    private class NumbersOnlyTextWatcher implements TextWatcher {

        private EditText text;

        public NumbersOnlyTextWatcher(EditText t) {
            text = t;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

}
