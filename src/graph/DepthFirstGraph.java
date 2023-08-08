package graph;

import java.util.List;
import java.util.Stack;

public class DepthFirstGraph {
    private List<Node> nodes;
    private int[][] matrix;

    public DepthFirstGraph(List<Node> nodes, int[][] matrix) {
        this.nodes = nodes;
        this.matrix = matrix;
    }
    public void depthFirstSearch(int src) {
        boolean[] visited = new boolean[matrix.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(src);
        visited[src] = true;

        //start traversal
        while (!stack.isEmpty()) {
            //The top element of the stack is popped and assigned to
            // the variable current. This represents the current node
            // being processed. Since we are using a stack, the nodes
            // are processed in the reverse order of insertion.
            int current = stack.pop();
            System.out.println(nodes.get(current).data + "=Visited");

            for (int neighbor = 0; neighbor < matrix[current].length; neighbor++) {
                if (matrix[current][neighbor] == 1 && !visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
