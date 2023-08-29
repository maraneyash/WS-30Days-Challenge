import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int val;
    List<Node> neighbors;

    Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

public class DirectedGraphCycleDetection {
    public boolean hasCycle(Node node, int[] visited) {
        if (visited[node.val] == 1) {
            return true; // Visited and in the current traversal path
        }

        if (visited[node.val] == 2) {
            return false; // Already visited and not in the current traversal path
        }

        visited[node.val] = 1; // Mark as visited in the current traversal path

        for (Node neighbor : node.neighbors) {
            if (hasCycle(neighbor, visited)) {
                return true; // Cycle detected in neighbor's traversal
            }
        }

        visited[node.val] = 2; // Mark as visited and not in current traversal path
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the graph: ");
        int numNodes = scanner.nextInt();
        
        Node[] nodes = new Node[numNodes];
        for (int i = 0; i < numNodes; i++) {
            nodes[i] = new Node(i);
        }

        System.out.print("Enter the number of directed edges: ");
        int numEdges = scanner.nextInt();
        System.out.println("Enter the directed edges (source destination):");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            nodes[source].neighbors.add(nodes[destination]);
        }

        DirectedGraphCycleDetection detector = new DirectedGraphCycleDetection();
        int[] visited = new int[numNodes];
        
        boolean hasCycle = false;
        for (int i = 0; i < numNodes; i++) {
            if (visited[i] == 0 && detector.hasCycle(nodes[i], visited)) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }

        scanner.close();
    }
}
