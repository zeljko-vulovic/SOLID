package esoteric.mind.control.code.solid.lsp.violated.substitutability;

//Simplified, unimportant
public class Client {

    //Simplified since it is not important
    public static void main(String[] args) {
        System.out.println("==> LSP");
        System.out.println("!LSP TARGETED BEHAVIOR: same results");
        //Probable outcome: Since the behavior of the function depends on the types it uses, those types are not substitutable.

        double a = 4, b = 4, c = 5;
        //double beta = 51.25, gamma = 77.5;

        boolean violated = false;
        //Let calculating area be provable about objects x of type ScaleneTriangle.
        ScaleneTriangle scaleneTriangle = new ScaleneTriangle(a, b, c);
        //Then calculating area should be true for objects y of type EquilateralTriangle
        ScaleneTriangle equilateralTriangle = new EquilateralTriangle(a);
        //Then calculating area should be true for objects y of type IsoscelesTriangle
        ScaleneTriangle isoscelesTriangle = new IsoscelesTriangle(a, b);

        //!LSP violated if the values do not match for given input
        if (scaleneTriangle.area() != equilateralTriangle.area()) {
            System.out.println("LSP violated for equilateral triangle.");
            violated = true;
        }
        //!LSP violated if the values do not match for given input
        if (scaleneTriangle.area() != isoscelesTriangle.area()) {
            System.out.println("LSP violated for isosceles triangle.");
            violated = true;
        }
        //!LSP NOT violated, values fixed for the use case
        if (equilateralTriangle.area() != isoscelesTriangle.area()) {
            System.out.println("LSP violated for equilateral and isosceles triangle.");
            violated = true;
        }

        //!LSP violated
        if (violated) {
            throw new IllegalStateException("Since the behavior of the area calculation depends on the triangles it uses, those types are not substitutable.");
        }
        System.out.println("Liskov Substitution Principle conformed!");
    }
}
