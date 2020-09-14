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
    public Node cloneTree(Node root) {
        if(root==null){
            return null;
        }
        Node res = new Node(root.val,new ArrayList<Node>());
        visit(root,res);
        return res;
    }
    private void visit(Node n1,Node n2){
        if(n1==null){
            return;
        }
        for(int i=0;i<n1.children.size();i++){
            Node temp = new Node(n1.children.get(i).val,new ArrayList<Node>());
            n2.children.add(temp);
            visit(n1.children.get(i),temp);
        }
    }
}