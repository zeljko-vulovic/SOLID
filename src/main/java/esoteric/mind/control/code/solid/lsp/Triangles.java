package esoteric.mind.control.code.solid.lsp;

//Wrapper class used to pass different types (classes) to same methods
public class Triangles {
    //Reduces DRY in clients

    private final esoteric.mind.control.code.solid.lsp.violated.Trigonal violations;

    private final esoteric.mind.control.code.solid.lsp.complies.Trigonal conformations;

    private Triangles(esoteric.mind.control.code.solid.lsp.violated.Trigonal violations, esoteric.mind.control.code.solid.lsp.complies.Trigonal conformations) {
        this.violations = violations;
        this.conformations = conformations;
    }

    public esoteric.mind.control.code.solid.lsp.violated.Trigonal getViolations() {
        return violations;
    }

    public esoteric.mind.control.code.solid.lsp.complies.Trigonal getConformations() {
        return conformations;
    }

    //!LSP replacement is enabled by setting both subclass and parent class as a type of abstract superclass
    public static Triangles setViolations(esoteric.mind.control.code.solid.lsp.violated.Trigonal triangle) {
        return new Triangles(triangle, null);
    }

    //!LSP replacement is enabled by setting both subclass and parent class as a type of abstract superclass
    public static Triangles setConformations(esoteric.mind.control.code.solid.lsp.complies.Trigonal triangle) {
        return new Triangles(null, triangle);
    }

    @Override
    public String toString() {
        if (getConformations() != null)
            return getConformations().toString();
        return getViolations().toString();
    }
}
