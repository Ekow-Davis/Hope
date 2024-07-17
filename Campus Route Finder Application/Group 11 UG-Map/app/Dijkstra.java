package app;

import java.util.ArrayList;
import java.util.HashMap;

import app.graph.Digraph;
import app.graph.Edge;
import app.graph.Vertex;

public class Dijkstra {
    // Keep track of all Vertex in the graph that haven't been visited yet.
    private static ArrayList<Vertex> NOT_VISITED = new ArrayList<>();

    // A map of each vertex, along with the minimum cost/distance between them.
    private static HashMap<Vertex, Integer> DISTANCE_MAP = new HashMap<>();

    // A vertex's map and the preceding vertex from which it was reached. Later, it was used to recreate the minimum path.
    private static HashMap<Vertex, Vertex> PREVIOUS_VERTEX = new HashMap<>();

    public static void findShortestPath(Digraph graph, Vertex source, Vertex destination) {
        if (source == destination) {
            System.out.print(source.getName());
            return;
        }

        // Set the cost to reach each vertex to infinity.
        for (Vertex vertex : graph.getNodes()) {
            DISTANCE_MAP.put(vertex, Integer.MAX_VALUE);
            PREVIOUS_VERTEX.put(vertex, null);
            NOT_VISITED.add(vertex);
        }

        // Set the cost to reach the source vertex to zero.
        DISTANCE_MAP.put(source, 0);

        // Find the vertex with least distance to reach.
        Vertex minNode = findVertextWithMinDist();
        while (NOT_VISITED.size() > 0 && minNode != null) {
            // Find the vertex with least distance to reach.
            minNode = findVertextWithMinDist();

            // Mark this vertex as visited.
            NOT_VISITED.remove(minNode);

            // Explore all the neighbours of this vertex.
            ArrayList<Edge> edges = graph.getDestinationEdges(minNode);
            for (Edge edge : edges) {
                // Checking for cyles: i.e., if we've not already visited this vertex.
                if (NOT_VISITED.contains(edge.getDestination())) {

                    // Calculate alternative cost
                    int alt = DISTANCE_MAP.get(minNode) + edge.getDistance();

                    if (alt < DISTANCE_MAP.get(edge.getDestination())) { // If the alternative cost is smaller than the current cost.
                        // Update the min cost to reach this vertex.
                        DISTANCE_MAP.put(edge.getDestination(), alt);

                        // Udate the previous vertex to reach this current vertex. 
                        PREVIOUS_VERTEX.put(edge.getDestination(), minNode);
                    }
                }
            }
        }
        printShortestPath(source, destination);
        printDistances(destination);
    }

    private static void printDistances(Vertex destination) {
        System.out.println("Total Distance: " + String.format("%.3f", DISTANCE_MAP.get(destination)/1000F) + "km \n");
    }

    public static String getTotalDistance(Vertex destination) {
        return String.format("%.3f", DISTANCE_MAP.get(destination)/1000f) + "km";
    }

    private static void printPrevious() {
        // Print each vertex and the previous vertex to reach it. 
        System.out.println("*****************************");
        for (HashMap.Entry<Vertex, Vertex> entry : PREVIOUS_VERTEX.entrySet()) {
            Vertex vertex = entry.getKey();
            Vertex PREVIOUS_VERTEX = entry.getValue();
            if (PREVIOUS_VERTEX != null)
                System.out.println(vertex.getName() + " --> " + PREVIOUS_VERTEX.getName());
            else {
                System.out.println(vertex.getName() + " --> " + "naa");
            }
        }
    }


    public static String getShortestPath(Vertex source, Vertex destination) {
        ArrayList<Vertex> path = new ArrayList<>();

        while (PREVIOUS_VERTEX.get(destination) != null) {
            path.add(destination);
            destination = PREVIOUS_VERTEX.get(destination);
        }
        path.add(source);

        StringBuilder builder = new StringBuilder();
        for (int i = path.size() - 1; i >= 0; i--) {
            Vertex vertex = path.get(i);
            builder.append(vertex.getName());
            builder.append(" -> ");
        }
        return builder.toString();
    }

    private static void printShortestPath(Vertex source, Vertex destination) {
        // Using the preceding Vertex, re-create the path to your target/destination.
        System.out.println("\nShortest path from '" + source.getName() + "' to '" + destination.getName() + "' using Dijkstra.");
        ArrayList<Vertex> path = new ArrayList<>();
        System.out.print(source.getName());
        while (PREVIOUS_VERTEX.get(destination) != null) {
            path.add(destination);
            destination = PREVIOUS_VERTEX.get(destination);
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            Vertex vertex = path.get(i);
            System.out.print(" --> " + vertex.getName());
        }
        System.out.println("");
    }

    private static Vertex findVertextWithMinDist() {
        // Linear search for the min cost vertex based on the distance. 
        Vertex minNode = null;
        long minDistance = Long.MAX_VALUE;
        for (HashMap.Entry<Vertex, Integer> entry : DISTANCE_MAP.entrySet()) {
            Vertex vertex = entry.getKey();
            int distance = entry.getValue();
            if (NOT_VISITED.contains(vertex) && distance < minDistance) {
                minDistance = distance;
                minNode = vertex;
            }
        }
        return minNode;
    }
}
