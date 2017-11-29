# 633. Sum of Square
## Description
```
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
    Input: 5
    Output: True
    Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
    Input: 3
    Output: False
```
## Code
```c++
class Solution {
public:
    bool judgeSquareSum(int c) {
        if(c <= 2) return true;
        for(int a = 0; a < sqrt(c); a++ ){
         int tmp =  c - a * a;
         int  b = sqrt(tmp);           
         if( tmp == 0){return true;}
         if( b * b == tmp){return true;}
        }
        return false;
    }
};
```
