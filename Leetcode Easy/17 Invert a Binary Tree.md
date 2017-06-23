#  226. Invert Binary Tree

## Description
```
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

## Background information
* swap(LeftTree, RightTree)
* For the tree problem,
   * use recursive
      * 递归是一个树结构，每个分支都探究到最远，发现无法继续的时候往回走每个节点只会访问一次
      * 迭代是一个环结构，每次迭代都是一个圈，不会拉掉其中的某一步，然后不断循环每个节点都会被循环访问
* [iterative and recursive](http://www.advanced-ict.info/programming/recursion.html)

* [iterative and recursive](http://www.cs.cornell.edu/info/courses/spring-98/cs211/lecturenotes/07-recursion.pdf)
  * recursive: 递归是在函数内部调用自身
  * iterative: 迭代是更新变量的旧值
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
    TreeNode* invertTree(TreeNode* root) {
        if (root != NULL){
            invertTree(root->left);
            invertTree(root->right);
            swap(root->left, root->right);
        }
        return root;
    }
};

```
