# 669. Trim a Binary Search Tree
## Description
```
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input:
    1
   / \
  0   2

  L = 1
  R = 2

Output:
    1
      \
       2

Example 2:
Input:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output:
      3
     /
   2   
  /
 1
```
## Background
* Binary Search Tree/ Ordered Binary Tree/ Sorted Binary Tree
  * Definition
    * if root->left != null, root->left->children->val < root->val
    * if root->right != null, root->right->children->val > root->val
    * root->left and root->right are all Binary Search Tree
    * root->val != any root->childre->val

  * Create, Delete, Search/O(log n), Insert/O(log n), Update, Travel

    * Delete(p, root) / Travel
       * if (p->left == null && p->right == null), delete p, set p.parents -> NEXT = null
       * if (p->left == null && p->right != null) or (p->left != null && p->right == null),
            set p.parent->next = p->next
       * if (p->left != null && p->right != null), delete p, then in-order traversal update the tree
       ```c++
        TravelBinaryTree(nodeVal, root){
          if(!root) return;
          TravelBinaryTree(nodeVal, root->left);
          printout(nodeVal);
          TravelBinaryTree(nodeVal, root->right);
        }
       ```
    * Search(x, root)
        * if root == null, return false; else
        * if x = root->val return true, else
        * if x < root, search(x, root->left), else
        * search(x, root->right)
        ```c++
        search(binarytree T, key x){
          if(!T) return false;
          else if(x == T->val){ return true;}
          else if(x < T->val) { return search(t->left,x);}
          else if(x > T->val) { return search(t->right, x)}
        }
        ```
    * Insert(x, root)
      * if root == null, Insert x as root; else
      * if x =  root->val, return; else
      * if x < root->val, return insert(x, root->left); else
      * if x > root->val, return insert(x, root->right)
      ```c++
      insert(x, root){
         if(!root){ s = newNode(x); root = s}
        else if(x == root->val) return false;
        else if(x < root->val) return insert(x, root->left);
        else if(x > root->val) return insert(x, root->right);
      }
      ```

* Algorithm
    * find L, delete all L->left (all element less than L)
    * find R, delete all R->right (all element larger than R)
    * update

## Code
```C++

```
