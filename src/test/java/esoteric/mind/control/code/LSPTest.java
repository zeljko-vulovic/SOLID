package esoteric.mind.control.code;

import esoteric.mind.control.code.solid.lsp.Triangles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Simplified, unimportant
public class LSPTest {

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.violated.substitutability.EquilateralTriangle")
    void TestEquilateralTriangle() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        //Let calculating area be provable about objects x of type ScaleneTriangle.
        esoteric.mind.control.code.solid.lsp.violated.substitutability.ScaleneTriangle scaleneTriangle
                = new esoteric.mind.control.code.solid.lsp.violated.substitutability.ScaleneTriangle(a, b, c);
        //Then calculating area should be true for objects y of type EquilateralTriangle
        esoteric.mind.control.code.solid.lsp.violated.substitutability.ScaleneTriangle equilateralTriangle
                = new esoteric.mind.control.code.solid.lsp.violated.substitutability.EquilateralTriangle(a);

        boolean violated = false;
        //!LSP violated if the values do not match for given input
        if (scaleneTriangle.area() != equilateralTriangle.area()) {
            System.out.println("LSP violated for equilateral triangle.");
            System.out.println("Since the behavior of the area calculation depends on the triangles it uses, those types are not substitutable.");
            violated = true;
        }
        //Expected: true

        assertTrue(violated);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.violated.substitutability.IsoscelesTriangle")
    void TestIsoscelesTriangle() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        //Let calculating area be provable about objects x of type ScaleneTriangle.
        esoteric.mind.control.code.solid.lsp.violated.substitutability.ScaleneTriangle scaleneTriangle
                = new esoteric.mind.control.code.solid.lsp.violated.substitutability.ScaleneTriangle(a, b, c);
        //Then calculating area should be true for objects y of type IsoscelesTriangle
        esoteric.mind.control.code.solid.lsp.violated.substitutability.ScaleneTriangle isoscelesTriangle
                = new esoteric.mind.control.code.solid.lsp.violated.substitutability.IsoscelesTriangle(a, b);

        boolean violated = false;
        //!LSP violated if the values do not match for given input
        if (scaleneTriangle.area() != isoscelesTriangle.area()) {
            System.out.println("LSP violated for isosceles triangle.");
            System.out.println("Since the behavior of the area calculation depends on the triangles it uses, those types are not substitutable.");
            violated = true;
        }
        //Expected: true

        assertTrue(violated);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.violated.SSSTriangle")
    void TestSssTriangleViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> evaluation = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> violations = new ArrayList<>();

        // Case 1: Assumption, only available input: Side-Side-Side
        evaluation.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.Triangle().setA(a).setB(b).setC(c) ) );
        //!LSP, Then invoking methods should be true for objects y of type SSSTriangle
        violations.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.SSSTriangle().setA(a).setB(b).setC(c) ) );
        if(evaluation.size() != violations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: true
        boolean violated = isViolated(evaluation, violations, methods, double.class);

        assertTrue(violated);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.violated.SASTriangle")
    void TestSasTriangleViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> evaluation = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> violations = new ArrayList<>();

        // Case 2: Assumption, only available input: Side-Angle-Side
        evaluation.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.Triangle().setA(a).setB(b).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type SASTriangle
        violations.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.SASTriangle().setA(a).setB(b).setGamma(gamma) ) );
        if(evaluation.size() != violations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: true
        boolean violated = isViolated(evaluation, violations, methods, double.class);

        assertTrue(violated);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.violated.ASATriangle")
    void TestAsaTriangleViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> evaluation = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> violations = new ArrayList<>();

        // Case 3: Assumption, only available input: Angle-Side-Angle
        evaluation.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type ASATriangle
        violations.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.ASATriangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        if(evaluation.size() != violations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: true
        boolean violated = isViolated(evaluation, violations, methods, double.class);

        assertTrue(violated);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.SSSTriangle")
    void TestSssTriangleConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("isSSS"); add("isSAS"); add("isASA"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 1: Assumption, only available input: Side-Side-Side
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setC(c) ) );
        //!LSP, Then invoking methods should be true for objects y of type SSSTriangle
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.SSSTriangle().setA(a).setB(b).setC(c) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: false
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertFalse(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.SASTriangle")
    void TestSasTriangleConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("isSSS"); add("isSAS"); add("isASA"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 2: Assumption, only available input: Side-Angle-Side
        provable.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type SASTriangle
        conformations.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.SASTriangle().setA(a).setB(b).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: false
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertFalse(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.ASATriangle")
    void TestAsaTriangleConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("isSSS"); add("isSAS"); add("isASA"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 3: Assumption, only available input: Angle-Side-Angle
        provable.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type ASATriangle
        conformations.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.ASATriangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: false
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertFalse(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.AllTriangles > (SSS)Triangle")
    void TestAllTrianglesSssConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("isSSS"); add("isSAS"); add("isASA"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 4: AllTriangles, (all) available input(s) Side-Side-Side
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setC(c) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setC(c) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: false
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertFalse(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.AllTriangles > (SAS)Triangle")
    void TestAllTrianglesSasConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("isSSS"); add("isSAS"); add("isASA"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 5: AllTriangles, (all) available input(s) Side-Angle-Side
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: false
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertFalse(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.AllTriangles > (ASA)Triangle")
    void TestAllTrianglesAsaConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("isSSS"); add("isSAS"); add("isASA"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 6: AllTriangles, (all) available input(s) Angle-Side-Angle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setBeta(beta).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: false
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertFalse(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.AllTriangles > SSSTriangle")
    void TestAllSssTriangleConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 7: AllTriangles, substitutable with those who implement fewer interfaces like SSSTriangle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.SSSTriangle().setA(a).setB(b).setC(c) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setC(c) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: true
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertTrue(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.AllTriangles > SASTriangle")
    void TestAllSasTriangleConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 8: AllTriangles, substitutable with those who implement fewer interfaces like SASTriangle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.SASTriangle().setA(a).setB(b).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: true
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertTrue(unconformable);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.lsp.complies.AllTriangles > ASATriangle")
    void TestAllAsaTriangleConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();

        // Case 9: AllTriangles, substitutable with those who implement fewer interfaces like ASATriangle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.ASATriangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setBeta(beta).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");

        //Expected: true
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        assertTrue(unconformable);
    }

    //!LSP replacement can be verified by comparing the results returned from the same methods' invocation for generals and related specifics
    private boolean isViolated(List<Triangles> generals, List<Triangles> specifics, List<String> methods, Class<?> returns) {
        Object substitutee = null, substitute = null;
        boolean violated = false;
        String type;

        // generals.size() is equal to specifics.size() so any can be used
        for (int iterator = 0; iterator < generals.size(); iterator++) {
            int i = iterator;

            for (String method: methods) {
                //!LSP violated if the methods are not invokable for specifics
                try {
                    //Entities classifiable as being of SSS/SAS/ASA types
                    if(returns == boolean.class) {
                        substitutee = hasType(generals.get(i), method);
                        substitute  = hasType(specifics.get(i), method);
                    }
                    //Area calculable by SSS|SAS|ASA subclass with SSS|SAS|ASA input
                    if(returns == double.class) {
                        substitutee = getResults(generals.get(i), method);
                        substitute  = getResults(specifics.get(i), method);
                    }
                } catch (Exception e) {
                    violated = true;
                }
                //!LSP violated if the values are not matched for related inputs
                type = ((Supplier<String>) () -> {
                    if(specifics.get(i).getConformations() != null)
                        return specifics.get(i).getConformations().getClass().getName();
                    return specifics.get(i).getViolations().getClass().getName();
                }).get();
                if (substitute != null && !substitute.equals(substitutee)) {
                    System.out.printf("//!LSP violated while invoking %s().%s() %n", type, method);
                    violated = true;
                } else {
                    System.out.printf("//!LSP conformed when invoked %s().%s() %n", type, method);
                }
            }
        }

        return violated;
    }

    //Playing around with reflection, to invoke methods and compare results
    private boolean hasType(Triangles trigonal, String method) {
        return ((BooleanSupplier) () -> {
            try {
                //Entities classifiable as being of SSS/SAS/ASA types
                return (boolean) invokeEntityInstanceMethod(trigonal, method);
            } catch(Exception e) {
                //!LSP violated, unclassifiable by subclass with incompatible input
                //!LSP violated for SSS|SAS|ASA with SAS/ASA|SSS/ASA|SSS/SAS input
                System.out.println(e.getCause().getMessage());
                // ClassNotFoundEx, NoSuchMethodEx, InvocationTargetEx, IllegalAccessEx
                throw new RuntimeException(e);
            }
        }).getAsBoolean();
    }
    //Playing around with reflection, to invoke methods and compare results
    private double getResults(Triangles trigonal, String method) {
        return ((DoubleSupplier) () -> {
            try {
                //Area calculable by SSS|SAS|ASA subclass with SSS|SAS|ASA input
                return (double) invokeEntityInstanceMethod(trigonal, method);
            } catch(Exception e) {
                //!LSP violated, incalculable by subclass with incompatible input
                //!LSP violated for SSS|SAS|ASA with SAS/ASA|SSS/ASA|SSS/SAS input
                System.out.println(e.getCause().getMessage());
                // ClassNotFoundEx, NoSuchMethodEx, InvocationTargetEx, IllegalAccessEx
                throw new RuntimeException(e);
            }
        }).getAsDouble();
    }
    private Object invokeEntityInstanceMethod(Triangles trigonal, String method)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //esoteric.mind.control.code.solid.lsp.complies.*
        if (trigonal.getConformations() != null) {
            return trigonal.getConformations().getClass()
                    .getMethod(method).invoke(trigonal.getConformations());
        }
        //esoteric.mind.control.code.solid.lsp.violated.*
        return trigonal.getViolations().getClass()
                .getMethod(method).invoke( trigonal.getViolations() );
    }
}
