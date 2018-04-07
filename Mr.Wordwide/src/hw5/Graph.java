// A Java program to print topological sorting of a DAG
import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency
// list representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List
 
    //Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj[v].add(w); }
 
    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
 
        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }
 
    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    Stack topologicalSort()
    {
        Stack stack = new Stack();
 
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        return stack;
        
    }
 
    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g1_a = new Graph(8);
        Map m1_a = new HashMap();
        Stack s1_a;
        m1_a.put(0, "Crazy");
        m1_a.put(1, "Professors");
        m1_a.put(2, "Hackers");
        m1_a.put(3, "Eccentrics");
        m1_a.put(4, "Teachers");
        m1_a.put(5, "Programmers");
        m1_a.put(6, "Dwarfs");
        m1_a.put(7, "Everything");
        
        g1_a.addEdge(0, 1);
        g1_a.addEdge(0, 2);
        g1_a.addEdge(1, 3);
        g1_a.addEdge(1, 4);
        g1_a.addEdge(2, 3);
        g1_a.addEdge(2, 5);
        g1_a.addEdge(3, 6);
        g1_a.addEdge(4, 6);
        g1_a.addEdge(5, 6);
        g1_a.addEdge(6, 7);
//        g1.addEdge(13, 9);
//        g1.addEdge(13, 11);
//        g1.addEdge(13, 12);
//        g1.addEdge(11, 9);
//        g1.addEdge(11, 10);
//        g1.addEdge(12, 9);
//        g1.addEdge(12, 10);
//        g1.addEdge(9, 7);
//        g1.addEdge(10, 7);
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data one - Crazy:");
        s1_a = g1_a.topologicalSort();
        while (s1_a.empty() == false)
            System.out.println(m1_a.get(s1_a.pop()));
        
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data one - Jacque:");
        
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data two - Num:");
        
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data two - Ord:");
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data three - Blimpy:");
    }
}