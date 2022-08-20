package esoteric.mind.control.code.solid.lsp.violated;

//!LSP, parent class for triangle types
// Triangle(s) -> Triangle -> Trigonal
public class Triangle extends Trigonal {

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double sssArea() {
        try {
            return super.sssArea();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public double sasArea() {
        try {
            return super.sasArea();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public double asaArea() {
        try {
            return super.asaArea();
        } catch (Exception e) {
            return 0;
        }
    }
}
