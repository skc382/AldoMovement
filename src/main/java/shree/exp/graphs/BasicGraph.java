package shree.exp.graphs;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BasicGraph {

    private LinkedList<Integer>[] adjacencyList;

    public BasicGraph(int numberOfVertices) {

        this.adjacencyList = new LinkedList[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyList[src].addFirst(dest);
        adjacencyList[dest].addFirst(src);
    }

    public void printGraph() {
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print(String.format("At vertex-%d: ", i));

            Iterator<Integer> it = adjacencyList[i].iterator();
            while(it.hasNext()) {
                System.out.print(it.next()+", ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        BasicGraph g = new BasicGraph(V);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // print the adjacency list representation of
        // the above graph
        g.printGraph();
    }
}
