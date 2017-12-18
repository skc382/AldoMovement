package shree.exp.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shreedharkempanayakanahallichampakaram on 12/16/17.
 */
public class GraphTraversal {

    LinkedList<Integer>[] adjList;

    GraphTraversal(int numberOfNodes) {
        this.adjList = new LinkedList[numberOfNodes];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void bfs(int vertex) {
        boolean[] visited = new boolean[adjList.length];

        System.out.println("BFS:");
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        visited[vertex] = true;

        while (q.size() > 0) {
            int curr = q.poll();
            System.out.println("Visiting: "+ curr);
//            visited[curr] = true;
            for (Integer childVertices : adjList[curr]) {
                if (!visited[childVertices]) {
                    q.add(childVertices);
                    visited[childVertices] = true;
                }
            }
        }
        System.out.println();
    }

    public void dfs(int v) {
        boolean[] visited = new boolean[adjList.length];
        System.out.println("DFS:");
        dfsUtil(v, visited);
    }

    private void dfsUtil(int curr, boolean[] visited) {

        visited[curr] = true;
        System.out.println("Visiting: "+ curr);

        for(Integer val : adjList[curr]) {
            if(!visited[val]) {
                dfsUtil(val,visited);
            }
        }
    }


    public static void main(String[] args) {
        GraphTraversal g = new GraphTraversal(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
        g.dfs(2);
    }


}
