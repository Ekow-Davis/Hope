package app;

import app.graph.Edge;
import app.graph.Graph;
import app.graph.Vertex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(); //creating an instances of the graph class
        Vertex mainGate = new Vertex("Main Gate");
        Vertex greatHall = new Vertex("Great Hall");
        Vertex nb= new Vertex("N Block");
        Vertex  jqb= new Vertex("JQB");
        Vertex balmeLibrary = new Vertex("Balme Library");
        Vertex nnb = new Vertex("NNB");
        Vertex ugcs = new Vertex("UGCS");
        Vertex cc = new Vertex("CC");
        Vertex voltaHall = new Vertex("Volta Hall");
        Vertex akuafoHall = new Vertex("Akuafo Hall");
        Vertex legonHall = new Vertex("Legon Hall");
        Vertex nightMarket = new Vertex("Night Market");
        Vertex sarbahHall = new Vertex("Sarbah Hall");


        // Adding the nodes to the graph
        graph.addVertex(mainGate);
        graph.addVertex(greatHall);
        graph.addVertex(nb);
        graph.addVertex(jqb);
        graph.addVertex(balmeLibrary);
        graph.addVertex(nnb);
        graph.addVertex(ugcs);
        graph.addVertex(cc);
        graph.addVertex(voltaHall);
        graph.addVertex(akuafoHall);
        graph.addVertex(legonHall);
        graph.addVertex(nightMarket);
        graph.addVertex(sarbahHall);


        //adding the edges and getting the distances between vertices
        graph.addEdge(new Edge(mainGate, greatHall, 2400));
        graph.addEdge(new Edge(mainGate, nb , 1200));
        graph.addEdge(new Edge(mainGate, balmeLibrary, 1100));
        graph.addEdge(new Edge(mainGate, jqb, 700));
        graph.addEdge(new Edge(mainGate, nnb, 1600));
        graph.addEdge(new Edge(mainGate, ugcs, 2000));
        graph.addEdge(new Edge(mainGate, cc, 1100));
        graph.addEdge(new Edge(mainGate, voltaHall, 1300));
        graph.addEdge(new Edge(mainGate, akuafoHall, 1100));
        graph.addEdge(new Edge(mainGate, legonHall, 1200));
        graph.addEdge(new Edge(mainGate, nightMarket, 1000));
        graph.addEdge(new Edge(mainGate, sarbahHall, 1300));

        graph.addEdge(new Edge(greatHall, jqb, 2000));
        graph.addEdge(new Edge(greatHall, nb, 1500));
        graph.addEdge(new Edge(greatHall, nnb, 1600));
        graph.addEdge(new Edge(greatHall, balmeLibrary, 1400));
        graph.addEdge(new Edge(greatHall, ugcs, 1400));
        graph.addEdge(new Edge(greatHall, cc, 1400));
        graph.addEdge(new Edge(greatHall, voltaHall, 1200));
        graph.addEdge(new Edge(greatHall, akuafoHall, 2500));
        graph.addEdge(new Edge(greatHall, legonHall, 1200));
        graph.addEdge(new Edge(greatHall, nightMarket, 2200));
        graph.addEdge(new Edge(greatHall, sarbahHall, 2100));

        graph.addEdge(new Edge(nnb, jqb, 1000));
        graph.addEdge(new Edge(nnb, nb, 200));
        graph.addEdge(new Edge(nnb, ugcs, 600));
        graph.addEdge(new Edge(nnb, balmeLibrary, 610));
        graph.addEdge(new Edge(nnb, cc, 1500));
        graph.addEdge(new Edge(nnb, voltaHall, 550));
        graph.addEdge(new Edge(nnb, akuafoHall, 1300));
        graph.addEdge(new Edge(nnb, legonHall, 1100));
        graph.addEdge(new Edge(nnb, nightMarket, 1900));
        graph.addEdge(new Edge(nnb, sarbahHall, 1700));

        graph.addEdge(new Edge(jqb, nb, 900));
        graph.addEdge(new Edge(jqb, ugcs, 850));
        graph.addEdge(new Edge(jqb, balmeLibrary, 840));
        graph.addEdge(new Edge(jqb, cc, 1200));
        graph.addEdge(new Edge(jqb, voltaHall, 1100));
        graph.addEdge(new Edge(jqb, legonHall, 1500));
        graph.addEdge(new Edge(jqb, nightMarket, 1600));
        graph.addEdge(new Edge(jqb, sarbahHall, 1400));

        graph.addEdge(new Edge(ugcs, nb, 550));
        graph.addEdge(new Edge(ugcs, balmeLibrary, 200));
        graph.addEdge(new Edge(ugcs, cc, 800));
        graph.addEdge(new Edge(ugcs, voltaHall, 500));
        graph.addEdge(new Edge(ugcs, akuafoHall, 650));
        graph.addEdge(new Edge(ugcs, legonHall, 600));
        graph.addEdge(new Edge(ugcs, nightMarket, 1300));
        graph.addEdge(new Edge(ugcs, sarbahHall, 500));

        graph.addEdge(new Edge(balmeLibrary, nb, 500));
        graph.addEdge(new Edge(balmeLibrary, cc, 800));
        graph.addEdge(new Edge(balmeLibrary, voltaHall, 400));
        graph.addEdge(new Edge(balmeLibrary, akuafoHall, 270));
        graph.addEdge(new Edge(balmeLibrary, legonHall, 800));
        graph.addEdge(new Edge(balmeLibrary, nightMarket, 1400));
        graph.addEdge(new Edge(balmeLibrary, sarbahHall, 600));

        graph.addEdge(new Edge(cc, voltaHall, 650));
        graph.addEdge(new Edge(cc, akuafoHall, 700));
        graph.addEdge(new Edge(cc, legonHall, 500));
        graph.addEdge(new Edge(cc, nightMarket, 1100));
        graph.addEdge(new Edge(cc, sarbahHall, 200));

        graph.addEdge(new Edge(voltaHall, akuafoHall, 1400));
        graph.addEdge(new Edge(voltaHall, legonHall, 190));
        graph.addEdge(new Edge(voltaHall, nightMarket, 1500));
        graph.addEdge(new Edge(voltaHall, nightMarket, 700));

        graph.addEdge(new Edge(akuafoHall, legonHall, 700));
        graph.addEdge(new Edge(akuafoHall, nightMarket, 1100));
        graph.addEdge(new Edge(akuafoHall, sarbahHall, 500));

        graph.addEdge(new Edge(legonHall, nightMarket, 1300));
        graph.addEdge(new Edge(legonHall, sarbahHall, 500));

        graph.addEdge(new Edge(sarbahHall, nightMarket, 550));


         


        //asking the user for his/her current location
        System.out.println("PLEASE CHOOSE YOUR CURRENT LOCATION:");
        graph.listPlaces(null);


        // User interface
        //The places available
        String places[] = {"Main Gate","Sarbah Hall", "CC","Night Market","Volta Hall","Akuafo Hall","Legon Hall","Great Hall","NNB", "N Block", "JQB", "Balme Library","UGCS",};

        JFrame frame = new JFrame();//creating instance of JFrame

        //displaying places in the comboBox
        JComboBox sourceCombo = new JComboBox(places);
        sourceCombo.setBounds(50, 50, 200, 20);
        frame.add(sourceCombo);//adding button in JFrame

        JComboBox destinationCombo = new JComboBox(places);
        destinationCombo.setBounds(50, 100, 200, 20);
        frame.add(destinationCombo);//adding button in JFrame

        //  inserting a lable displaying the shortest path text
        JLabel info = new JLabel();
        info.setText("Shortest Path: ");
        info.setBounds(10, 200, 150, 40);//x axis, y axis, width, height
        frame.add(info);

        JLabel shortestPathDisplay = new JLabel();
        shortestPathDisplay.setBounds(10, 220, 400, 40);//x axis, y axis, width, height
        frame.add(shortestPathDisplay);

        JLabel distanceDisplay = new JLabel();
        distanceDisplay.setBounds(10, 240, 400, 40);//x axis, y axis, width, height
        frame.add(distanceDisplay);

        JLabel timeDisplay = new JLabel();
        timeDisplay.setBounds(10, 240, 400, 40);//x axis, y axis, width, height
        frame.add(timeDisplay);

        JButton button = new JButton("Find Shortest Path");
        button.setBounds(100, 150, 150, 40);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String theOrigin = sourceCombo.getSelectedItem().toString();
                String theEnd = destinationCombo.getSelectedItem().toString();

                Vertex source = graph.getNodeByName(theOrigin);
                Vertex destination = graph.getNodeByName(theEnd);

                Dijkstra.findShortestPath(graph, source, destination);
                String path = Dijkstra.getShortestPath(source, destination);
                shortestPathDisplay.setText(path);

                distanceDisplay.setText("Total Distance: "+Dijkstra.getTotalDistance(destination));

        
            }
        });

        // Display
        frame.setSize(400, 500);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.setVisible(true);//making the frame visible

    }
}