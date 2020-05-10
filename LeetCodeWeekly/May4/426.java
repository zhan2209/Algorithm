/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return root;
        
        Stack<Node> stack = new Stack<>();
        Node pre = new Node(0,null,null);
        Node res = pre;
        
        while(root != null || !stack.isEmpty())
        {
            if(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                root = stack.pop();
                pre.right = root;
                root.left = pre;
                pre = root;
                root = root.right;
            }
        }
        pre.right = res.right;
        res.right.left = pre;
        
        return res.right;
        
    }
}