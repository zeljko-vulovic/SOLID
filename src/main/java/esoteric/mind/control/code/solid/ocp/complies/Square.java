package esoteric.mind.control.code.solid.ocp.complies;

//!OCP conformed with area() method
public class Square implements Shapable {
	//!SRP (conformed), 1 reason for change: calculate area

    private double length;
    private double diagonal;

	public double getLength() {
		return length;
	}
	public Square setLength(double length) {
		this.length = length;
		return this;
	}
	public double getDiagonal() {
		return diagonal;
	}
	public Square setDiagonal(double diagonal) {
		this.diagonal = diagonal;
		return this;
	}

	@Override
	//!OCP, implemented for req
	public double area() {
		if ( getLength() != 0 )
			return Math.pow(getLength(), 2);
		if ( getDiagonal() != 0 )
			return Math.pow(getDiagonal(), 2) / 2;
		return 0;
	}
}

