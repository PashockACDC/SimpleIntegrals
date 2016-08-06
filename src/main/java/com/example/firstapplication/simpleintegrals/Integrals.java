package com.example.firstapplication.simpleintegrals;



/**
 * Created by PashockACDC
 */
public class Integrals {

    double a;
    double b;
    int n;
    double res_byAntiderivative;
    double res_byMiddleRectangles;
    double res_byTrapeziums;
    double res_bySimpson;
    boolean f1_choose;
    boolean f2_choose;
    boolean res1_calculated;
    boolean res2_calculated;
    boolean res3_calculated;

    public Integrals() {
        double a = 0;
        double b = 0;
        int n = 0;
        double res_byAntiderivative = 0;
        double res_byMiddleRectangles = 0;
        double res_byTrapeziums = 0;
        double res_bySimpson = 0;
        boolean f1_choose = true;
        boolean f2_choose = false;
        boolean res1_calculated = false;
        boolean res2_calculated = false;
        boolean res3_calculated = false;
        MainActivity mainActivity = new MainActivity();
    }

    public Integrals(double aa, double bb, int n) {
        //TODO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

}
