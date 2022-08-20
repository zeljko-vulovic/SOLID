package esoteric.mind.control.code;

import esoteric.mind.control.code.solid.ocp.complies.Rectangle;
import esoteric.mind.control.code.solid.ocp.complies.Shapable;
import esoteric.mind.control.code.solid.ocp.complies.Square;
import esoteric.mind.control.code.solid.ocp.complies.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Simplified, unimportant
public class OCPTest {

    @Test
    @DisplayName("Test Squares")
    void TestSquares() {
        //Simplified since not important, DRY for readability
        List<Map<String, Map<String, Integer>>> params = new ArrayList<Map<String, Map<String, Integer>>>();
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 2); }}); }} );
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); }}); }} );
        //!OCP complied (DRY for readability)
        List<Shapable> shapes = new ArrayList<Shapable>();
        shapes.add((Shapable) new Square().setLength( params.get(0).get(Square.class.getSimpleName()).get("length") ));
        shapes.add((Shapable) new Square().setLength( params.get(1).get(Square.class.getSimpleName()).get("length") ));
        //!OCP broken (DRY for readability)
        List<Object> objects = new ArrayList<Object>();
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setLength( params.get(0).get(Square.class.getSimpleName()).get("length") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setLength( params.get(1).get(Square.class.getSimpleName()).get("length") ));

        // Case 1: 2 squares area
        List<Double> expected = new ArrayList<Double>() {{ add(4.0); add(16.0); }};
        for (int iterator=0; iterator<expected.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.violated.Area.calculate(new ArrayList<Object>() {{ add(objects.get(i)); }} ));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.complies.Area.calculate(new ArrayList<Shapable>() {{ add(shapes.get(i)); }} ));
        }
        // Area of compiled space
        double sum = esoteric.mind.control.code.solid.ocp.violated.Area.calculate(objects);
        double area = esoteric.mind.control.code.solid.ocp.complies.Area.calculate(shapes);
        assertEquals(20.0, sum );
        assertEquals(20.0, area );
    }

    @Test
    @DisplayName("Test Rectangles")
    void TestRectangles() {
        //Simplified since not important, DRY for readability
        List<Map<String, Map<String, Integer>>> params = new ArrayList<Map<String, Map<String, Integer>>>();
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 2); put("width", 4); }}); }} );
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); put("width", 8); }}); }} );
        //!OCP complied (DRY for readability)
        List<Shapable> shapes = new ArrayList<Shapable>();
        shapes.add((Shapable) new Rectangle( params.get(0).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        shapes.add((Shapable) new Rectangle( params.get(1).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(1).get(Rectangle.class.getSimpleName()).get("width")) );
        //!OCP broken (DRY for readability)
        List<Object> objects = new ArrayList<Object>();
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(0).get(Rectangle.class.getSimpleName()).get("length"),
                                            params.get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(1).get(Rectangle.class.getSimpleName()).get("length"),
                                            params.get(1).get(Rectangle.class.getSimpleName()).get("width")) );

        // Case 2: 2 rectangles area
        List<Double> expected = new ArrayList<Double>() {{ add(64.0); add(1024.0); }};
        for (int iterator=0; iterator<expected.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.violated.Area.calculate(new ArrayList<Object>() {{ add(objects.get(i)); }} ));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.complies.Area.calculate(new ArrayList<Shapable>() {{ add(shapes.get(i)); }} ));
        }
        // Area of compiled space
        double sum = esoteric.mind.control.code.solid.ocp.violated.Area.calculate(objects);
        double area = esoteric.mind.control.code.solid.ocp.complies.Area.calculate(shapes);
        assertEquals(1088.0, sum );
        assertEquals(1088.0, area );
    }

    @Test
    @DisplayName("Test SquaREctangles")
    void TestSquaRectangles() {
        //Simplified since not important, DRY for readability
        List<Map<String, Map<String, Integer>>> params = new ArrayList<Map<String, Map<String, Integer>>>();
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("diagonal", 4); }}); }} );
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); put("width", 8); }}); }} );
        //!OCP complied (DRY for readability)
        List<Shapable> shapes = new ArrayList<Shapable>();
        shapes.add((Shapable) new Square().setDiagonal( params.get(0).get(Square.class.getSimpleName()).get("diagonal") ));
        shapes.add((Shapable) new Rectangle( params.get(1).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(1).get(Rectangle.class.getSimpleName()).get("width")) );
        //!OCP broken (DRY for readability)
        List<Object> objects = new ArrayList<Object>();
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setDiagonal( params.get(0).get(Square.class.getSimpleName()).get("diagonal") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(1).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(1).get(Rectangle.class.getSimpleName()).get("width")) );

        // Case 3: square + rectangle area
        List<Double> expected = new ArrayList<Double>() {{ add(8.0); add(1024.0); }};
        for (int iterator=0; iterator<expected.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.violated.Area.calculate(new ArrayList<Object>() {{ add(objects.get(i)); }} ));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.complies.Area.calculate(new ArrayList<Shapable>() {{ add(shapes.get(i)); }} ));
        }
        // Area of compiled space
        double sum = esoteric.mind.control.code.solid.ocp.violated.Area.calculate(objects);
        double area = esoteric.mind.control.code.solid.ocp.complies.Area.calculate(shapes);
        assertEquals(1032.0, sum );
        assertEquals(1032.0, area );
    }

    @Test
    @DisplayName("Test Triangles")
    void TestTriangles() {
        //Simplified since not important, DRY for readability
        List<Map<String, Map<String, Integer>>> params = new ArrayList<Map<String, Map<String, Integer>>>();
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 8); put("b", 8); put("c", 8); }}); }} );
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 2); put("beta", 4); put("gamma", 60); }}); }} );
        //!OCP complied (DRY for readability)
        List<Shapable> shapes = new ArrayList<Shapable>();
        shapes.add((Shapable) new Triangle().setA( params.get(0).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(0).get(Triangle.class.getSimpleName()).get("b") )
                                            .setC( params.get(0).get(Triangle.class.getSimpleName()).get("c") ));
        shapes.add((Shapable) new Triangle().setA( params.get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setBeta( params.get(1).get(Triangle.class.getSimpleName()).get("beta") )
                                            .setGamma( params.get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        //!OCP broken (DRY for readability)
        List<Object> objects = new ArrayList<Object>();
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(0).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(0).get(Triangle.class.getSimpleName()).get("b") )
                                            .setC( params.get(0).get(Triangle.class.getSimpleName()).get("c") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setBeta( params.get(1).get(Triangle.class.getSimpleName()).get("beta") )
                                            .setGamma( params.get(1).get(Triangle.class.getSimpleName()).get("gamma") ));

        // Case 4: 2 triangles area
        List<Double> expected = new ArrayList<Double>() {{ add(27.71); add(0.13); }};
        for (int iterator=0; iterator<expected.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.violated.Area.calculate(new ArrayList<Object>() {{ add(objects.get(i)); }} ));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.complies.Area.calculate(new ArrayList<Shapable>() {{ add(shapes.get(i)); }} ));
        }
        // Area of compiled space
        double sum = esoteric.mind.control.code.solid.ocp.violated.Area.calculate(objects);
        double area = esoteric.mind.control.code.solid.ocp.complies.Area.calculate(shapes);
        assertEquals(27.84, sum );
        assertEquals(27.84, area );
    }

    @Test
    @DisplayName("Test Trianglon")
    void TestTrianglon() {
        //Simplified since not important, DRY for readability
        List<Map<String, Map<String, Integer>>> params = new ArrayList<Map<String, Map<String, Integer>>>();
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); }}); }} );
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 2); put("b", 8); put("gamma", 28); }}); }} );
        //!OCP complied (DRY for readability)
        List<Shapable> shapes = new ArrayList<Shapable>();
        shapes.add((Shapable) new Square().setLength( params.get(0).get(Square.class.getSimpleName()).get("length") ));
        shapes.add((Shapable) new Triangle().setA( params.get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(1).get(Triangle.class.getSimpleName()).get("b") )
                                            .setGamma( params.get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        //!OCP broken (DRY for readability)
        List<Object> objects = new ArrayList<Object>();
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setLength( params.get(0).get(Square.class.getSimpleName()).get("length") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(1).get(Triangle.class.getSimpleName()).get("b") )
                                            .setGamma( params.get(1).get(Triangle.class.getSimpleName()).get("gamma") ));

        // Case 5: square + triangle area
        List<Double> expected = new ArrayList<Double>() {{ add(16.0); add(3.76); }};
        for (int iterator=0; iterator<expected.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.violated.Area.calculate(new ArrayList<Object>() {{ add(objects.get(i)); }} ));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.complies.Area.calculate(new ArrayList<Shapable>() {{ add(shapes.get(i)); }} ));
        }
        // Area of compiled space
        double sum = esoteric.mind.control.code.solid.ocp.violated.Area.calculate(objects);
        double area = esoteric.mind.control.code.solid.ocp.complies.Area.calculate(shapes);
        assertEquals(19.76, sum );
        assertEquals(19.76, area );
    }

    @Test
    @DisplayName("Test Pentagon")
    void TestPentagon() {
        //Simplified since not important, DRY for readability
        List<Map<String, Map<String, Integer>>> params = new ArrayList<Map<String, Map<String, Integer>>>();
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); put("width", 8); }}); }} );
        params.add( new HashMap<String, Map<String, Integer>>()
            {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 4); put("b", 4); put("gamma", 40); }});}} );
        //!OCP complied (DRY for readability)
        List<Shapable> shapes = new ArrayList<Shapable>();
        shapes.add((Shapable) new Rectangle( params.get(0).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        shapes.add((Shapable) new Triangle().setA( params.get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(1).get(Triangle.class.getSimpleName()).get("b") )
                                            .setGamma( params.get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        //!OCP broken (DRY for readability)
        List<Object> objects = new ArrayList<Object>();
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(0).get(Rectangle.class.getSimpleName()).get("length"),
                                            params.get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(1).get(Triangle.class.getSimpleName()).get("b") )
                                            .setGamma( params.get(1).get(Triangle.class.getSimpleName()).get("gamma") ));

        // Case 6: rectangle + triangle area
        List<Double> expected = new ArrayList<Double>() {{ add(1024.0); add(5.14); }};
        for (int iterator=0; iterator<expected.size(); iterator++) {
            int i = iterator;
            // Area of computing objects
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.violated.Area.calculate(new ArrayList<Object>() {{ add(objects.get(i)); }} ));
            assertEquals(expected.get(i), esoteric.mind.control.code.solid.ocp.complies.Area.calculate(new ArrayList<Shapable>() {{ add(shapes.get(i)); }} ));
        }
        // Area of compiled space
        double sum = esoteric.mind.control.code.solid.ocp.violated.Area.calculate(objects);
        double area = esoteric.mind.control.code.solid.ocp.complies.Area.calculate(shapes);
        assertEquals(1029.14, sum );
        assertEquals(1029.14, area );
    }
}
