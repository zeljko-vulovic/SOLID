package esoteric.mind.control.code;

import esoteric.mind.control.code.solid.isp.Triangles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class ISPTest {

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.isp.violated.EquilateralTriangle")
    void TestEquilateralTriangleViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        // Case 1: Using same value for each side of the triangle
        Triangles violates = Triangles.setViolations( new esoteric.mind.control.code.solid.isp.violated.Triangle().setA(a).setB(a).setC(a) );
        Triangles triangle = Triangles.setViolations( new esoteric.mind.control.code.solid.isp.violated.EquilateralTriangle().setSides(a) );

        double triangleArea = getArea(violates);
        double eqlTriangleArea = getArea(triangle);
        System.out.printf("Area for the triangle is %s.%n", triangleArea);
        System.out.printf("Area for the triangle is %s.%n", eqlTriangleArea);

        //Expected: true, LSP violated for tested entities
        boolean violated = isViolated(violates, triangle);
        assertTrue(violated);

        assertEquals(6.93, triangleArea);
        assertEquals(6.93, eqlTriangleArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.isp.violated.RegularTetrahedron")
    void TestRegularTetrahedronViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        // Case 2: Utilizing all features imposed by the interface
        esoteric.mind.control.code.solid.isp.violated.RegularTetrahedron tetrahedron
                = new esoteric.mind.control.code.solid.isp.violated.RegularTetrahedron().setEdge(a);
        System.out.printf("Area for the tetrahedron of type %s is %s.%n", tetrahedron.getClass().getSimpleName(), tetrahedron.area());
        System.out.printf("Volume for the tetrahedron of type %s is %s.%n", tetrahedron.getClass().getSimpleName(), tetrahedron.volume());

        assertEquals(27.71, tetrahedron.area() );
        assertEquals(7.54, tetrahedron.volume() );
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.isp.complies.EquilateralTriangle")
    void TestEquilateralTriangleConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        // Case 3: Using same value for each side of the triangle
        Triangles conforms = Triangles.setConformations( new esoteric.mind.control.code.solid.isp.complies.Triangle().setA(a).setB(a).setC(a) );
        Triangles triangle = Triangles.setConformations( new esoteric.mind.control.code.solid.isp.complies.EquilateralTriangle().setSides(a) );

        double triangleArea = getArea(conforms);
        double eqlTriangleArea = getArea(triangle);
        System.out.printf("Area for the triangle is %s.%n", triangleArea);
        System.out.printf("Area for the triangle is %s.%n", eqlTriangleArea);

        //Expected: false, LSP complies for tested entities
        boolean incompliant = isViolated(conforms, triangle);
        assertFalse(incompliant);

        assertEquals(6.93, triangleArea);
        assertEquals(6.93, eqlTriangleArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.isp.violated.RegularTetrahedron")
    void TestRegularTetrahedronConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        // Case 4: Utilizing all features imposed by the interface
        esoteric.mind.control.code.solid.isp.complies.RegularTetrahedron tetrahedron
                = new esoteric.mind.control.code.solid.isp.complies.RegularTetrahedron().setEdge(a);
        System.out.printf("Area for the tetrahedron of type %s is %s.%n", tetrahedron.getClass().getSimpleName(), tetrahedron.area());
        System.out.printf("Volume for the tetrahedron of type %s is %s.%n", tetrahedron.getClass().getSimpleName(), tetrahedron.volume());

        assertEquals(27.71, tetrahedron.area() );
        assertEquals(7.54, tetrahedron.volume() );
    }

    //!ISP segregation can be verified by comparing the results returned from the same methods' invocation for generals and related specifics
    private boolean isViolated(Triangles general, Triangles specific)  {
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
    private double getArea(Triangles triangle) {
        return ((Supplier<Double>) () -> {
            if(triangle.getConformations() != null)
                return triangle.getConformations().area();
            return triangle.getViolations().area();
        }).get();
    }
}
