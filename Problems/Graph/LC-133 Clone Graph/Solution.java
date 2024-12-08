/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        HashMap<Integer, Node> hm = new HashMap<>();
        Node clNode = new Node(node.val);
        hm.put(node.val, clNode);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            Node clone = hm.get(n.val);

            for (Node c : n.neighbors) {
                Node clc = hm.getOrDefault(c.val, new Node(c.val));
                clone.neighbors.add(clc);
                if (!hm.containsKey(clc.val)) {
                    hm.put(clc.val, clc);
                    q.add(c);
                }

            }

        }
        return clNode;
    }
}