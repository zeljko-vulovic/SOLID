package esoteric.mind.control.code.solid.dip;

import esoteric.mind.control.code.solid.dip.complies.AreaCalculator;

//Simplified, irrelevant
public class Client {

    //Simplified since it is not important
    public static void main(String[] args) {
        System.out.println("==> DIP");
        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        //!DIP violated
        boolean violated = false;
        double sssArea = 0, sasArea = 0, asaArea = 0;
        // Case 1: Tightly-coupling to SSS, failing SAS and ASA
        esoteric.mind.control.code.solid.dip.violated.Triangle violation
                = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setC(c);
        //!DIP violated, concretely depending on (SSSCalculator) module
        esoteric.mind.control.code.solid.dip.violated.SSSCalculator sssCalculator
                = new esoteric.mind.control.code.solid.dip.violated.SSSCalculator();
        sssArea = violation.area(sssCalculator);
        //!DIP violated, fails compatibility, failing SAS (and ASA)
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setGamma(gamma);
        sasArea = violation.area(sssCalculator);
        //!DIP violated, fails compatibility, failing (SAS and) ASA
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        asaArea = violation.area(sssCalculator);
        // Case 1: Tightly-coupling to SSS, failing SAS and ASA
        System.out.printf("SSS area for the shape calculated by %s is %s.%n", sssCalculator.getClass().getName(), sssArea);
        if (sssArea != sasArea || sssArea != asaArea || sasArea != asaArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", violation.getClass().getName());
            System.out.println("//!DIP violated since tightly-coupling to SSS postulate, thus failing SAS and ASA postulates.");
            violated = true;
        }
        // Case 2: Tightly-coupling to SAS, failing SSS and ASA
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setGamma(gamma);
        //!DIP violated, concretely depending on (SASCalculator) module
        esoteric.mind.control.code.solid.dip.violated.SASCalculator sasCalculator
                = new esoteric.mind.control.code.solid.dip.violated.SASCalculator();
        sasArea = violation.area(sasCalculator);
        //!DIP violated, fails compatibility, failing SSS (and ASA)
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setC(c);
        sssArea = violation.area(sasCalculator);
        //!DIP violated, fails compatibility, failing (SSS and) ASA
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        asaArea = violation.area(sasCalculator);
        // Case 2: Tightly-coupling to SAS, failing SSS and ASA
        System.out.printf("SAS area for the shape calculated by %s is %s.%n", sasCalculator.getClass().getName(), sasArea);
        if (sasArea != sssArea || sasArea != asaArea || sssArea != asaArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", violation.getClass().getName());
            System.out.println("//!DIP violated since tightly-coupling to SAS postulate, thus failing SSS and ASA postulates.");
            violated = true;
        }
        // Case 3: Tightly-coupling to ASA, failing SSS and SAS
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        //!DIP violated, concretely depending on (ASACalculator) module
        esoteric.mind.control.code.solid.dip.violated.ASACalculator asaCalculator
                = new esoteric.mind.control.code.solid.dip.violated.ASACalculator();
        asaArea = violation.area(asaCalculator);
        //!DIP violated, fails compatibility, failing SSS (and SAS)
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setC(c);
        sssArea = violation.area(asaCalculator);
        //!DIP violated, fails compatibility, failing (SSS and) SAS
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setGamma(gamma);
        sasArea = violation.area(asaCalculator);
        // Case 3: Tightly-coupling to ASA, failing SSS and SAS
        System.out.printf("ASA area for the shape calculated by %s is %s.%n", asaCalculator.getClass().getName(), asaArea);
        if (asaArea != sssArea || asaArea != sasArea || sssArea != sasArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", violation.getClass().getName());
            System.out.println("//!DIP violated since tightly-coupling to ASA postulate, thus failing SSS and SAS postulates.");
            violated = true;
        }

        //!DIP conformed
        AreaCalculator conceptual;
        // Case 1: Assumption, only available input: Side-Side-Side
        esoteric.mind.control.code.solid.dip.complies.Triangle conformation
                = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setB(b).setC(c);
        //!DIP conformed, depending on interface, implementer assures compatibility
        /*AreaCalculator*/ conceptual = new esoteric.mind.control.code.solid.dip.complies.SSSCalculator();
        sssArea = conformation.area(conceptual);
        System.out.printf("SSS area for the shape of type %s is %s.%n", conformation.getClass().getName(), sssArea);
        // Case 2: Assumption, only available input: Side-Angle-Side
        conformation = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setB(b).setGamma(gamma);
        //!DIP conformed, depending on interface, implementer assures compatibility
        /*AreaCalculator*/ conceptual = new esoteric.mind.control.code.solid.dip.complies.SASCalculator();
        sasArea = conformation.area(conceptual);
        System.out.printf("SAS area for the shape of type %s is %s.%n", conformation.getClass().getName(), sasArea);
        // Case 3: Assumption, only available input: Angle-Side-Angle
        conformation = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        //!DIP conformed, depending on interface, implementer assures compatibility
        /*AreaCalculator*/ conceptual = new esoteric.mind.control.code.solid.dip.complies.ASACalculator();
        asaArea = conformation.area(conceptual);
        System.out.printf("ASA area for the shape of type %s is %s.%n", conformation.getClass().getName(), asaArea);
        //!DIP NOT violated, NOT tightly-coupled, NOT failing compatibility
        if (sssArea != sasArea || sssArea != asaArea || sasArea != asaArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", conformation.getClass().getName());
            violated = true;
        }

        //!DIP violated
        if (violated) {
            throw new IllegalStateException("//!DIP violation of dependence can cause a system modules to be tightly-coupled, thus rigid and inflexible");
        }
        System.out.println("Dependency Inversion Principle conformed!");
    }
}
