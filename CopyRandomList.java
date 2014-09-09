/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> visited = new HashMap<RandomListNode, RandomListNode>();
        return copyRandomListHelper(head, visited);
    }
    
    public RandomListNode copyRandomListHelper(RandomListNode node, Map<RandomListNode, RandomListNode> visited) {
        if (node == null)
            return null;
        if (visited.containsKey(node))
            return visited.get(node);
        
        RandomListNode newNode = new RandomListNode(node.label);
        visited.put(node, newNode);
        newNode.next = copyRandomListHelper(node.next, visited);
        newNode.random = copyRandomListHelper(node.random, visited);
        return newNode;
    }
}