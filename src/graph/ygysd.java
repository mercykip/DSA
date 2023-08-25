package graph;

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list representation of the graph
        // List<List<Integer>> adjList = new ArrayList<>();
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();

        }
        // Populate the adjacency list with prerequisites
        for (int[] prerequisite : prerequisites) {
            // adjList.get(prerequisite[1]).add(prerequisite[0]);
            adjList[prerequisite[1]].add(prerequisite[0]);
        }

        // Initialize arrays to track the visited nodes and the course order
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean[] inStack = new boolean[numCourses];

        // Perform depth-first search (DFS) to perform topological sorting
        for(int i=0; i< numCourses; i++){
            //if node is not visited
            if(!visited[i] && hasCycle(adjList,i, visited,inStack, stack)){
                // If a cycle is detected, return an empty array
                return new int[0];
            }
        }

        // Convert the stack to an array representing the order of courses
        //It starts from the last index (highest value) and goes down index 0.
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = stack.pop();
        }
        return order;
    }

    boolean hasCycle(List<Integer>[] adj, int course, boolean[]visited, boolean[] inStack, Stack<Integer> stack){
        //check if course is visisted
        if(visited[course]){
            return false; //detect a cyscle
        }
        // if not visited
        visited[course]=true;
        inStack[course] = true;
        // traverse through the list of neighbours for the current course
        for (int neighbor : adj[course]) {
            //Call dfs recursively for each neighbour
            if (!visited[neighbor]) {
                if (hasCycle(adj, neighbor, visited, inStack, stack)) {
                    return true;
                }
            } else if (inStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        stack.push(course);
        visited[course] = false; // Reset the visited flag for backtracking
        inStack[course] = false;
        return true;

    }
}
