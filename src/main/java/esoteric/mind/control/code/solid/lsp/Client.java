package esoteric.mind.control.code.solid.lsp;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

//Simplified, irrelevant
public class Client {

    //Simplified since it is not important
    public static void main(String[] args) {
        System.out.println("==> LSP");
        System.out.println("//!LSP TARGETED BEHAVIOR: function successfully executed, without errors");

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        List<String> methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        //List<esoteric.mind.control.code.solid.lsp.violated.Triangle> evaluation = new ArrayList<>();
        List<Triangles> evaluation = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        //List<esoteric.mind.control.code.solid.lsp.violated.Triangle> violations = new ArrayList<>();
        List<Triangles> violations = new ArrayList<>();
        // Case 1: Assumption, only available input: Side-Side-Side
        evaluation.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.Triangle().setA(a).setB(b).setC(c) ) );
        //!LSP, Then invoking methods should be true for objects y of type SSSTriangle
        violations.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.SSSTriangle().setA(a).setB(b).setC(c) ) );
        // Case 2: Assumption, only available input: Side-Angle-Side
        evaluation.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.Triangle().setA(a).setB(b).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type SASTriangle
        violations.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.SASTriangle().setA(a).setB(b).setGamma(gamma) ) );
        // Case 3: Assumption, only available input: Angle-Side-Angle
        evaluation.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type ASATriangle
        violations.add( Triangles.setViolations( new esoteric.mind.control.code.solid.lsp.violated.ASATriangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        if(evaluation.size() != violations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");
        //Expected: true, LSP violated for assumed methods and tested entities
        boolean violated = isViolated(evaluation, violations, methods, double.class);

        methods = new ArrayList<>() {{ add("isSSS"); add("isSAS"); add("isASA"); }};
        //!LSP, Let invoking methods be provable about objects x of type Triangle
        List<Triangles> provable = new ArrayList<>();
        //!LSP, Then invoking methods should be true for objects y of types Triangle(s)
        List<Triangles> conformations = new ArrayList<>();
        // Case 1: Assumption, only available input: Side-Side-Side
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setC(c) ) );
        //!LSP, Then invoking methods should be true for objects y of type SSSTriangle
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.SSSTriangle().setA(a).setB(b).setC(c) ) );
        // Case 2: Assumption, only available input: Side-Angle-Side
        provable.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type SASTriangle
        conformations.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.SASTriangle().setA(a).setB(b).setGamma(gamma) ) );
        // Case 3: Assumption, only available input: Angle-Side-Angle
        provable.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        //!LSP, Then invoking methods should be true for objects y of type ASATriangle
        conformations.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.ASATriangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        // Case 4: AllTriangles, (all) available input(s) Side-Side-Side
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setC(c) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setC(c) ) );
        // Case 5: AllTriangles, (all) available input(s) Side-Angle-Side
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setB(b).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setGamma(gamma) ) );
        // Case 6: AllTriangles, (all) available input(s) Angle-Side-Angle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.Triangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setBeta(beta).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");
        //Expected: false, LSP complies for assumed methods and tested entities
        boolean unconformable = isViolated(provable, conformations, methods, boolean.class);

        provable.clear(); conformations.clear();
        methods = new ArrayList<>() {{ add("sssArea"); add("sasArea"); add("asaArea"); }};
        // Case 7: AllTriangles, substitutable with those who implement fewer interfaces like SSSTriangle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.SSSTriangle().setA(a).setB(b).setC(c) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setC(c) ) );
        // Case 8: AllTriangles, substitutable with those who implement fewer interfaces like SASTriangle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.SASTriangle().setA(a).setB(b).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setB(b).setGamma(gamma) ) );
        // Case 9: AllTriangles, substitutable with those who implement fewer interfaces like ASATriangle
        provable.add( Triangles.setConformations( new esoteric.mind.control.code.solid.lsp.complies.ASATriangle().setA(a).setBeta(beta).setGamma(gamma) ) );
        conformations.add( Triangles.setConformations(  new esoteric.mind.control.code.solid.lsp.complies.AllTriangles().setA(a).setBeta(beta).setGamma(gamma) ) );
        if(provable.size() != conformations.size())
            throw new IllegalCallerException("LSP cannot be proved or disproven due to an incorrect number of (in)comparable entities!");
        //Expected: true, LSP violated for assumed methods and tested entities
        boolean incompliant = isViolated(provable, conformations, methods, boolean.class);

        if (!violated) {
            System.out.printf("Liskov Substitution Principle conformed for %s.*%n", evaluation.get(0).getViolations().getClass().getPackageName());
        }
        if (!unconformable || !incompliant) {
            System.out.printf("Liskov Substitution Principle conformed for %s.*%n", provable.get(0).getConformations().getClass().getPackageName());
        }
        //!LSP violated
        if (violated || (unconformable || incompliant)) {
            throw new IllegalStateException("//!LSP violation of substitutability can cause a system to be polluted with a significant amount of extra mechanisms");
        }
        System.out.println("Liskov Substitution Principle conformed!");
    }

    //!LSP replacement can be verified by comparing the results returned from the same methods' invocation for generals and related specifics
    private static boolean isViolated(List<Triangles> generals, List<Triangles> specifics, List<String> methods, Class<?> returns) {
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
    private static boolean hasType(Triangles trigonal, String method) {
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
    private static double getResults(Triangles trigonal, String method) {
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
    private static Object invokeEntityInstanceMethod(Triangles trigonal, String method)
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
//    //Accepts parameters of different packages with two inputs, of general and specific types
//    private static boolean isViolated(List<Triangles> generals, List<Triangles> specifics) {
//        //!LSP replacement confirmed by calculating areas for generals and related specifics
//        double sssArea = 0, sasArea = 0, asaArea = 0;
//        boolean violated = false;
//        String type = null;
//
//        for (int iterator = 0; iterator < generals.size(); iterator++) {
//            int i = iterator;
//
//            //!LSP violated if the areas are not calculable for specifics
//            try {
//                sssArea = getResult(specifics.get(i),"sssArea");
//            } catch (Exception e) { violated = true; sssArea = -1; }
//            try {
//                sasArea = getResult(specifics.get(i),"sasArea");
//            } catch (Exception e) { violated = true; sasArea = -1; }
//            try {
//                asaArea = getResult(specifics.get(i),"asaArea");
//            } catch (Exception e) { violated = true; asaArea = -1; }
//
//            type = ((Supplier<String>) () -> {
//                if(specifics.get(i).getConformations() != null)
//                    return specifics.get(i).getConformations().getClass().getSimpleName();
//                return specifics.get(i).getViolations().getClass().getSimpleName();
//            }).get().toString();
//            //!LSP replacement provable by calculating areas for generals
//            //!LSP violated if the values are not matched for related inputs
//            if (getResult(generals.get(i),"sssArea") != sssArea) {
//                System.out.printf("//!LSP violated for Side-Side-Side postulate of %s type.%n", type);
//                violated = true;
//            }
//            if (getResult(generals.get(i),"sasArea") != sasArea) {
//                System.out.printf("//!LSP violated for Side-Angle-Side postulate of %s type.%n", type);
//                violated = true;
//            }
//            if (getResult(generals.get(i),"asaArea") != asaArea) {
//                System.out.printf("//!LSP violated for Angle-Side-Angle postulate of %s type.%n", type);
//                violated = true;
//            }
//        }
//        return violated;
//    }
//
//    //DRY reduction, uses reflection to invoke requested method for area calculation
//    private static double getResult(Triangles trigonal, String method) {
//        return ((DoubleSupplier) () -> {
//            try {
//                if (trigonal.getConformations() != null) {
//                    System.out.println(method);
//                    System.out.println(trigonal.getConformations().getClass().getName());
//                    System.out.println(Class.forName(trigonal.getConformations().getClass().getName()).isInstance(trigonal.getConformations()));
//                    if (Class.forName(trigonal.getConformations().getClass().getName())
//                            .isInstance(trigonal.getConformations())) {
//                        //Area calculable by SSS|SAS|ASA subclass with SSS|SAS|ASA input
//                        return (double) trigonal.getConformations().getClass()
//                                .getMethod(method).invoke(trigonal.getConformations());
//                    }
//                }
//                //Area calculable by SSS|SAS|ASA subclass with SSS|SAS|ASA input
//                return (double) trigonal.getViolations().getClass()
//                        .getMethod(method).invoke( trigonal.getViolations() );
//            } catch(Exception e) {
//                e.printStackTrace();
//                //!LSP violated, incalculable by subclass with incompatible input
//                //!LSP violated for SSS|SAS|ASA with SAS/ASA|SSS/ASA|SSS/SAS input
//                System.out.println(e.getCause().getMessage());
//                // ClassNotFoundEx, NoSuchMethodEx, InvocationTargetEx, IllegalAccessEx
//                throw new RuntimeException(e);
//            }
//        }).getAsDouble();
//    }
//TODO: delete