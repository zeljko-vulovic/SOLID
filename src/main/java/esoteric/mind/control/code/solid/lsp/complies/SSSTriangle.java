package esoteric.mind.control.code.solid.lsp.complies;

// Triangle(s) -> Triangle -> Trigonal
public class SSSTriangle extends Trigonal implements SSSTrigonal {
    //!LSP conformed by having more features (area calculator) than parent

    @Override
    public double sssArea() {
        if ( isSSS() )
            return Area.calculateSSS(getA(), getB(), getC());

        //Different implementation thus different exception
        throw new IllegalCallerException("//!LSP violated since Side-Side-Side Postulate needs Side-Side-Side properties of Triangle!");
    }
}