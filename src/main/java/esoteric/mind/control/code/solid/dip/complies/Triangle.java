package esoteric.mind.control.code.solid.dip.complies;

import esoteric.mind.control.code.solid.dip.violated.SSSCalculator;

//!DIP conformed with area()
public class Triangle {

    private double a;
    private double b;
    private double c;
    private double beta;
    private double gamma;

    double getA() {
        return a;
    }
    public Triangle setA(double a) {
        isTriangle();
        this.a = a;
        return this;
    }
    double getB() {
        return b;
    }
    public Triangle setB(double b) {
        isTriangle();
        this.b = b;
        return this;
    }
    double getC() {
        return c;
    }
    public Triangle setC(double c) {
        isTriangle();
        this.c = c;
        return this;
    }
    double getBeta() {
        return beta;
    }
    public Triangle setBeta(double beta) {
        this.beta = beta;
        return this;
    }
    double getGamma() {
        return gamma;
    }
    public Triangle setGamma(double gamma) {
        this.gamma = gamma;
        return this;
    }

    private void isTriangle() {
        if( ( getA() != 0 && getB() != 0 && getC() != 0 ) &&
                ( (getA()+getB())<=getC() || (getA()+getC())<=getB() || (getB()+getC())<=getA() ) )
            throw new IllegalStateException("Not a Triangle when one side is bigger than the other two combined!");
    }

    //!DIP conformed, depending on abstractions
    public double area(AreaCalculator calculator) {
        //NOTE: Implementer in charged for compatibility
        if ( getA() != 0 && getB() != 0 && getC() != 0 )
            return Math.round((calculator.area(getA(), getB(), getC())) * 100.0) / 100.0;
        if ( getA() != 0 && getB() != 0 && getGamma() != 0 )
            return Math.round( (calculator.area(getA(), getB(), getGamma())) *100.0)/100.0;
        if ( getA() != 0 && getBeta() != 0 && getGamma() != 0 )
            return Math.round( (calculator.area(getA(), getBeta(), getGamma())) *100.0)/100.0;

        throw new IllegalStateException("Area not calculable by calculation type with incompatible inputs!");
    }
}