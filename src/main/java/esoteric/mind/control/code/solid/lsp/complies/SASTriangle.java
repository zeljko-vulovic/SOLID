package esoteric.mind.control.code.solid.lsp.complies;

// Triangle(s) -> Triangle -> Trigonal
public class SASTriangle extends Trigonal implements SASTrigonal {
    //!LSP conformed by having more features (area calculator) than parent

    @Override
    public double sasArea() {
        if ( isSAS() )
            return Area.calculateSAS(getA(), getB(), getGamma());

        //Different implementation thus different exception
        throw new IllegalCallerException("//!LSP violated since Side-Angle-Side Postulate needs Side-Angle-Side properties of Triangle!");
    }
}
