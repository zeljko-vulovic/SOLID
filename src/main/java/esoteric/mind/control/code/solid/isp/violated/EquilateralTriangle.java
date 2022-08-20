package esoteric.mind.control.code.solid.isp.violated;

// Triangle(s) -> Triangle -> Shapable
public class EquilateralTriangle extends Triangle {

    public Triangle setSides(double side) {
        super.setA(side);
        super.setB(side);
        super.setC(side);
        return this;
    }

    @Override
    //NOTE: Uses only SSS
    public double area() {
        return super.area();
    }
}