class Codec {
	
    public String serialize(Node root) {
        //前序遍历
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(1, sb.length() - 1);
    }

    //前序遍历
    private void helper(Node root, StringBuilder sb) {
        if(root==null){return;}
        sb.append("[");
        sb.append(root.val);
        if(root.children!=null){
            for(Node node:root.children){
                helper(node,sb);
            }
        }
        sb.append("]");
    }
	
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Stack<Node> stack = new Stack();
        for(int i=0;i<data.length();){
            if(data.charAt(i)>='0'&&data.charAt(i)<='9'){
                String temp = "";
                while(i<data.length()&&data.charAt(i)>='0'&&data.charAt(i)<='9'){
                    temp += data.charAt(i);
                    i++;
                }
                int cur = Integer.parseInt(temp);
                Node t = new Node(cur,new ArrayList<Node>());
                // 不为root节点
                if(!stack.isEmpty()){
                    Node par = stack.peek();
                    if(par.children==null){
                        par.children = new ArrayList<Node>();
                    }
                    par.children.add(t);
                }
                stack.push(t);
            }
            if(i<data.length()&&data.charAt(i)==']'){
                stack.pop();
            }
            i++;
        }
        if (stack.isEmpty()) return null;
        return stack.peek();
    }
}

/*

    //序列化：将二叉树前序遍历，每个子树由[]表示
    // 如题目中给出的示例序列化后变为：1[3[5][6]][2][4]
    // Encodes a tree to a single string.

    // 1[3[5][6]][2][4]
    // 创建一个Stack用来保存节点。遍历字符串，如果出现数字，则创建新节点，如果Stack不为空，则获取顶层元素，
    //加入顶层元素的child中，然后压栈。如果遇到']'则弹栈，直至遍历完字符串。树的元素没有负数，则不需要考虑别的情况。
*/
