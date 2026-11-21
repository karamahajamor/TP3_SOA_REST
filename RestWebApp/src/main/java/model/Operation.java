package model;

public class Operation {

    private double a;
    private double b;
    private String op;
    private double res;

    public Operation() {
    }

    public Operation(double a, double b, String op, double res) {
        this.a = a;
        this.b = b;
        this.op = op;
        this.res = res;
    }

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public String getOp() { return op; }
    public void setOp(String op) { this.op = op; }

    public double getRes() { return res; }
    public void setRes(double res) { this.res = res; }
}