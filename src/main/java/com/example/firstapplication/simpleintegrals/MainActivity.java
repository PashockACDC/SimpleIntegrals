package com.example.firstapplication.simpleintegrals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_a;
    EditText et_b;
    EditText et_n;
    double a = 0;
    double b = 0;
    int n = 0;
    double res_byAntiderivative;
    double res_byMiddleRectangles;
    double res_byTrapeziums;
    double res_bySimpson;
    boolean f1_choose = true;
    boolean f2_choose = false;
    boolean res1_calculated = false;
    boolean res2_calculated = false;
    boolean res3_calculated = false;
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
    boolean method_1_choose = false;
    boolean method_2_choose = false;
    boolean method_3_choose = false;
    RadioButton rbFunction1;
    RadioButton rbFunction2;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_a = (EditText)findViewById(R.id.et_a);
        et_b = (EditText)findViewById(R.id.et_b);
        et_n = (EditText)findViewById(R.id.et_n);
        tv_resbyAntiderivative = (TextView)findViewById(R.id.tv_resbyAntiderivative);
        tv_resbyMiddleRectangles = (TextView)findViewById(R.id.tv_resbyMiddleRectangles);
        tv_resbyTrapeziums = (TextView)findViewById(R.id.tv_resbyTrapeziums);
        tv_resbySimpson = (TextView)findViewById(R.id.tv_resbySimpson);
        btn_Clear_a = (Button)findViewById(R.id.btnClear_a);
        btn_Clear_b = (Button)findViewById(R.id.btnClear_b);
        btn_Clear_n = (Button)findViewById(R.id.btnClear_n);
        btn_Calculate = (Button)findViewById(R.id.btn_Calculate);
        chb_1_byMiddleRectangle = (CheckBox)findViewById(R.id.chb_1_byMiddleRectangles);
        chb_2_byTrapeziums = (CheckBox)findViewById(R.id.chb_2_byTrapeziums);
        chb_3_bySimpson = (CheckBox)findViewById(R.id.chb_3_bySimpson);
        rbFunction1 = (RadioButton)findViewById(R.id.rbFunction1);
        rbFunction2 = (RadioButton)findViewById(R.id.rbFunction2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        et_a.setOnClickListener(this);
        et_b.setOnClickListener(this);
        et_n.setOnClickListener(this);
        tv_resbyAntiderivative.setOnClickListener(this);
        tv_resbyMiddleRectangles.setOnClickListener(this);
        tv_resbyTrapeziums.setOnClickListener(this);
        tv_resbySimpson.setOnClickListener(this);
        btn_Clear_a.setOnClickListener(this);
        btn_Clear_b.setOnClickListener(this);
        btn_Clear_n.setOnClickListener(this);
        btn_Calculate.setOnClickListener(this);
        chb_1_byMiddleRectangle.setOnClickListener(this);
        chb_2_byTrapeziums.setOnClickListener(this);
        chb_3_bySimpson.setOnClickListener(this);
        rbFunction1.setOnClickListener(this);
        rbFunction2.setOnClickListener(this);
    }




    /**
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnClear_a:
                et_a.setText("");
                break;

            case R.id.btnClear_b:
                et_b.setText("");
                break;

            case R.id.btnClear_n:
                et_n.setText("");
                break;

            case R.id.rbFunction1:
                f1_choose = true;
                f2_choose = false;
                rbFunction1.setChecked(true);
                rbFunction2.setChecked(false);
                break;

            case R.id.rbFunction2:
                f1_choose = false;
                f2_choose = true;
                rbFunction1.setChecked(false);
                rbFunction2.setChecked(true);
                break;

            /*case R.id.chb_1_byMiddleRectangles:
                if(chb_1_byMiddleRectangle.isChecked() == true)
                    method_1_choose = true;
                else
                    method_1_choose = false;
                break;

            case R.id.chb_2_byTrapeziums:
                if(chb_2_byTrapeziums.isChecked() == true)
                    method_2_choose = true;
                else
                    method_2_choose = false;
                break;

            case R.id.chb_3_bySimpson:
                if(chb_3_bySimpson.isChecked() == true)
                    method_3_choose = true;
                else
                    method_3_choose = false;
                break;*/

            case R.id.btn_Calculate:

                break;

        }
    }



}
