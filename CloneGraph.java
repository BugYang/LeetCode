/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneGraphHelper(node, visited);
    }
    
    public UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> visited) {
        if (node == null)
            return null;
        if (visited.containsKey(node))
            return visited.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(node, newNode);
        newNode.neighbors = new ArrayList<UndirectedGraphNode>();
        for (UndirectedGraphNode neighbor : node.neighbors)
            newNode.neighbors.add(cloneGraphHelper(neighbor, visited));
        return newNode;
    }
}