package esoteric.mind.control.code.solid.srp;

import esoteric.mind.control.code.solid.srp.entities.Rectangle;
import esoteric.mind.control.code.solid.srp.entities.Square;

import java.util.ArrayList;
import java.util.List;

//Simplified, unimportant
public class Client {

    //Simplified since it is not important
    public static void main(String[] args) {
        System.out.println("==> SRP");

        // Case 1: 2 squares area
        List<Object> shapes = new ArrayList<Object>();
        shapes.add(new Square().setLength(2));
        shapes.add(new Square().setLength(4));
        getArea(shapes);

        // Case 2: 2 rectangles area
        shapes = new ArrayList<Object>();
        shapes.add(new Rectangle(2, 4));
        shapes.add(new Rectangle(4, 8));
        getArea(shapes);

        // Case 3: square + rectangle area
        shapes = new ArrayList<Object>();
        shapes.add(new Square().setDiagonal(4));
        shapes.add(new Rectangle(4, 8));
        getArea(shapes);
    }

    //Simplified since not important, DRY for readability
    private static void getArea(List<Object> shapes) {
        //!SRP violated (DRY for readability)
        for (Object shape : shapes) {
            // Area of computing objects
            System.out.println( shape.getClass().getSimpleName() + ": "
                            + esoteric.mind.control.code.solid.srp.violated.Area.calculate(new ArrayList<Object>() {{ add(shape); }}) );
        }
        // Area of compiled space
        int sum = esoteric.mind.control.code.solid.srp.violated.Area.calculate(shapes);
        System.out.println("Area: " + sum);
        //!SRP violated, 2 actors use same class
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.violated.Area.asJson(sum));
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.violated.Area.asXML(sum));

        //!SRP complied (DRY for readability)
        for (Object shape : shapes) {
            // Area of computing objects
            System.out.println( shape.getClass().getSimpleName() + ": "
                            + esoteric.mind.control.code.solid.srp.complies.Area.calculate(new ArrayList<Object>() {{ add(shape); }}) );
        }
        // Area of compiled space
        sum = esoteric.mind.control.code.solid.srp.complies.Area.calculate(shapes);
        System.out.println("Area: " + sum);
        //!SRP conformed, Actor 2 is separated
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.complies.Report.asJson(sum));
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.complies.Report.asXML(sum));
    }
}
