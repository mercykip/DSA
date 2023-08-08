package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    //TimeComplexity 0(n) where n is the number of nodes
    //    Space Coplexity 0(n)
    public NodeClone cloneGraph(NodeClone node) {
        //check if input node is null
        if (node == null) {
            return null;
        }
        //initialize a hashmap  to keep track of nodes that have already been cloned
        Map<Integer, NodeClone> map = new HashMap<>();
        //delegates the actual cloning
        return cloneGraph(node, map);
    }

    //    its a recursive method used for cloning each node and its neighbor

    public NodeClone cloneGraph(NodeClone node, Map<Integer, NodeClone> map) {
        //map keeps track of cloned nodes. This ensures that if a node has already
        // been cloned, the same clone is returned instead of creating a duplicate.
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
//        If the node has not been cloned yet, it creates a new NodeClone
//        instance with the same val and adds it to the map
        NodeClone clone = new NodeClone(node.val);
        map.put(node.val, clone);
//        Then, it recursively clones all the neighbors of the current node by calling cloneGraph
//        on each neighbor and adds them to the neighbors list of the cloned node.
        for (NodeClone neighbor : node.neighbors)
            clone.neighbors.add(cloneGraph(neighbor, map));
//        Once all neighbors have been cloned and added to the cloned node, it returns the cloned node.
        return clone;

    }


}

class NodeClone {
    int val;
    List<NodeClone> neighbors;

    public NodeClone(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public NodeClone(int val, ArrayList<NodeClone> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
