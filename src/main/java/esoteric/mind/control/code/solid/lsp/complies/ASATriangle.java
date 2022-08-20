package esoteric.mind.control.code.solid.lsp.complies;

// Triangle(s) -> Triangle -> Trigonal
public class ASATriangle extends Trigonal implements ASATrigonal {
    //!LSP conformed by having more features (area calculator) than parent

    @Override
    public double asaArea() {
        if ( isASA() )
            return Area.calculateASA(getA(), getBeta(), getGamma());

        //Different implementation thus different exception
        throw new IllegalCallerException("//!LSP violated since Angle-Side-Angle Postulate needs Angle-Side-Angle properties of Triangle!");
    }
}
