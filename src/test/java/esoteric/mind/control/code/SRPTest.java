package esoteric.mind.control.code;

import esoteric.mind.control.code.solid.srp.entities.Rectangle;
import esoteric.mind.control.code.solid.srp.entities.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Simplified, unimportant
public class SRPTest {

    private void log(int sum, int area) {
        System.out.println("==> SRP");
        // 2 actors use same class
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.violated.Area.asJson(sum));
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.violated.Area.asXML(sum));
        //!SRP, Actor 2 is separated
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.complies.Report.asJson(area));
        System.out.println("Area: " + esoteric.mind.control.code.solid.srp.complies.Report.asXML(area));
    }

    @Test
    @DisplayName("Test Squares")
    void TestSquares() {
        //Simplified since not important, DRY for readability

        List<Integer> expected = new ArrayList<Integer>() {{ add(4); add(16); }};
        // Case 1: 2 squares area
        List<Object> shapes = new ArrayList<Object>();
        shapes.add(new Square().setLength(2));
        shapes.add(new Square().setLength(4));

        for (int iterator=0; iterator<shapes.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.srp.violated.Area.calculate(new ArrayList<Object>() {{ add(shapes.get(i)); }}));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.srp.complies.Area.calculate(new ArrayList<Object>() {{ add(shapes.get(i)); }}));
        }
        // Area of compiled space
        int sum = esoteric.mind.control.code.solid.srp.violated.Area.calculate(shapes);
        int area = esoteric.mind.control.code.solid.srp.complies.Area.calculate(shapes);
        assertEquals(20, sum);
        assertEquals(20, area);

        log(sum, area);
    }

    @Test
    @DisplayName("Test Rectangles")
    void TestRectangles() {
        //Simplified since not important, DRY for readability

        List<Integer> expected = new ArrayList<Integer>() {{ add(64); add(1024); }};
        // Case 2: 2 rectangles area
        List<Object> shapes = new ArrayList<Object>();
        shapes.add(new Rectangle(2, 4));
        shapes.add(new Rectangle(4, 8));

        for (int iterator=0; iterator<shapes.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.srp.violated.Area.calculate(new ArrayList<Object>() {{ add(shapes.get(i)); }}));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.srp.complies.Area.calculate(new ArrayList<Object>() {{ add(shapes.get(i)); }}));
        }
        // Area of compiled space
        int sum = esoteric.mind.control.code.solid.srp.violated.Area.calculate(shapes);
        int area = esoteric.mind.control.code.solid.srp.complies.Area.calculate(shapes);
        assertEquals(1088, sum);
        assertEquals(1088, area);

        log(sum, area);
    }

    @Test
    @DisplayName("Test Area")
    void TestArea() {
        //Simplified since not important, DRY for readability

        List<Integer> expected = new ArrayList<Integer>() {{ add(8); add(1024); }};
        // Case 3: square + rectangle area
        List<Object> shapes = new ArrayList<Object>();
        shapes.add(new Square().setDiagonal(4));
        shapes.add(new Rectangle(4, 8));

        for (int iterator=0; iterator<shapes.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.srp.violated.Area.calculate(new ArrayList<Object>() {{ add(shapes.get(i)); }}));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.srp.complies.Area.calculate(new ArrayList<Object>() {{ add(shapes.get(i)); }}));
        }
        // Area of compiled space
        int sum = esoteric.mind.control.code.solid.srp.violated.Area.calculate(shapes);
        int area = esoteric.mind.control.code.solid.srp.complies.Area.calculate(shapes);
        assertEquals(1032, sum);
        assertEquals(1032, area);

        log(sum, area);
    }
}
