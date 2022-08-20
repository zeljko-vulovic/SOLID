package esoteric.mind.control.code.solid.lsp.complies;

//Implements logic
public class Area {
    //Helper, reduces DRY

    static double calculateSSS(double a, double b, double c) {
        // SSS / Heron's formula
        double area = Math.sqrt( ((a + b + c)/2) * ( (a + b + c)/2 -a ) * ( (a + b + c)/2 -b ) * ( (a + b + c)/2 -c ) );
        return Math.round(area*100.0)/100.0;
    }

    static double calculateSAS(double a, double b, double gamma) {
        // SAS
        double area = 0.5 * a * b * Math.sin( Math.toRadians(gamma) );
        return Math.round(area*100.0)/100.0;
    }

    static double calculateASA(double a, double beta, double gamma) {
        // ASA / AAS
        double area = Math.pow(a,2) /2 * Math.sin( Math.toRadians(beta) ) * Math.sin( Math.toRadians(gamma) ) / Math.sin( Math.toRadians(beta) + Math.toRadians(gamma) );
        return Math.round(area*100.0)/100.0;
    }
}
