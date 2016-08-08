package com.example.firstapplication.simpleintegrals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_a;
    EditText et_b;
    EditText et_n;
    double a = 0;
    double b = 0;
    int n = 0;
    static double res_byAntiderivative = 0;
    static double res_byMiddleRectangles = 0;
    static double res_byTrapeziums = 0;
    static double res_bySimpson = 0;
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
    ImageView iv_f1;
    ImageView iv_f2;
    ProgressBar progressBar;

    Integrals I;

    final int EMPTY_FIELDS = -1;
    final int EMPTY_FIELD = -2;
    final int EMPTY_CHOOSEN = -3;


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
        iv_f1 = (ImageView)findViewById(R.id.iv_f1);
        iv_f2 = (ImageView)findViewById(R.id.iv_f2);
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
        iv_f1.setOnClickListener(this);
        iv_f2.setOnClickListener(this);

        I = new Integrals();
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
            case R.id.iv_f1:
                f1_choose = true;
                f2_choose = false;
                rbFunction1.setChecked(true);
                rbFunction2.setChecked(false);
                break;

            case R.id.rbFunction2:
            case R.id.iv_f2:
                f1_choose = false;
                f2_choose = true;
                rbFunction1.setChecked(false);
                rbFunction2.setChecked(true);
                break;

            case R.id.chb_1_byMiddleRectangles:
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
                break;

            case R.id.btn_Calculate:
                if(isDataEmpty() == EMPTY_FIELDS) {
                    Toast.makeText(this, "Поля пусты", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(isDataEmpty() == EMPTY_FIELD) {
                    Toast.makeText(this, "Одно или несколько полей пусты", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(isDataEmpty() == EMPTY_CHOOSEN) {
                    Toast.makeText(this, "Не выбран ни один из методов расчёта", Toast.LENGTH_SHORT).show();
                    break;
                }
                a = Double.parseDouble(et_a.getText().toString());
                b = Double.parseDouble(et_b.getText().toString());
                n = Integer.parseInt(et_n.getText().toString());
                Calculate(a, b, n);
                break;

        }
    }


    /**
     * Проверка на пустоту полей
     * @return EMPTY_FIELDS = -1 - все поля пустые
     * EMPTY_FIELD = -2 - одно или несколько полей пустые
     * EMPTY_CHOOSEN = -3 - не выбран ни один из методов расчёта
     */
    public int isDataEmpty() {
        if(et_a.getText().length() == 0 && et_b.getText().length() == 0 && et_n.getText().length() == 0)
            return EMPTY_FIELDS;
        if(et_a.getText().length() == 0 || et_b.getText().length() == 0 || et_n.getText().length() == 0)
            return EMPTY_FIELD;
        if(method_1_choose == false && method_2_choose == false && method_3_choose == false)
            return EMPTY_CHOOSEN;
        return 0;
    }


    /**
     * Рассчёт интегралов
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @param n кол-во разбиений
     */
    private void Calculate(double a, double b, int n) {
        I.ChooseFunction(f1_choose);
        I.setLimits(a, b, n);
        I.Calculate(a, b, n);
        tv_resbyAntiderivative.setText(String.valueOf(res_byAntiderivative));
        tv_resbyMiddleRectangles.setText(String.valueOf(res_byMiddleRectangles));
        tv_resbyTrapeziums.setText(String.valueOf(res_byTrapeziums));
        tv_resbySimpson.setText(String.valueOf(res_bySimpson));
    }

}
