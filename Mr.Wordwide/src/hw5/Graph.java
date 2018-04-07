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
        
        Graph g1_b = new Graph(7);
        Map m1_b = new HashMap();
        Stack s1_b;
        m1_b.put(0, "Jacque");
        m1_b.put(1, "Weightlifters");
        m1_b.put(2, "Shotputters");
        m1_b.put(3, "Athletes");
        m1_b.put(4, "Endomorphs");
        m1_b.put(5, "Dwarfs");
        m1_b.put(6, "Everything");

        g1_b.addEdge(0, 1);
        g1_b.addEdge(0, 2);
        g1_b.addEdge(0, 3);
        g1_b.addEdge(1, 3);
        g1_b.addEdge(1, 4);
        g1_b.addEdge(2, 3);
        g1_b.addEdge(2, 4);
        g1_b.addEdge(3, 5);
        g1_b.addEdge(4, 5);
        g1_b.addEdge(5, 6);
        
        Graph g2_a = new Graph(7);
        Map m2_a = new HashMap();
        Stack s2_a;
        m2_a.put(0, "Num");
        m2_a.put(1, "Fractional");
        m2_a.put(2, "Real");
        //m2_a.put(3, "Enum");
        m2_a.put(3, "Floating");
        m2_a.put(4, "RealFrac");
        m2_a.put(5, "Integral");
        m2_a.put(6, "RealFloat");
        
        g2_a.addEdge(0, 1);
        g2_a.addEdge(0, 2);
        g2_a.addEdge(1, 3);
        g2_a.addEdge(1, 4);
        g2_a.addEdge(2, 4);
        g2_a.addEdge(2, 5);
        //g2_a.addEdge(3, 6);
        g2_a.addEdge(3, 6);
        g2_a.addEdge(4, 6);
        
        Graph g2_b = new Graph(5);
        Map m2_b = new HashMap();
        Stack s2_b;
        m2_b.put(0, "Ord");
        m2_b.put(1, "Real");
        m2_b.put(2, "RealFrac");
        m2_b.put(3, "Integral");
        m2_b.put(4, "RealFloat");
        
        g2_b.addEdge(0, 1);
        g2_b.addEdge(1, 2);
        g2_b.addEdge(1, 3);
        g2_b.addEdge(2, 4);
        
        Graph g3 = new Graph(7);
        Map m3 = new HashMap();
        Stack s3;
        m3.put(0, "Blimpy");
        m3.put(1, "Managers");
        m3.put(2, "Gourmands");
        m3.put(3, "Diarists");
        m3.put(4, "Competitors");
        m3.put(5, "Dwarfs");
        m3.put(6, "Everything");
 
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(0, 3);
        g3.addEdge(1, 4);
        g3.addEdge(4, 5);
        g3.addEdge(2, 5);
        g3.addEdge(3, 5);
        g3.addEdge(5, 6); 
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data one - Crazy:");
        s1_a = g1_a.topologicalSort();
        while (s1_a.empty() == false)
            System.out.println(m1_a.get(s1_a.pop()));
        
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data one - Jacque:");
        s1_b = g1_b.topologicalSort();
        while (s1_b.empty() == false)
            System.out.println(m1_b.get(s1_b.pop()));
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data two - Num:");
        s2_a = g2_a.topologicalSort();
        while (s2_a.empty() == false)
            System.out.println(m2_a.get(s2_a.pop()));
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data two - Ord:");
        
        s2_b = g2_b.topologicalSort();
        while (s2_b.empty() == false)
            System.out.println(m2_b.get(s2_b.pop()));
        
        System.out.println("-------------------------------------------------");
        System.out.println("Following is a Topological " +
                           "sort of the test data three - Blimpy:");
        
        s3 = g3.topologicalSort();
        while(s3.empty() == false)
            System.out.println(m3.get(s3.pop()));
    }
}