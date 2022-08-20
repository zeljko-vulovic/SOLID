package esoteric.mind.control.code.solid.lsp.violated;

//Enables only Side-Side-Side postulate case
// Triangle(s) -> Triangle -> Trigonal
public class SSSTriangle extends Trigonal {
    //Consturctors are not used in order to be specific with parameters and also not to use default values for parameters.

    @Override
    public double area() {
        return 0;
    }

    //DRY for readability
    @Override
    public double sssArea() {
        return super.sssArea();
    }

    //!LSP violated with sasArea()
    @Override
    public double sasArea() {
        throw new IllegalStateException("//!LSP violated since Side-Angle-Side area calculation is not possible using " + this.getClass().getSimpleName());
    }

    //!LSP violated with asaArea()
    @Override
    public double asaArea() {
        throw new IllegalStateException("//!LSP violated since Angle-Side-Angle area calculation is not possible using " + this.getClass().getSimpleName());
    }
}
