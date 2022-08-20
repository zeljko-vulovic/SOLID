package esoteric.mind.control.code.solid.lsp.violated.substitutability;

//Since the behavior of the area calculation depends on the types it uses, those types are not substitutable.
public class EquilateralTriangle extends ScaleneTriangle {

    public EquilateralTriangle(double a) {
        super(a, a, a);
    }
}
