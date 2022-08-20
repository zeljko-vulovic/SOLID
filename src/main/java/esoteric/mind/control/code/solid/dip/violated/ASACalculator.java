package esoteric.mind.control.code.solid.dip.violated;

public class ASACalculator {

    double area(double a, double beta, double gamma) {
        // ASA / AAS
        return Math.pow(a,2) /2 * Math.sin( Math.toRadians(beta) ) * Math.sin( Math.toRadians(gamma) ) / Math.sin( Math.toRadians(beta) + Math.toRadians(gamma) );
    }
    //Arbitrarily naming side and angles
}
