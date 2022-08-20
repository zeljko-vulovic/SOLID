package esoteric.mind.control.code.solid.lsp.complies;

//Enfolds properties for all triangle types
// Triangle(s) -> Triangle -> Trigonal
public abstract class Trigonal {
    //!LSP NOT violated with isSSS(), isSAS(), isASA()

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
        if( ( isSet(getA()) && isSet(getB()) && isSet(getC()) ) &&
                ( (getA()+getB())<=getC() || (getA()+getC())<=getB() || (getB()+getC())<=getA() ) )
            throw new IllegalStateException("Not a Triangle when one side is bigger than the other two combined!");
    }

    boolean isSet(double val) {
        return val != 0;
    }

    public boolean isSSS() {
        return isSet(getA()) && isSet(getB()) && isSet(getC());
    }

    public boolean isSAS() {
        return isSet(getA()) && isSet(getB()) && isSet(getGamma());
    }

    public boolean isASA() {
        return isSet(getA()) && isSet(getBeta()) && isSet(getGamma());
    }
}
