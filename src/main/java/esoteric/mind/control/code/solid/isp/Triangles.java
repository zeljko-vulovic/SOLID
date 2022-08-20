package esoteric.mind.control.code.solid.isp;

//Wrapper class used to pass different types (classes) to same methods
public class Triangles {
    //Reduces DRY in clients

    private final esoteric.mind.control.code.solid.isp.violated.Triangle violations;

    private final esoteric.mind.control.code.solid.isp.complies.Triangle conformations;

    private Triangles(esoteric.mind.control.code.solid.isp.violated.Triangle violations, esoteric.mind.control.code.solid.isp.complies.Triangle conformations) {
        this.violations = violations;
        this.conformations = conformations;
    }

    public esoteric.mind.control.code.solid.isp.violated.Triangle getViolations() {
        return violations;
    }

    public esoteric.mind.control.code.solid.isp.complies.Triangle getConformations() {
        return conformations;
    }

    public static Triangles setViolations(esoteric.mind.control.code.solid.isp.violated.Triangle triangle) {
        return new Triangles(triangle, null);
    }

    public static Triangles setConformations(esoteric.mind.control.code.solid.isp.complies.Triangle triangle) {
        return new Triangles(null, triangle);
    }

    @Override
    public String toString() {
        if (getConformations() != null)
            return getConformations().toString();
        return getViolations().toString();
    }
}
