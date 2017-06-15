# 606. Construct String from Binary Tree
## Description
```
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output
```
## Background information
* Tree Travel
  * Inorder : left-Root-right
    * Algorithm Inorder(tree)
      1. Traverse the left subtree, i.e., call Inorder(left-subtree)
      2. Visit the root.
      3. Traverse the right subtree, i.e., call Inorder(right-subtree)
  * Preorder : Root-left-right
    * Algorithm Preorder(tree)
      1. Visit the root.
      2. Traverse the left subtree, i.e., call Preorder(left-subtree)
      3. Traverse the right subtree, i.e., call Preorder(right-subtree)
  * Postorder : left-right-Root
    * Algorithm Postorder(tree)
      1. Traverse the left subtree, i.e., call Postorder(left-subtree)
      2. Traverse the right subtree, i.e., call Postorder(right-subtree)
      3. Visit the root.

## Code
```C++
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    string tree2str(TreeNode* t) {
        if (!t) return "";
        string s = to_string(t->val);

        if (t->left) {
            s += "(" + tree2str(t->left) + ")";
        }
        else if (t->right) {
            s += "()";
        }

        if (t->right) {
            s += "(" + tree2str(t->right) + ")";
        }

        return s;
    }
};
```
