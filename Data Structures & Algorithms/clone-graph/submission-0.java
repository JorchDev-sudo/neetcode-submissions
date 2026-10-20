/*
Definition for a Node.
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
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        return dfs(node.neighbors, node);
    }

    public Node dfs (List<Node> neighbors, Node root) {
        if (root == null) return null;
        if (visited.containsKey(root)) return visited.get(root);

        Node cur = new Node(root.val);
        visited.put(root, cur);

        for (Node neighbor : neighbors) {
            if (visited.containsKey(neighbor)){
                Node n = visited.get(neighbor);
                cur.neighbors.add(n);
                continue;
            }

            Node copy = dfs(neighbor.neighbors, neighbor);
            cur.neighbors.add(copy);
        }

        return cur;
    }
}