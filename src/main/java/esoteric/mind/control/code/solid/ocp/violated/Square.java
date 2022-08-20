package esoteric.mind.control.code.solid.ocp.violated;

public class Square {

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
}

