package esoteric.mind.control.code.solid.lsp.violated.substitutability;

//Since the behavior of the area calculation depends on the types it uses, those types are not substitutable.
public class ScaleneTriangle {

    private double a;
    private double b;
    private double c;

    public ScaleneTriangle(double a, double b, double c) {
        if( (a+b)<=c || (a+c)<=b || (b+c)<=a )
            throw new IllegalStateException("Not a Triangle when one side is bigger than the other two combined!");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }

    //!OCP, implemented for req
    public double area() {
        // SSS / Heron's formula
        double area = Math.sqrt(
                ((getA() + getB() + getC())/2) *
                ( (getA() + getB() + getC())/2 -getA() ) *
                ( (getA() + getB() + getC())/2 -getB() ) *
                ( (getA() + getB() + getC())/2 -getC() ) );
        return Math.round(area*100.0)/100.0;
    }
}
