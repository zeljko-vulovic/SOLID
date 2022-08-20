package esoteric.mind.control.code.solid.dip.complies;

public class SASCalculator implements AreaCalculator {

    @Override
    public double area(double a, double b, double gamma) {
        // SAS
        return 0.5 * a * b * Math.sin( Math.toRadians(gamma) );
    }
    //Arbitrarily naming sides and angle
}
