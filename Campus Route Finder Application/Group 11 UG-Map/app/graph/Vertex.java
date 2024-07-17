package app.graph;

public class Vertex {
    private String name;

    public Vertex(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex){
            Vertex other = (Vertex) obj;
            return other.getName().equals(getName());
            }
        return false;
    }
    
    @Override
    public String toString() {
        return this.name;
    }    
}
