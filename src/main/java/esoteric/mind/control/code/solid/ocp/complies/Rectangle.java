package esoteric.mind.control.code.solid.ocp.complies;

//!OCP conformed with area() method
public class Rectangle implements Shapable {

    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    @Override
    //!OCP, implemented for req
    public double area() {
        return Math.pow(getLength() * getWidth(), 2);
    }
}
