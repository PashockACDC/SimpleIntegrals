package com.example.firstapplication.simpleintegrals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    TextView tv_a;
    TextView tv_b;
    TextView tv_n;
    TextView tv_resbyAntiderivative;
    TextView tv_resbyMiddleRectangles;
    TextView tv_resbyTrapeziums;
    TextView tv_resbySimpson;
    Button btn_Clear_a;
    Button btn_Clear_b;
    Button btn_Clear_n;
    Button btn_Calculate;
    CheckBox chb_1_byMiddleRectangle;
    CheckBox chb_2_byTrapeziums;
    CheckBox chb_3_bySimpson;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_a = (TextView)findViewById(R.id.tv_a);
        tv_b = (TextView)findViewById(R.id.tv_b);
        tv_n = (TextView)findViewById(R.id.tv_n);
        tv_resbyAntiderivative = (TextView)findViewById(R.id.tv_resbyAntiderivative);
        tv_resbyMiddleRectangles = (TextView)findViewById(R.id.tv_resbyMiddleRectangles);
        tv_resbyTrapeziums = (TextView)findViewById(R.id.tv_resbyTrapeziums);
        tv_resbySimpson = (TextView)findViewById(R.id.tv_resbySimpson);
        btn_Clear_a = (Button)findViewById(R.id.btnClear_a);
        btn_Clear_b = (Button)findViewById(R.id.btnClear_b);
        btn_Clear_n = (Button)findViewById(R.id.btnClear_n);
        btn_Calculate = (Button)findViewById(R.id.btn_Calculate);
        btn_Calculate = (Button)findViewById(R.id.btn_Calculate);
        chb_1_byMiddleRectangle = (CheckBox)findViewById(R.id.chb_1_byMiddleRectangles);
        chb_2_byTrapeziums = (CheckBox)findViewById(R.id.chb_2_byTrapeziums);
        chb_3_bySimpson = (CheckBox)findViewById(R.id.chb_3_bySimpson);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

    }


}
