package esoteric.mind.control.code.solid.ocp;

import esoteric.mind.control.code.solid.ocp.complies.Shapable;
import esoteric.mind.control.code.solid.ocp.complies.Rectangle;
import esoteric.mind.control.code.solid.ocp.complies.Square;
import esoteric.mind.control.code.solid.ocp.complies.Triangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Simplified, unimportant
public class Client {

    //Simplified since it is not important
    public static void main(String[] args) {
        System.out.println("==> OCP");

        //Playing around with complex structures
        Map<Integer, List<Map<String, Map<String, Integer>>>> params = new HashMap<Integer, List<Map<String, Map<String, Integer>>>>();
        // Case 6: rectangle + triangle area
        params.put(6, new ArrayList<Map<String, Map<String, Integer>>>() {{
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); put("width", 8); }}); }} );
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 4); put("b", 4); put("gamma", 40); }}); }} );  }});
        // Case 5: square + triangle area
        params.put(5, new ArrayList<Map<String, Map<String, Integer>>>() {{
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); }}); }} );
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 2); put("b", 8); put("gamma", 28); }}); }} );  }});
        // Case 4: 2 triangles area
        params.put(4, new ArrayList<Map<String, Map<String, Integer>>>() {{
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 8); put("b", 8); put("c", 8); }}); }} );
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Triangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("a", 2); put("beta", 4); put("gamma", 60); }}); }} );  }});
        // Case 3: square + rectangle area
        params.put(3, new ArrayList<Map<String, Map<String, Integer>>>() {{
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("diagonal", 4); }}); }} );
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); put("width", 8); }}); }} );  }});
        // Case 2: 2 rectangles area
        params.put(2, new ArrayList<Map<String, Map<String, Integer>>>() {{
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 2); put("width", 4); }}); }} );
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Rectangle.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); put("width", 8); }}); }} );  }});
        // Case 1: 2 squares area
        params.put(1, new ArrayList<Map<String, Map<String, Integer>>>() {{
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 2); }}); }} );
            add( new HashMap<String, Map<String, Integer>>()
                {{ put(Square.class.getSimpleName(), new HashMap<String, Integer>() {{ put("length", 4); }}); }} );  }});

        double area = 0;
        //!OCP violated (DRY for readability)
        List<Object> objects = new ArrayList<Object>();
        // Case 6: rectangle + triangle area
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(6).get(0).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(6).get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(6).get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(6).get(1).get(Triangle.class.getSimpleName()).get("b") )
                                            .setGamma( params.get(6).get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        area = getObjectsArea(objects);
        System.out.println("Area: " + area);
        objects.clear();
        // Case 5: square + triangle area
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setLength( params.get(5).get(0).get(Square.class.getSimpleName()).get("length") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(5).get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(5).get(1).get(Triangle.class.getSimpleName()).get("b") )
                                            .setGamma( params.get(5).get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        area = getObjectsArea(objects);
        System.out.println("Area: " + area);
        objects.clear();
        // Case 4: 2 triangles area
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(4).get(0).get(Triangle.class.getSimpleName()).get("a") )
                                            .setB( params.get(4).get(0).get(Triangle.class.getSimpleName()).get("b") )
                                            .setC( params.get(4).get(0).get(Triangle.class.getSimpleName()).get("c") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Triangle().setA( params.get(4).get(1).get(Triangle.class.getSimpleName()).get("a") )
                                            .setBeta( params.get(4).get(1).get(Triangle.class.getSimpleName()).get("beta") )
                                            .setGamma( params.get(4).get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        area = getObjectsArea(objects);
        System.out.println("Area: " + area);
        objects.clear();
        // Case 3: square + rectangle area
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setDiagonal( params.get(3).get(0).get(Square.class.getSimpleName()).get("diagonal") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(3).get(1).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(3).get(1).get(Rectangle.class.getSimpleName()).get("width")) );
        area = getObjectsArea(objects);
        System.out.println("Area: " + area);
        objects.clear();
        // Case 2: 2 rectangles area
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(2).get(0).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(2).get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Rectangle( params.get(2).get(1).get(Rectangle.class.getSimpleName()).get("length"),
                                             params.get(2).get(1).get(Rectangle.class.getSimpleName()).get("width")) );
        area = getObjectsArea(objects);
        System.out.println("Area: " + area);
        objects.clear();
        // Case 1: 2 squares area
        objects = new ArrayList<Object>();
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setLength( params.get(1).get(0).get(Square.class.getSimpleName()).get("length") ));
        objects.add((Object) new esoteric.mind.control.code.solid.ocp.violated.Square().setLength( params.get(1).get(1).get(Square.class.getSimpleName()).get("length") ));
        area = getObjectsArea(objects);
        System.out.println("Area: " + area);
        objects.clear();

        //!OCP complied (DRY for readability)
        List<Shapable> shapes = new ArrayList<Shapable>();
        // Case 6: rectangle + triangle area
        shapes.add((Shapable) new Rectangle( params.get(6).get(0).get(Rectangle.class.getSimpleName()).get("length"),
                params.get(6).get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        shapes.add((Shapable) new Triangle().setA( params.get(6).get(1).get(Triangle.class.getSimpleName()).get("a") )
                .setB( params.get(6).get(1).get(Triangle.class.getSimpleName()).get("b") )
                .setGamma( params.get(6).get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        area = getShapesArea(shapes);
        System.out.println("Area: " + area);
        shapes.clear();
        // Case 5: square + triangle area
        shapes.add((Shapable) new Square().setLength( params.get(5).get(0).get(Square.class.getSimpleName()).get("length") ));
        shapes.add((Shapable) new Triangle().setA( params.get(5).get(1).get(Triangle.class.getSimpleName()).get("a") )
                .setB( params.get(5).get(1).get(Triangle.class.getSimpleName()).get("b") )
                .setGamma( params.get(5).get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        area = getShapesArea(shapes);
        System.out.println("Area: " + area);
        shapes.clear();
        // Case 4: 2 triangles area
        shapes.add((Shapable) new Triangle().setA( params.get(4).get(0).get(Triangle.class.getSimpleName()).get("a") )
                .setB( params.get(4).get(0).get(Triangle.class.getSimpleName()).get("b") )
                .setC( params.get(4).get(0).get(Triangle.class.getSimpleName()).get("c") ));
        shapes.add((Shapable) new Triangle().setA( params.get(4).get(1).get(Triangle.class.getSimpleName()).get("a") )
                .setBeta( params.get(4).get(1).get(Triangle.class.getSimpleName()).get("beta") )
                .setGamma( params.get(4).get(1).get(Triangle.class.getSimpleName()).get("gamma") ));
        area = getShapesArea(shapes);
        System.out.println("Area: " + area);
        shapes.clear();
        // Case 3: square + rectangle area
        shapes.add((Shapable) new Square().setDiagonal( params.get(3).get(0).get(Square.class.getSimpleName()).get("diagonal") ));
        shapes.add((Shapable) new Rectangle( params.get(3).get(1).get(Rectangle.class.getSimpleName()).get("length"),
                params.get(3).get(1).get(Rectangle.class.getSimpleName()).get("width")) );
        area = getShapesArea(shapes);
        System.out.println("Area: " + area);
        shapes.clear();
        // Case 2: 2 rectangles area
        shapes.add((Shapable) new Rectangle( params.get(2).get(0).get(Rectangle.class.getSimpleName()).get("length"),
                params.get(2).get(0).get(Rectangle.class.getSimpleName()).get("width")) );
        shapes.add((Shapable) new Rectangle( params.get(2).get(1).get(Rectangle.class.getSimpleName()).get("length"),
                params.get(2).get(1).get(Rectangle.class.getSimpleName()).get("width")) );
        area = getShapesArea(shapes);
        System.out.println("Area: " + area);
        shapes.clear();
        // Case 1: 2 squares area
        shapes.add((Shapable) new Square().setLength( params.get(1).get(0).get(Square.class.getSimpleName()).get("length") ));
        shapes.add((Shapable) new Square().setLength( params.get(1).get(1).get(Square.class.getSimpleName()).get("length") ));
        area = getShapesArea(shapes);
        System.out.println("Area: " + area);
        shapes.clear();
    }


    //!OCP violated (DRY for readability)
    private static double getObjectsArea(List<Object> shapes) {
        //Simplified since not important, DRY for readability
        for (Object shape : shapes)
            // Area of computing objects
            System.out.println( shape.getClass().getSimpleName() + ": " +
                    esoteric.mind.control.code.solid.ocp.violated.Area.calculate(new ArrayList<Object>() {{ add(shape); }} ) );
        // Area of compiled space
        return esoteric.mind.control.code.solid.ocp.violated.Area.calculate(shapes);
    }
    //!OCP complied (DRY for readability)
    private static double getShapesArea(List<Shapable> shapes) {
        //Simplified since not important, DRY for readability
        for (Shapable shape : shapes)
            // Area of computing objects
            System.out.println( shape.getClass().getSimpleName() + ": " +
                            esoteric.mind.control.code.solid.ocp.complies.Area.calculate( new ArrayList<Shapable>() {{ add(shape); }} ) );
        // Area of compiled space
        return esoteric.mind.control.code.solid.ocp.complies.Area.calculate(shapes);
        //List<Object> objects = new ArrayList<Object>(shapes);
    }
}
