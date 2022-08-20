package esoteric.mind.control.code.solid.lsp.violated;

//Enables only Side-Angle-Side postulate case
// Triangle(s) -> Triangle -> Trigonal
public class SASTriangle extends Trigonal {
    //Consturctors are not used in order to be specific with parameters and also not to use default values for parameters.

    @Override
    public double area() {
        return 0;
    }

    //!LSP violated with sssArea()
    @Override
    public double sssArea() {
        throw new IllegalStateException("//!LSP violated since Side-Side-Side area calculation is not possible using " + this.getClass().getSimpleName());
    }

    //DRY for readability
    @Override
    public double sasArea() {
        return super.sasArea();
    }

    //!LSP violated with asaArea()
    @Override
    public double asaArea() {
        throw new IllegalStateException("//!LSP violated since Angle-Side-Angle area calculation is not possible using " + this.getClass().getSimpleName());
    }
}
