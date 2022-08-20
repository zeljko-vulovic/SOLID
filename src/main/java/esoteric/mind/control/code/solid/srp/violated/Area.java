package esoteric.mind.control.code.solid.srp.violated;

import com.google.gson.Gson;
import esoteric.mind.control.code.solid.srp.entities.Rectangle;
import esoteric.mind.control.code.solid.srp.entities.Square;

import java.util.List;

//!SRP violated
public class Area {

    //!SRP, 1 reason for change: calculate area
    public static int calculate(List<Object> shapes) {
        int sum = 0;

        for (Object shape : shapes) {
            if (shape instanceof Square square) {
                //Square square = ((Square) shape);
                if( square.getLength() != 0 )
                    sum += Math.pow(square.getLength(), 2);
                if( square.getDiagonal() != 0 )
                    sum += Math.pow(square.getDiagonal(), 2) / 2;
            }
            if (shape instanceof Rectangle rectangle)
                sum += Math.pow(rectangle.getLength() * rectangle.getWidth(), 2);
        }

        return sum;
    }
    //!OCP violated (and conformed in esoteric.mind.control.code.solid.ocp.*)

    //!SRP violated, 2nd reason for change
    public static String asJson(int sum) {
        String area = "{\"area\": " + sum + "}";
        return new Gson().toJson(area);
    }
    public static String asXML(int sum) {
        return "<area>%d<\\area>".formatted(sum);
    }
}
