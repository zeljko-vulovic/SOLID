package esoteric.mind.control.code.solid.ocp.complies;

import java.util.List;

public class Area {
    //!OCP conformed, operations delegated to entities

    //!SRP conformed, 1 reason for change: calculate area
    public static double calculate(List<Shapable> shapes) {
        double sum = 0;
        for (Shapable shape : shapes) {
            //!OCP conformed, NOT modified for additional reqs
            sum += shape.area();
        }

        return Math.round(sum*100.0)/100.0;
    }
}
