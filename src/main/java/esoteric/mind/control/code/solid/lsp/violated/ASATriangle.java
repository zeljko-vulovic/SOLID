package esoteric.mind.control.code.solid.lsp.violated;

//Enables only Angle-Side-Angle postulate case
// Triangle(s) -> Triangle -> Trigonal
public class ASATriangle extends Trigonal {
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

    //!LSP violated with sasArea()
    @Override
    public double sasArea() {
        throw new IllegalStateException("//!LSP violated since Side-Angle-Side area calculation is not possible using " + this.getClass().getSimpleName());
    }

    //DRY for readability
    @Override
    public double asaArea() {
        return super.asaArea();
    }
}
