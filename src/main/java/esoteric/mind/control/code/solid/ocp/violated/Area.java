package esoteric.mind.control.code.solid.ocp.violated;

import com.google.gson.Gson;

import java.util.List;

public class Area {
    //!OCP violated, modifying for each requirement (shape)

    //!SRP (conformed?), reason for change: calculate area
    public static double calculate(List<Object> shapes) {
        double sum = 0;

        for (Object shape : shapes) {
            // Case 1: Square shape
            if (shape instanceof Square square) {
                //Square square = ((Square) shape);
                if ( square.getLength() != 0)
                    sum += Math.pow(square.getLength(), 2);
                if ( square.getDiagonal() != 0)
                    sum += Math.pow(square.getDiagonal(), 2) / 2;
            }
            // Case 2: Rectangle shape (OCP violated)
            if (shape instanceof Rectangle rectangle)
                sum += Math.pow(rectangle.getLength() * rectangle.getWidth(), 2);
            //!OCP violated, modified for (each) additional request (e.g. triangle)
            if (shape instanceof Triangle triangle) {
                // SSS / Heron's formula
                if ( triangle.getA() != 0 && triangle.getB() != 0 && triangle.getC() != 0 ) {
                    sum += Math.sqrt( ((triangle.getA() + triangle.getB() + triangle.getC())/2)
                            * ( (triangle.getA() + triangle.getB() + triangle.getC())/2 -triangle.getA() )
                            * ( (triangle.getA() + triangle.getB() + triangle.getC())/2 -triangle.getB() )
                            * ( (triangle.getA() + triangle.getB() + triangle.getC())/2 -triangle.getC() ) );
                }
                // SAS
                if ( triangle.getA() != 0 && triangle.getB() != 0 && triangle.getGamma() != 0 ) {
                    sum += 0.5 * triangle.getA() * triangle.getB() * Math.sin( Math.toRadians(triangle.getGamma()) );
                }
                // ASA / AAS
                if ( triangle.getA() != 0 && triangle.getBeta() != 0 && triangle.getGamma() != 0 ) {
                    sum += Math.pow(triangle.getA(),2) /2
                         * Math.sin( Math.toRadians(triangle.getBeta()) )
                         * Math.sin( Math.toRadians(triangle.getGamma()) )
                         / Math.sin( Math.toRadians(triangle.getBeta()) + Math.toRadians(triangle.getGamma()) );
                }
                sum = Math.round(sum*100.0)/100.0;
            }
        }

        return sum;
    }

    //!SRP violated, 2nd reason for change
    public static String asJson(int sum) {
        String area = "{area: " + sum + "}";
        return new Gson().toJson(area);
    }
    public static String asXML(int sum) {
        return "<area>%d<\\area>".formatted(sum);
    }
}
