package esoteric.mind.control.code.solid.isp.violated;

//Parent class for triangle types, alike LSP
// Triangle(s) -> Triangle -> Shapable
public class Triangle implements Shapable {
    //!ISP violated with volume() method

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

    @Override
    public double area() {
        double area;
        // SSS / Heron's formula
        if ( getA() != 0 && getB() != 0 && getC() != 0 ) {
            area = Math.sqrt( ((getA() + getB() + getC())/2) *
                    ( (getA() + getB() + getC())/2 -getA() ) *
                    ( (getA() + getB() + getC())/2 -getB() ) *
                    ( (getA() + getB() + getC())/2 -getC() ) );
            return Math.round(area*100.0)/100.0;
        }
        // SAS
        if ( getA() != 0 && getB() != 0 && getGamma() != 0 ) {
            area = 0.5 * getA() * getB() * Math.sin( Math.toRadians(getGamma()) );
            return Math.round(area*100.0)/100.0;
        }
        // ASA / AAS
        if ( getA() != 0 && getBeta() != 0 && getGamma() != 0 ) {
            area = Math.pow(getA(),2) /2 * Math.sin( Math.toRadians(getBeta()) ) * Math.sin( Math.toRadians(getGamma()) )
                   / Math.sin( Math.toRadians(getBeta()) + Math.toRadians(getGamma()) );
            return Math.round(area*100.0)/100.0;
        }

        throw new IllegalStateException("Area not calculable by calculation type with incompatible inputs!");
    }

    @Override
    public double volume() {
        throw new IllegalCallerException("//!ISP violated since volume is not calculable for 2D shape!");
    }
}