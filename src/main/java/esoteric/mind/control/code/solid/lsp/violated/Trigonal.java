package esoteric.mind.control.code.solid.lsp.violated;

//Enfolds properties for all triangle types
// Triangle(s) -> Triangle -> Trigonal
public abstract class Trigonal implements Shapable {
    //!LSP violated with sssArea(), sasArea(), asaArea()

    private double a;
    private double b;
    private double c;
    private double beta;
    private double gamma;

    double getA() {
        return a;
    }
    public Trigonal setA(double a) {
        isTriangle();
        this.a = a;
        return this;
    }
    double getB() {
        return b;
    }
    public Trigonal setB(double b) {
        isTriangle();
        this.b = b;
        return this;
    }
    double getC() {
        return c;
    }
    public Trigonal setC(double c) {
        isTriangle();
        this.c = c;
        return this;
    }
    double getBeta() {
        return beta;
    }
    public Trigonal setBeta(double beta) {
        this.beta = beta;
        return this;
    }
    double getGamma() {
        return gamma;
    }
    public Trigonal setGamma(double gamma) {
        this.gamma = gamma;
        return this;
    }

    @Override
    public String toString() {
        return "[a="+getA()+", b="+getB()+", c="+getC()+", beta="+getBeta()+", gamma="+getGamma()+"]";
    }

    private void isTriangle() {
        if( ( getA() != 0 && getB() != 0 && getC() != 0 ) &&
                ( (getA()+getB())<=getC() || (getA()+getC())<=getB() || (getB()+getC())<=getA() ) )
            throw new IllegalStateException("Not a Triangle when one side is bigger than the other two combined!");
    }

    public double sssArea() {
        // SSS / Heron's formula
        if ( getA() != 0 && getB() != 0 && getC() != 0 ) {
            double area = Math.sqrt(
                    ((getA() + getB() + getC())/2) *
                    ( (getA() + getB() + getC())/2 -getA() ) *
                    ( (getA() + getB() + getC())/2 -getB() ) *
                    ( (getA() + getB() + getC())/2 -getC() ) );
            return Math.round(area*100.0)/100.0;
        }
        throw new IllegalCallerException("//!LSP violated since Side-Side-Side Postulate needs Side-Side-Side properties of Triangle!");
    }

    public double sasArea() {
        // SAS
        if ( getA() != 0 && getB() != 0 && getGamma() != 0 ) {
            double area = 0.5 * getA() * getB() * Math.sin( Math.toRadians(getGamma()) );
            return Math.round(area*100.0)/100.0;
        }
        throw new IllegalCallerException("//!LSP violated since Side-Angle-Side Postulate needs Side-Angle-Side properties of Triangle!");
    }

    public double asaArea() {
        // ASA / AAS
        if ( getA() != 0 && getBeta() != 0 && getGamma() != 0 ) {
            double area = Math.pow(getA(),2) /2 * Math.sin( Math.toRadians(getBeta()) ) * Math.sin( Math.toRadians(getGamma()) )
                        / Math.sin( Math.toRadians(getBeta()) + Math.toRadians(getGamma()) );
            return Math.round(area*100.0)/100.0;
        }
        throw new IllegalCallerException("//!LSP violated since Angle-Side-Angle Postulate needs Angle-Side-Angle properties of Triangle!");
    }
}
