package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Adjacency matrix
// it uses 1,0 to represent  edges
// number of rows and column is equal to the number of unique nodes
//run time complexity to check an edge is 0(1) and space complexity 0(v^2)
// DFS
//Pick a route, keep going
// if you reach a dead end or already visited node
// backtrack to the previous node which is unvisited

public class DfsTraversal {
    //Add headers
    ArrayList<Node> nodes;
    int[][] matrix; // 2D array of integer

    DfsTraversal(int size) {
        // instantiation
        nodes = new ArrayList<>();
        //size- amount of nodes
        matrix = new int[size][size];

    }

    //Traverse a graph level by level
    //utilizes queue
    //Better if destination is close to start
    //siblings are visited before children
    //src- index of the starting node
    //queue is initialized to store nodes that need to be processed during BFS
    //LinkedList is used to implement the queue
    //[] visited- is updated  to mark the starting node as visited

    public void breadthFirstSearch(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        //add index of starting node
        queue.offer(src);
//        updated  to mark the starting node as visited
        visited[src] = true;

        while (queue.size() != 0) {
//            It retrieves the next node from the queue, marks it as the current node (src),
//            processes it (displaying the node's data in this case), and then explores its neighbors.
            src = queue.poll();//assign source to whatever is at the front of the queue
            //display data  whenever we pull
            System.out.println(nodes.get(src).data + "=Visited");
            // matrix[src].length - length of row
            //it iterates through all the nodes connected to the current node in AdjM
            for (int i = 0; i < matrix[src].length; i++) {
//                checks if there is an edge between the current node (src) and node i
                if (matrix[src][i] == 1 && !visited[i]) {
//                    node i is added to the queue to be processed later in the BFS traversal.
                    queue.offer(i);
                    visited[i] = true;

                }
            }
        }


    }

    public void addNode(Node node) {
        nodes.add(node);

    }

    public void addEdge(int src, int dst) {
        //src-row dst-column
        matrix[src][dst] = 1;

    }

    public boolean checkEdge(int src, int dst) {
        if (matrix[src][dst] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.print("  ");
        //print header
        for (Node node : nodes) {
            System.out.print(node.data + " ");
        }
        System.out.println();
//        This outer loop iterates over each row of the adjacency matrix.
        for (int i = 0; i < matrix.length; i++) {
//            For each row, it prints the data of the corresponding
//            node (node with index i) as a row header before printing the adjacency matrix row.
            System.out.print(nodes.get(i).data + " ");
//            This inner loop iterates over each column in the current row of the adjacency matrix.
            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

    }


    //Traverse branch by branch
//    utilize stack
//    better if destination is far from the start
//    children are visited before siblings
//    more popular for games and puzzles
    public void depthFirstSearch(int src) {
        boolean[] visited = new boolean[matrix.length];
        //src, index of node where traversal begins
        //dfsHelper is a recursive method
        dfsHelper(src, visited);
    }

    private void dfsHelper(int src, boolean[] visited) {
        //check if current node is visited
        if (visited[src]) {
            return;//prevent infinite loops
        } else {
            visited[src] = true;
            System.out.println(nodes.get(src).data + "= visisted");
        }
//        After marking the current node as visited, the code
//        explores all unvisited neighbors of the current node
//        by making recursive calls to the dfsHelper method for
//        each unvisited neighbor. This process continues until all
//        reachable nodes from the starting node have been visited.
        //adjacency matrix, we loop
        //length of a row matrix[src].lengthx
        for (int i = 0; i < matrix[src].length; i++) {

            //src -row
            //i -column
            if (matrix[src][i] == 1) {
                dfsHelper(i, visited);
            }
        }
        return;


    }

    public static void main(String[] args) {
        DfsTraversal graph = new DfsTraversal(5);
        // add node
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        //add edge
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.print();

//        Check an edge
//        System.out.println(graph.checkEdge(0, 1));

//        DFS
//        graph.depthFirstSearch(4);
//        graph.breadthFirstSearch(0);

    }


}

class Node {
    char data;

    public Node(char data) {
        this.data = data;
    }
}
