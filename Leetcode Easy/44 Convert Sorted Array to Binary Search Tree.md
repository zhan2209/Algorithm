# 108. Convert Sorted Array to Binary Search Tree

## Description
```
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
```

## Background
* Create a new TreeNode with values
  * TreeNode * newNode = new TreeNode(value)

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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
       return  ArrayToTree(nums,0, nums.size() -1);
    }
    TreeNode* ArrayToTree(vector<int>& nums, int start, int end){
        if(start > end) return NULL;
        int mid = (end + start)/2;
        TreeNode* cur = new TreeNode(nums[mid]);
        cur->left = ArrayToTree(nums, start , mid -1);
        cur->right = ArrayToTree(nums, mid + 1, end);

        return cur;
    }
};
```
