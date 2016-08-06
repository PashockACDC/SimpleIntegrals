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


    public Integrals(double aa, double bb, int n) {
        //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
     * первообразная функции 1
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
        //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

}