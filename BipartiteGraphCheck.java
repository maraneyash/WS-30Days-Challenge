import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraphCheck {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: Not colored, 1: Red, -1: Blue
        
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // Color the start vertex as Red
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            
            for (int neighbor : graph[vertex]) {
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[vertex]; // Assign opposite color to the neighbor
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[vertex]) {
                    return false; // Same color found, not bipartite
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();
        
        int[][] graph = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number of neighbors for vertex " + i + ": ");
            int numNeighbors = scanner.nextInt();
            
            graph[i] = new int[numNeighbors];
            System.out.print("Enter the neighbors of vertex " + i + ": ");
            for (int j = 0; j < numNeighbors; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        
        BipartiteGraphCheck checker = new BipartiteGraphCheck();
        if (checker.isBipartite(graph)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
        
        scanner.close();
    }
}
