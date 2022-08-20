package esoteric.mind.control.code;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DIPTest {

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.dip.violated.SSSCalculator")
    void TestSssCalculatorViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        // Case 1: Tightly-coupling to SSS, failing SAS and ASA
        esoteric.mind.control.code.solid.dip.violated.Triangle violation
                = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setC(c);
        //!DIP violated, concretely depending on (SSSCalculator) module
        esoteric.mind.control.code.solid.dip.violated.SSSCalculator sssCalculator
                = new esoteric.mind.control.code.solid.dip.violated.SSSCalculator();
        double sssArea = violation.area(sssCalculator);
        //!DIP violated, fails compatibility, failing SAS (and ASA)
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setGamma(gamma);
        double sasArea = violation.area(sssCalculator);
        //!DIP violated, fails compatibility, failing (SAS and) ASA
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        double asaArea = violation.area(sssCalculator);

        boolean violated = false;
        System.out.printf("SSS area for the shape calculated by %s is %s.%n", sssCalculator.getClass().getName(), sssArea);
        if (sssArea != sasArea || sssArea != asaArea || sasArea != asaArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", violation.getClass().getName());
            System.out.println("//!DIP violated since tightly-coupling to SSS postulate, thus failing SAS and ASA postulates.");
            violated = true;
        }
        assertTrue(violated);

        assertEquals(7.81, sssArea);
        assertNotEquals(sssArea, sasArea);
        assertNotEquals(sssArea, asaArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.dip.violated.SASCalculator")
    void TestSasCalculatorViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        // Case 2: Tightly-coupling to SAS, failing SSS and ASA
        esoteric.mind.control.code.solid.dip.violated.Triangle violation
                = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setGamma(gamma);
        //!DIP violated, concretely depending on (SASCalculator) module
        esoteric.mind.control.code.solid.dip.violated.SASCalculator sasCalculator
                = new esoteric.mind.control.code.solid.dip.violated.SASCalculator();
        double sasArea = violation.area(sasCalculator);
        //!DIP violated, fails compatibility, failing SSS (and ASA)
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setC(c);
        double sssArea = violation.area(sasCalculator);
        //!DIP violated, fails compatibility, failing (SSS and) ASA
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        double asaArea = violation.area(sasCalculator);

        boolean violated = false;
        System.out.printf("SAS area for the shape calculated by %s is %s.%n", sasCalculator.getClass().getName(), sasArea);
        if (sasArea != sssArea || sasArea != asaArea || sssArea != asaArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", violation.getClass().getName());
            System.out.println("//!DIP violated since tightly-coupling to SAS postulate, thus failing SSS and ASA postulates.");
            violated = true;
        }
        assertTrue(violated);

        assertEquals(7.81, sasArea);
        assertNotEquals(sasArea, sssArea);
        assertNotEquals(sasArea, asaArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.dip.violated.ASACalculator")
    void TestAsaCalculatorViolations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        // Case 3: Tightly-coupling to ASA, failing SSS and SAS
        esoteric.mind.control.code.solid.dip.violated.Triangle violation
                = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        //!DIP violated, concretely depending on (ASACalculator) module
        esoteric.mind.control.code.solid.dip.violated.ASACalculator asaCalculator
                = new esoteric.mind.control.code.solid.dip.violated.ASACalculator();
        double asaArea = violation.area(asaCalculator);
        //!DIP violated, fails compatibility, failing SSS (and SAS)
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setC(c);
        double sssArea = violation.area(asaCalculator);
        //!DIP violated, fails compatibility, failing (SSS and) SAS
        violation = new esoteric.mind.control.code.solid.dip.violated.Triangle().setA(a).setB(b).setGamma(gamma);
        double sasArea = violation.area(asaCalculator);

        boolean violated = false;
        System.out.printf("ASA area for the shape calculated by %s is %s.%n", asaCalculator.getClass().getName(), asaArea);
        if (asaArea != sssArea || asaArea != sasArea || sssArea != sasArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", violation.getClass().getName());
            System.out.println("//!DIP violated since tightly-coupling to ASA postulate, thus failing SSS and SAS postulates.");
            violated = true;
        }
        assertTrue(violated);

        assertEquals(7.81, asaArea);
        assertNotEquals(asaArea, sssArea);
        assertNotEquals(asaArea, sasArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.dip.complies.SSSCalculator")
    void TestSssCalculatorConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        // Case 1: Assumption, only available input: Side-Side-Side
        esoteric.mind.control.code.solid.dip.complies.Triangle conformation
                = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setB(b).setC(c);
        //!DIP conformed, depending on interface, implementer assures compatibility
        esoteric.mind.control.code.solid.dip.complies.AreaCalculator conceptual
                = new esoteric.mind.control.code.solid.dip.complies.SSSCalculator();
        double sssArea = conformation.area(conceptual);
        System.out.printf("SSS area for the shape of type %s is %s.%n", conformation.getClass().getName(), sssArea);

        assertEquals(7.81, sssArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.dip.complies.SASCalculator")
    void TestSasCalculatorConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        // Case 2: Assumption, only available input: Side-Angle-Side
        esoteric.mind.control.code.solid.dip.complies.Triangle conformation
                = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setB(b).setGamma(gamma);
        //!DIP conformed, depending on interface, implementer assures compatibility
        esoteric.mind.control.code.solid.dip.complies.AreaCalculator conceptual
                = new esoteric.mind.control.code.solid.dip.complies.SASCalculator();
        double sasArea = conformation.area(conceptual);
        System.out.printf("SAS area for the shape of type %s is %s.%n", conformation.getClass().getName(), sasArea);

        assertEquals(7.81, sasArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.dip.complies.ASACalculator")
    void TestAsaCalculatorConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        // Case 3: Assumption, only available input: Angle-Side-Angle
        esoteric.mind.control.code.solid.dip.complies.Triangle conformation
                = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        //!DIP conformed, depending on interface, implementer assures compatibility
        esoteric.mind.control.code.solid.dip.complies.AreaCalculator conceptual
                = new esoteric.mind.control.code.solid.dip.complies.ASACalculator();
        double asaArea = conformation.area(conceptual);
        System.out.printf("ASA area for the shape of type %s is %s.%n", conformation.getClass().getName(), asaArea);

        assertEquals(7.81, asaArea);
    }

    @Test
    @DisplayName("Test esoteric.mind.control.code.solid.dip.complies.AreaCalculator")
    void TestTriangleAreaCalculatorConformations() {
        //Simplified since not important, DRY for readability

        double a = 4, b = 4, c = 5;
        double beta = 51.25, gamma = 77.5;

        //!DIP conformed
        esoteric.mind.control.code.solid.dip.complies.AreaCalculator conceptual;
        // Case 1: Assumption, only available input: Side-Side-Side
        esoteric.mind.control.code.solid.dip.complies.Triangle conformation
                = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setB(b).setC(c);
        //!DIP conformed, depending on interface, implementer assures compatibility
        /*AreaCalculator*/ conceptual = new esoteric.mind.control.code.solid.dip.complies.SSSCalculator();
        double sssArea = conformation.area(conceptual);
        // Case 2: Assumption, only available input: Side-Angle-Side
        conformation = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setB(b).setGamma(gamma);
        //!DIP conformed, depending on interface, implementer assures compatibility
        /*AreaCalculator*/ conceptual = new esoteric.mind.control.code.solid.dip.complies.SASCalculator();
        double sasArea = conformation.area(conceptual);
        // Case 3: Assumption, only available input: Angle-Side-Angle
        conformation = new esoteric.mind.control.code.solid.dip.complies.Triangle().setA(a).setBeta(beta).setGamma(gamma);
        //!DIP conformed, depending on interface, implementer assures compatibility
        /*AreaCalculator*/ conceptual = new esoteric.mind.control.code.solid.dip.complies.ASACalculator();
        double asaArea = conformation.area(conceptual);

        System.out.printf("SSS area for the shape of type %s is %s.%n", conformation.getClass().getName(), sssArea);
        System.out.printf("SAS area for the shape of type %s is %s.%n", conformation.getClass().getName(), sasArea);
        System.out.printf("ASA area for the shape of type %s is %s.%n", conformation.getClass().getName(), asaArea);

        boolean violated = false;
        //!DIP NOT violated, NOT tightly-coupled, NOT failing compatibility
        if (sssArea != sasArea || sssArea != asaArea || sasArea != asaArea) {
            System.out.printf("//!DIP violated for class method: %s.area().%n", conformation.getClass().getName());
            violated = true;
        }
        assertFalse(violated);

        assertEquals(7.81, sssArea);
        assertEquals(7.81, sasArea);
        assertEquals(7.81, asaArea);
    }
}
