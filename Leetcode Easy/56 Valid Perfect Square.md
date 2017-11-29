# 367 Valid Perfect Square
## Description
```
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
    Input: 16
    Returns: True
Example 2:
    Input: 14
    Returns: False
```
## Code
```c++
class Solution {
public:
    bool isPerfectSquare(int num) {
        if(num < 2 && num >=0 ) return true;
        for(int i = 1; i <= num/2 ; i++){
            if(num - i*i == 0) return true;
        }
        return false;
    }
};
```
<b> too slow</b>

```c++
class Solution {
public:
    bool isPerfectSquare(int num) {
        if (num == 1) return true;
        long x = num / 2, t = x * x;
        while (t > num) {
            x /= 2;
            t = x * x;
        }
        for (int i = x; i <= 2 * x; ++i) {
            if (i * i == num) return true;
        }
        return false;
    }
};
```
