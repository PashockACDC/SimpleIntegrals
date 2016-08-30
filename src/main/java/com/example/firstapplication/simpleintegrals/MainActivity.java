package com.example.firstapplication.simpleintegrals;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Date;

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
    TextView tvTrace;
    RelativeLayout rlMethod1;
    RelativeLayout rlMethod2;
    RelativeLayout rlMethod3;
    RelativeLayout rl_ContainsprogressBar;
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

    static Integrals I;

    final int ERROR_EMPTY_FIELDS = -1;
    final int ERROR_EMPTY_FIELD = -2;
    final int ERROR_EMPTY_CHOOSEN = -3;


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
        rlMethod1 = (RelativeLayout)findViewById(R.id.rlMethod1);
        rlMethod2 = (RelativeLayout)findViewById(R.id.rlMethod2);
        rlMethod3 = (RelativeLayout)findViewById(R.id.rlMethod3);
        tvTrace = (TextView)findViewById(R.id.tvTrace);
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
        rl_ContainsprogressBar = (RelativeLayout)findViewById(R.id.rl_ContainsprogressBar);

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
                if(chb_1_byMiddleRectangle.isChecked())
                    method_1_choose = true;
                else
                    method_1_choose = false;
                break;

            case R.id.chb_2_byTrapeziums:
                if(chb_2_byTrapeziums.isChecked())
                    method_2_choose = true;
                else
                    method_2_choose = false;
                break;

            case R.id.chb_3_bySimpson:
                if(chb_3_bySimpson.isChecked())
                    method_3_choose = true;
                else
                    method_3_choose = false;
                break;

            case R.id.btn_Calculate:
                if(isDataEmpty() == ERROR_EMPTY_FIELDS) {
                    Toast.makeText(this, "Поля пусты", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(isDataEmpty() == ERROR_EMPTY_FIELD) {
                    Toast.makeText(this, "Одно или несколько полей пусты", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(isDataEmpty() == ERROR_EMPTY_CHOOSEN) {
                    Toast.makeText(this, "Не выбран ни один из методов расчёта", Toast.LENGTH_SHORT).show();
                    break;
                }
                rl_ContainsprogressBar.setVisibility(View.VISIBLE);
                try {
                    a = Double.parseDouble(et_a.getText().toString());
                    b = Double.parseDouble(et_b.getText().toString());
                    n = Integer.parseInt(et_n.getText().toString());
                }
                catch (NumberFormatException e) {
                    Toast.makeText(this, "Неверный формат одного из чисел!", Toast.LENGTH_SHORT).show();
                    return;
                }
                catch (Exception e) {
                    Toast.makeText(this, "Ошибка ввода!", Toast.LENGTH_SHORT).show();
                    return;
                }
                finally {
                    if (n == 0) {
                        Toast.makeText(this, "Нулевое количество разбиений не имеет смысла!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    rl_ContainsprogressBar.setVisibility(View.GONE);
                }
                Calculate(a, b, n);
                break;

        }
    }


    /**
     * Проверка на пустоту полей
     * @return ERROR_EMPTY_FIELDS = -1 - все поля пустые
     * ERROR_EMPTY_FIELD = -2 - одно или несколько полей пустые
     * ERROR_EMPTY_CHOOSEN = -3 - не выбран ни один из методов расчёта
     */
    public int isDataEmpty() {
        if(et_a.getText().length() == 0 && et_b.getText().length() == 0 && et_n.getText().length() == 0)
            return ERROR_EMPTY_FIELDS;
        if(et_a.getText().length() == 0 || et_b.getText().length() == 0 || et_n.getText().length() == 0)
            return ERROR_EMPTY_FIELD;
        if(!method_1_choose && !method_2_choose && !method_3_choose)
            return ERROR_EMPTY_CHOOSEN;
        return 0;
    }


    /**
     * Рассчёт интегралов
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @param n кол-во разбиений
     */
    private void Calculate(double a, double b, int n) {
        I = new Integrals();
        I.ChooseFunction(f1_choose);
        I.setLimits(a, b, n);
        I.setChoosenMethods(method_1_choose, method_2_choose, method_3_choose);
        try {
            MyTask mt = new MyTask();
            mt.execute();
            tvTrace.setVisibility(View.GONE);
        }
        catch (Exception e) {
            Toast.makeText(this, "Расчёт прерван!", Toast.LENGTH_LONG).show();
            tvTrace.setVisibility(View.VISIBLE);
            tvTrace.setText(e.toString());
        }
    }


    public void showCalculatingTime(Long millis) {
        String time_calc;
        DecimalFormat sec_format = new DecimalFormat("###.###");
        if((millis / 1000.) >= 60.) {
            int min = (int)((millis / 1000.) / 60);
            long seconds = ((millis / 1000L) - min * 60);
            time_calc = "Время расчёта: " + min + " мин. " + sec_format.format(seconds) + " c";
        }
        else {
            time_calc = "Время расчёта: " + sec_format.format(millis / 1000.) + " c";
        }
        Toast.makeText(this, time_calc, Toast.LENGTH_LONG).show();
    }








    class MyTask extends AsyncTask<Void, Integer, Void> {

        long time_Calc = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            rl_ContainsprogressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected Void doInBackground(Void... params) {
            try {
                long time_begin = System.currentTimeMillis();
                I.Calculate_by_antiderivative(a, b);
                publishProgress(1);
                if(method_1_choose)
                    I.Calculate_by_middle_rectangle(a, b, n);
                publishProgress(30);
                if(method_2_choose)
                    I.Calculate_by_trapezium(a, b, n);
                publishProgress(60);
                if(method_3_choose)
                    I.Calculate_by_parabolas(a, b, n);
                publishProgress(90);
                long time_end = System.currentTimeMillis();
                time_Calc = time_end - time_begin;
            }
            catch (Exception e) {

            }

            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void param) {
            super.onPostExecute(param);
            tv_resbyAntiderivative.setText(String.valueOf(res_byAntiderivative));
            if(method_1_choose) {
                rlMethod1.setVisibility(View.VISIBLE);
                tv_resbyMiddleRectangles.setText(String.valueOf(res_byMiddleRectangles));
            } else {
                rlMethod1.setVisibility(View.GONE);
            }
            if(method_2_choose) {
                rlMethod2.setVisibility(View.VISIBLE);
                tv_resbyTrapeziums.setText(String.valueOf(res_byTrapeziums));
            } else {
                rlMethod2.setVisibility(View.GONE);
            }
            if(method_3_choose) {
                rlMethod3.setVisibility(View.VISIBLE);
                tv_resbySimpson.setText(String.valueOf(res_bySimpson));
            } else {
                rlMethod3.setVisibility(View.GONE);
            }
            showCalculatingTime(time_Calc);
            rl_ContainsprogressBar.setVisibility(View.GONE);
        }
    }




}