package com.example.chads.lab1;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ColorSwitcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_switcher);

        final RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        final RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
        final ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.layout_color_switcher);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String rg1Value = null;
                String rg2Value = null;
                if (rg1.getCheckedRadioButtonId() != -1)
                    rg1Value = ((RadioButton)findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
                if (rg2.getCheckedRadioButtonId() != -1)
                    rg2Value = ((RadioButton)findViewById(rg2.getCheckedRadioButtonId())).getText().toString();

                switch (rg1Value){
                    case "Red":
                        if (rg2Value == null || rg2Value.equals("Red"))
                            mainLayout.setBackgroundColor(Color.RED);
                        else if (rg2Value.equals("Yellow"))
                            mainLayout.setBackgroundColor(Color.rgb(255,165,0));
                        else if (rg2Value.equals("Blue"))
                            mainLayout.setBackgroundColor(Color.rgb(128,0,128));
                        break;
                    case "Yellow":
                        if (rg2Value == null || rg2Value.equals("Yellow"))
                            mainLayout.setBackgroundColor(Color.YELLOW);
                        else if (rg2Value.equals("Red"))
                            mainLayout.setBackgroundColor(Color.rgb(255,165,0));
                        else if (rg2Value.equals("Blue"))
                            mainLayout.setBackgroundColor(Color.GREEN);
                        break;
                    case "Blue":
                        if (rg2Value == null || rg2Value.equals("Blue"))
                            mainLayout.setBackgroundColor(Color.BLUE);
                        else if (rg2Value.equals("Red"))
                            mainLayout.setBackgroundColor(Color.rgb(128,0,128));
                        else if (rg2Value.equals("Yellow"))
                            mainLayout.setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String rg1Value = null;
                String rg2Value = null;
                if (rg1.getCheckedRadioButtonId() != -1)
                    rg1Value = ((RadioButton)findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
                if (rg2.getCheckedRadioButtonId() != -1)
                    rg2Value = ((RadioButton)findViewById(rg2.getCheckedRadioButtonId())).getText().toString();

                switch (rg2Value){
                    case "Red":
                        if (rg1Value == null || rg1Value.equals("Red"))
                            mainLayout.setBackgroundColor(Color.RED);
                        else if (rg1Value.equals("Yellow"))
                            mainLayout.setBackgroundColor(Color.rgb(255,165,0));
                        else if (rg1Value.equals("Blue"))
                            mainLayout.setBackgroundColor(Color.rgb(128,0,128));
                        break;
                    case "Yellow":
                        if (rg1Value == null || rg1Value.equals("Yellow"))
                            mainLayout.setBackgroundColor(Color.YELLOW);
                        else if (rg1Value.equals("Red"))
                            mainLayout.setBackgroundColor(Color.rgb(255,165,0));
                        else if (rg1Value.equals("Blue"))
                            mainLayout.setBackgroundColor(Color.GREEN);
                        break;
                    case "Blue":
                        if (rg1Value == null || rg1Value.equals("Blue"))
                            mainLayout.setBackgroundColor(Color.BLUE);
                        else if (rg1Value.equals("Red"))
                            mainLayout.setBackgroundColor(Color.rgb(128,0,128));
                        else if (rg1Value.equals("Yellow"))
                            mainLayout.setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        });

        Button btnBack = findViewById(R.id.btn_back2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ColorSwitcherActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
