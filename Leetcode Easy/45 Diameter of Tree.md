# 543. Diameter of Binary Tree
## Description
```
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

```
## Code
```c++
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
    int diameterOfBinaryTree(TreeNode* root) {
        if(root == NULL) return 0;
        int res = 0;
        maxDepth(root, res);
        return res;
    }

    int maxDepth(TreeNode* root, int& res){
        if(root == NULL) return 0;
        int left = maxDepth(root->left, res);
        int right = maxDepth(root->right, res);
        res = max(left+right, res);
        return max(right,left) +1;
    }
};
```
