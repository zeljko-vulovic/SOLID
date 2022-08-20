package esoteric.mind.control.code.solid.dip.violated;

public class SSSCalculator {

    double area(double a, double b, double c) {
        // SSS / Heron's formula
        return Math.sqrt( ((a + b + c)/2) * ( (a + b + c)/2 -a ) * ( (a + b + c)/2 -b ) * ( (a + b + c)/2 -c ) );
    }
}
