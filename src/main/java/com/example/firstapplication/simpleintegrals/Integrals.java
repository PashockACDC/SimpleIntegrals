package com.example.firstapplication.simpleintegrals;



/**
 * Created by PashockACDC
 */
public class Integrals {

    double a;
    double b;
    int n;
//    double res_byAntiderivative;
//    double res_byMiddleRectangles;
//    double res_byTrapeziums;
//    double res_bySimpson;
    boolean f1_choose;
    boolean f2_choose;
    boolean res1_calculated;
    boolean res2_calculated;
    boolean res3_calculated;


    public Integrals() {
        double a = 0;
        double b = 0;
        int n = 0;
        boolean f1_choose = true;
        boolean f2_choose = false;
        boolean res1_calculated = false;
        boolean res2_calculated = false;
        boolean res3_calculated = false;
    }


//    public Integrals(double aa, double bb, int n) {
//        //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    }


    /**
     * Устанавливаем значения
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @param n кол-во разбиений
     */
    public void setLimits(double a, double b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }


    /**
     * функция 1
     * @param x
     * @return
     */
    public static double f1(double x) {
        return x * x * x;
    }

    /**
     * фукнция 2
     * @param x
     * @return
     */
    public static double f2(double x) {
        return 1 / (1 + x*x);
    }

    /**
     * первообразная функции 1
     * @param x
     * @return
     */
    public static double f1_antiderivative(double x) {
        return x * x * x * x / 4;
    }

    /**
     * первообразная функции 2
     * @param x
     * @return
     */
    public static double f2_antiderivative(double x) {
        return Math.atan(x);
    }


    /**
     * Рассчёт интегралов
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @param n кол-во разбиений
     */
    public void Calculate(double a, double b, int n) {
        MainActivity.res_byAntiderivative = Calculate_by_antiderivative(a, b);
        MainActivity.res_byMiddleRectangles = Calculate_by_middle_rectangle(a, b, n);
        MainActivity.res_bySimpson = Calculate_by_parabolas(a, b, n);
        MainActivity.res_byTrapeziums = Calculate_by_trapezium(a, b, n);
    }

    /**
     * точный расчёт по формуле Ньютона
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @return
     */
    private double Calculate_by_antiderivative(double a, double b) {
        double res;
        if(f1_choose) {
            res = f1_antiderivative(b) - f1_antiderivative(a);
            return res;
        }
        if(f2_choose) {
            res = f2_antiderivative(b) - f2_antiderivative(a);
            return res;
        }
        return 0;
    }

    /**
     * Выбор функции для расчёта
     * @param f1_choose если f1_choose == true, то считаем по 1-ой
     *                  если f2_choose == false, то считаем по 2-ой
     */
    public void ChooseFunction(boolean f1_choose) {
        if(f1_choose) {
            this.f1_choose = true;
            this.f2_choose = false;
        }
        else {
            this.f1_choose = false;
            this.f2_choose = true;
        }
    }


    /**
     * вычисление интеграла методом средних прямоугольников
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @param n кол-во разбиений
     * @return
     */
    private double Calculate_by_middle_rectangle(double a, double b, int n) {
        double dx;
        double x;
        double sum = 0;
        double res;
        dx = (b - a) / n;
        a = a + dx / 2;
        for (int i = 0; i < n; i++)
        {
            x = a + i * dx;
            if (f1_choose)
                sum += f1(x);
            else
                sum += f2(x);
        }
        res = dx * sum;
        return res;
    }


    /**
     * вычисление интеграла методом парабол (метод Симпсона)
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @param n кол-во разбиений
     * @return
     */
    private double Calculate_by_parabolas(double a, double b, int n) {
        double res;
        double h = (b - a) / n;  //шаг разбиения
        int i;
        if (f1_choose) {
            res = f1(a);
            res += f1(a + n * h);
        }
        else {
            res = f2(a);
            res += f2(a + n * h);
        }

        for (i = 1; i <= n - 1; i++) {
            if (i % 2 != 0) {
                if (f1_choose) {
                    res += 4 * f1(a + i * h);
                }
                else {
                    res += 4 * f2(a + i * h);
                }
            }
            else {
                if (f1_choose) {
                    res += 2 * f1(a + i * h);
                }
                else {
                    res += 2 * f2(a + i * h);
                }
            }
        }
        return h / 3 * res;
    }


    /**
     * вычисление интеграла методом трапеций
     * @param a нижний предел интегрирования
     * @param b верхний предел интегрирования
     * @param n кол-во разбиений
     * @return
     */
    private double Calculate_by_trapezium(double a, double b, int n) {
        double res;
        double h = (b - a) / n;  //шаг разбиения
        if (f1_choose)
            res = f1(a) / 2 * (a + 1*h - a);
        else
            res = f2(a) / 2 * (a + 1*h - a);
        int i;
        for (i=1; i <= n-1; i++)
        {
            if (f1_choose)
                res += f1(a + i*h) * (a + (i+1)*h - (a + (i-1)*h)) / 2;
            else
                res += f2(a + i*h) * (a + (i+1)*h - (a + (i-1)*h)) / 2;
        }
        if (f1_choose)
            res += f1(b) * (b - (a + (i-1)*h));
        else
            res += f2(b) * (b - (a + (i-1)*h));
        return res;
    }
}