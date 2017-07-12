#  206. Reverse Linked List
## Description
```
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
```

## Background
* Recur­sive Approach:
  * Take 3 nodes as Node ptrOne,Node ptrTwo, Node prevNode
  * Initialize them as ptrOne = head; ptrTwo=head.next, prevNode = null.
  * Call reverseRecursion(head,head.next,null)
  * Reverse the ptrOne and ptrTwo
  * Make a recursive call for reverseRecursion(ptrOne.next,ptrTwo.next,null)

* Iter­a­tive:
  * Cre­ate 3 nodes, cur­rN­ode, Pre­vN­ode and nextNode.
  * Ini­tial­ize them as cur­rN­ode = head; nextN­ode = null;pre­vN­ode = null;
  * Now keep revers­ing the point­ers one by one till currNode!=null.

## Code
```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/* Iterative:
 Create 3 nodes, currNode, PrevNode and nextNode.
 Initialize them as currNode = head; nextNode = null;prevNode = null;
 Now keep reversing the pointers one by one till currNode!=null.
*/
 //Iterative
 class Solution {
 public:
     ListNode* reverseList(ListNode* head) {
         if(head == NULL) return head;

         ListNode* curNode = head;
         ListNode* nextNode = NULL;
         ListNode* preNode = NULL;

         while(curNode->next != NULL){
          nextNode = curNode->next;
          curNode->next = preNode;
          preNode = curNode;
          curNode = nextNode;
         }

         curNode->next = preNode;  
         return curNode;

     }
 };
```
```
/*
Recursive Approach:

Take 3 nodes as Node ptrOne,Node ptrTwo, Node prevNode
Initialize them as ptrOne = head; ptrTwo=head.next, prevNode = null.
Call reverseRecursion(head,head.next,null)
Reverse the ptrOne and ptrTwo
Make a recursive call for reverseRecursion(ptrOne.next,ptrTwo.next,null)
*/
```
```c++
//Recursive
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(! head || !head->next) return head;

        ListNode *pre = head;
        head = reverseList(pre->next);
        pre->next->next = pre;
        pre->next = NULL;
        return head;
    }
};
```
