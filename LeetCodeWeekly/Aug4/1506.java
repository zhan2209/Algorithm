/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


class Solution {
    public Node findRoot(List<Node> tree) {
        Map<Node, Integer> map = new HashMap<>();
        Node ans = null;
        for(Node node : tree) {
            map.put(node, 0);
        }
        for(Node node : tree) {
            for(Node v : node.children) {
                int cnt = map.getOrDefault(v, 0);
                map.put(v, cnt + 1);
            }
        }
        for(Map.Entry<Node, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 0) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }
}