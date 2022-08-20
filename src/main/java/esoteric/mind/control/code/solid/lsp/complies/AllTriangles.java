package esoteric.mind.control.code.solid.lsp.complies;

//Enfolds all possible area calculators
// Triangle(s) -> Triangle -> Trigonal
public class AllTriangles extends Trigonal implements SSSTrigonal, SASTrigonal, ASATrigonal {
    //!LSP conformed by having (much) more features (all area calculators) than parent

    @Override
    public double sssArea() {
        if ( isSSS() )
            return Area.calculateSSS(getA(), getB(), getC());
        //Different implementation thus different exception
        throw new IllegalStateException("//!LSP violated since Side-Side-Side Postulate needs Side-Side-Side properties of Triangle!");
    }

    @Override
    public double sasArea() {
        if ( isSAS() )
            return Area.calculateSAS(getA(), getB(), getGamma());
        //Different implementation thus different exception
        throw new IllegalStateException("//!LSP violated since Side-Angle-Side Postulate needs Side-Angle-Side properties of Triangle!");
    }

    @Override
    public double asaArea() {
        if ( isASA() )
            return Area.calculateASA(getA(), getBeta(), getGamma());
        //Different implementation thus different exception
        throw new IllegalStateException("//!LSP violated since Angle-Side-Angle Postulate needs Angle-Side-Angle properties of Triangle!");
    }
}
