package esoteric.mind.control.code.solid.isp.complies;

// Tetrahedron(s) -> Tetrahedron -> Shapable
public class RegularTetrahedron implements Tetrahedron {
    //!ISP NOT violated with volume() method

    private double edge;

    public double getEdge() {
        return edge;
    }
    public RegularTetrahedron setEdge(double edge) {
        this.edge = edge;
        return this;
    }

    @Override
    public double area() {
        if( getEdge() != 0 )
            return surfaceArea( getEdge() );

        throw new IllegalCallerException("A regular tetrahedron requires an edge length a to calculate surface area.");
    }
    private double surfaceArea(double a) {
        return Math.round( (Math.sqrt(3) * Math.pow(a, 2)) *100.0)/100.0;
    }

    @Override
    //!ISP violated if in Shapable
    public double volume() {
        if( getEdge() != 0 )
            return Math.round( (Math.pow(getEdge(), 3) / (6 * Math.sqrt(2))) *100.0)/100.0;

        throw new IllegalCallerException("A regular tetrahedron requires an edge length a to calculate it's volume.");
    }
}
