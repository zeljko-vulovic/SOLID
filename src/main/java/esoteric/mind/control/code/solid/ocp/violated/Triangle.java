package esoteric.mind.control.code.solid.ocp.violated;

public class Triangle {

	private double a;
	private double b;
	private double c;
	private double beta;
	private double gamma;

	public double getA() {
		return a;
	}
	public Triangle setA(double a) {
		isTriangle();
		this.a = a;
		return this;
	}
	public double getB() {
		return b;
	}
	public Triangle setB(double b) {
		isTriangle();
		this.b = b;
		return this;
	}
	public double getC() {
		return c;
	}
	public Triangle setC(double c) {
		isTriangle();
		this.c = c;
		return this;
	}
	public double getBeta() {
		return beta;
	}
	public Triangle setBeta(double beta) {
		this.beta = beta;
		return this;
	}
	public double getGamma() {
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
}

