package app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Digraph {
    protected final HashMap<Vertex, ArrayList<Vertex>> GRAPH = new HashMap<>();
    protected final ArrayList<Edge> EDGES = new ArrayList<>();
    private int vertexSize = 0;

    public void addVertex(Vertex vertex){
        if (!GRAPH.containsKey(vertex)){
            GRAPH.put(vertex, new ArrayList<>());
            vertexSize++;
        }
    }

    public void addEdge(Edge edge){
        if(EDGES.contains(edge)) return;

        this.EDGES.add(edge);
        for(Vertex source : GRAPH.keySet()){
            if (source == edge.getSource()){
                GRAPH.get(source).add(edge.getDestination());
            }
        }
    }

    public ArrayList<Edge> getDestinationEdges(Vertex source){
        ArrayList<Edge> destinations = new ArrayList<>();
        for (Edge edge: this.EDGES){
            if (edge.getSource() == source){
                 destinations.add(edge);
            }
        }
        return destinations;
    }

    public Edge getEdge(Vertex source, Vertex destination) {
       for (Edge edge: this.EDGES){
           if (edge.getSource() == source && edge.getDestination() == destination){
               return edge;
           }
       }
       return null;
    }

    public Vertex getNodeByName(String name){
        for(Vertex vertex : GRAPH.keySet()){
            if (vertex.getName().toLowerCase().equals(name.toLowerCase())){
                return vertex;
            }
        }
        return null;
    }

    public Set<Vertex> getNodes(){
        return this.GRAPH.keySet();
    }

    public int getNodeSize() {
        return vertexSize;
    }

    public void printGraph(){
        System.out.println("\n          GRAPH: ADJACENCY LIST                ");
        System.out.println("              PLACES ON CAMPUS                 \n");
        for (HashMap.Entry<Vertex, ArrayList<Vertex>> entry : GRAPH.entrySet()) {
            Vertex vertex = entry.getKey();
            ArrayList<Vertex> destinations = entry.getValue();
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            boolean emptyList = true;
            for (Vertex destinatnion : destinations){
                if(emptyList)
                builder.append(destinatnion.getName());
                else
                builder.append(", "+destinatnion.getName());
                emptyList = false;
            }
            builder.append("]");
             System.out.println(vertex.getName() + "-->" + builder.toString());
            System.out.println("");
        }
    }

    public void listPlaces(Vertex except){
        int index = 1;
        for(Vertex vertex : GRAPH.keySet()){
            if (vertex != except){
                System.out.println(index + ". " + vertex.getName());
            }
            index++;
        }
    }

}
