package esoteric.mind.control.code.solid.isp;

import java.util.function.Supplier;

//Simplified, irrelevant
public class Client {

    //Simplified since it is not important
    public static void main(String[] args) {
        System.out.println("==> ISP");

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        //!ISP violated
        // Case 1: Using same value for each side of the triangle
        Triangles violates = Triangles.setViolations( new esoteric.mind.control.code.solid.isp.violated.Triangle().setA(a).setB(a).setC(a) );
        Triangles triangle = Triangles.setViolations( new esoteric.mind.control.code.solid.isp.violated.EquilateralTriangle().setSides(a) );
        System.out.printf("Area for the triangle is %s.%n", getArea(violates));
        System.out.printf("Area for the triangle is %s.%n", getArea(triangle));
        //Expected: true, LSP violated for tested entities
        boolean violated = isViolated(violates, triangle);

        // Case 2: Utilizing all features imposed by the interface
        esoteric.mind.control.code.solid.isp.violated.RegularTetrahedron tetrahedron
                = new esoteric.mind.control.code.solid.isp.violated.RegularTetrahedron().setEdge(a);
        System.out.printf("Area for the tetrahedron of type %s is %s.%n", tetrahedron.getClass().getSimpleName(), tetrahedron.area());
        System.out.printf("Volume for the tetrahedron of type %s is %s.%n", tetrahedron.getClass().getSimpleName(), tetrahedron.volume());

        //!ISP conformed
        // Case 3: Using same value for each side of the triangle
        Triangles conforms = Triangles.setConformations( new esoteric.mind.control.code.solid.isp.complies.Triangle().setA(a).setB(a).setC(a) );
        Triangles eqlTriangle = Triangles.setConformations( new esoteric.mind.control.code.solid.isp.complies.EquilateralTriangle().setSides(a) );
        System.out.printf("Area for the triangle is %s.%n", getArea(conforms));
        System.out.printf("Area for the triangle is %s.%n", getArea(eqlTriangle));
        //Expected: false, LSP complies for tested entities
        boolean incompliant = isViolated(conforms, eqlTriangle);

        // Case 4: Utilizing all features imposed by the interface
        esoteric.mind.control.code.solid.isp.complies.RegularTetrahedron regularTetrahedron
                = new esoteric.mind.control.code.solid.isp.complies.RegularTetrahedron().setEdge(a);
        System.out.printf("Area for the tetrahedron of type %s is %s.%n", regularTetrahedron.getClass().getSimpleName(), regularTetrahedron.area());
        System.out.printf("Volume for the tetrahedron of type %s is %s.%n", regularTetrahedron.getClass().getSimpleName(), regularTetrahedron.volume());

        if (!violated) {
            System.out.printf("Interface Segregation Principle conformed for %s.*%n", tetrahedron.getClass().getPackageName());
        }
        if (!incompliant) {
            System.out.printf("Interface Segregation Principle conformed for %s.*%n", regularTetrahedron.getClass().getPackageName());
        }
        //!ISP violated
        if (violated || incompliant) {
            throw new IllegalStateException("//!ISP violation of segregation can cause a system to be polluted with a significant amount of unused mechanisms");
        }
        System.out.println("Interface Segregation Principle conformed!");
    }

    //!ISP segregation can be verified by comparing the results returned from the same methods' invocation for generals and related specifics
    private static boolean isViolated(Triangles general, Triangles specific)  {
        boolean violated = false;

        if (general.getViolations() != null && specific.getViolations() != null) {
            //!ISP violated, unused mechanisms are impairing the process execution
            try {
                //Expected: //!ISP violated since volume is not calculable for 2D shape!
                ( (Supplier<Double>) () -> general.getViolations().volume()).get();
                ( (Supplier<Double>) () -> specific.getViolations().volume()).get();
                //( (Supplier<Double>) () -> { return specific.getViolations().volume(); } ).get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                violated = true;
            }
        }

        return violated;
    }
    //Playing around with lambda expressions
    private static double getArea(Triangles triangle) {
        return ((Supplier<Double>) () -> {
            if(triangle.getConformations() != null)
                return triangle.getConformations().area();
            return triangle.getViolations().area();
        }).get();
    }
}
