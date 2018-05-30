import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Shahbaz on 2/13/2018.
 */
public class GraphImpl {
    public static void main(String[] args) {
        int V = 8;
        Graph graph = new Graph(V);
        /*graph.addEdge(graph,0,1);
        graph.addEdge(graph,0,4);
        graph.addEdge(graph,1,2);
        graph.addEdge(graph,1,3);
        graph.addEdge(graph,1,4);
        graph.addEdge(graph,2,3);
        graph.addEdge(graph,3,4);*/
        graph.addEdge(graph,0,1);
        graph.addEdge(graph,0,3);
        graph.addEdge(graph,0,6);
        graph.addEdge(graph,1,4);
        graph.addEdge(graph,1,5);
        graph.addEdge(graph,2,7);
        graph.addEdge(graph,2,5);
        graph.addEdge(graph,3,5);
        graph.addEdge(graph,4,6);
        /*graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);*/
       /* graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);*/
        graph.printGraph(graph);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 0)");
        graph.BFS(0);

        System.out.println();

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 1)");
        graph.DFS(1);
    }
}

class Graph{

    int V;

    LinkedList<Integer> adjListArray[];

    Graph(int V){
        this.V = V;
        adjListArray = new LinkedList[V];
        for(int i=0;i<V;i++){
            adjListArray[i] = new LinkedList<>();
        }
    }
    //for undirected graph
    void addEdge(Graph graph,int source, int destination){
        graph.adjListArray[source].add(destination);
        // comment out the below statement to create an undirected graph
        graph.adjListArray[destination].add(source);
    }

    /*//for directed graph
    void addEdge(int v,int w)
    {
        adjListArray[v].add(w);
    }*/

    void printGraph(Graph graph){
        for(int v=0;v < graph.V;v++){
            System.out.println("Adjacent List of vertex " + v);
            System.out.print("Head");
            for(int node : graph.adjListArray[v]){
                System.out.print("->" + node);
            }
            System.out.println();
        }
    }


    void BFS(int source){
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while(queue.size()!=0){
            source =queue.poll();
            System.out.print(source + " ");
            Iterator<Integer> itr = adjListArray[source].listIterator();
            while(itr.hasNext()){
                int n = itr.next();
                if(visited[n]==false){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    void DFS(int source){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack();
        DFSUtil(source,stack, visited);
    }

    void DFSUtil(int source,Stack<Integer> stack, boolean visited[]){
        System.out.print(source+" ");
        stack.push(source);
        visited[source] = true;
        while (!stack.isEmpty()){
            int top = stack.pop();
            Iterator<Integer> itr = adjListArray[top].iterator();
            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    DFSUtil(n,stack,visited);
                }
            }
        }
    }
}
