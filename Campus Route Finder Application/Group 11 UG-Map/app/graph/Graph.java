package app.graph;

public class Graph extends Digraph {
    
    @Override
    public void addEdge(Edge edge){
        if(EDGES.contains(edge)) return;

        this.EDGES.add(edge);
        this.EDGES.add(new Edge(edge.getDestination(), edge.getSource(), edge.getDistance()));
        for(Vertex vertex : GRAPH.keySet()){
            if (vertex == edge.getSource()){
                GRAPH.get(vertex).add(edge.getDestination());
            }
        } 

        for(Vertex vertex : GRAPH.keySet()){
            if (vertex == edge.getDestination()){
                GRAPH.get(vertex).add(edge.getSource());
            }
        } 
    }
}
