package graph;

import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        An array to keep track of the in-degrees of courses.
//        In-degree refers to the number of prerequisites a course has.
        int[] indegree = new int[numCourses];
//        A map where the keys are prerequisites and the values
//        are sets of courses that depend on those prerequisites.
        Map<Integer, Set<Integer>> map = new HashMap<>();
//        Loop through the array of prerequisites.
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
//            Increment the in-degree of the course because it has a new prerequisite.
            indegree[course]++;
//            Add the course as a dependent of the prereq in the map. If the prereq is not already
//            a key in the map, it's added with an empty set, and then the course is added to that set.
            map.computeIfAbsent(prereq, k -> new HashSet<>()).add(course);
        }
//        perform BFS for topological sorting
        Queue<Integer> queue = new LinkedList<>();
//        keep track of courses that have been visited.
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
//            it has no prerequisites
            if (indegree[i] == 0) {
                queue.add(i);
                visited.add(i);
            }
        }

        while (!queue.isEmpty()) {
//            Remove a course from the queue
            int removed = queue.remove();
//            Loop through all courses that depend on the removed course
//            (removed), or an empty set if the course has no dependents.
            for (Integer conn : map.getOrDefault(removed, new HashSet<>())) {
                indegree[conn]--;
                if (indegree[conn] == 0) {
                    queue.add(conn);
                    visited.add(conn);
                }
            }
        }
        return visited.size() == numCourses;
    }
}