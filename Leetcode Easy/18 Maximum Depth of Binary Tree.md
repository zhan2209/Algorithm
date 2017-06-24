#  104. Maximum Depth of Binary Tree

## Description
```
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
```
## Background

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
    int maxDepth(TreeNode* root) {
        int ldeep = 0, rdeep = 0;
        if(root != NULL){
            ldeep = maxDepth(root->left) +1;
            rdeep = maxDepth(root->right) +1;
        }
        return max(ldeep,rdeep) ;
    }
};
```
