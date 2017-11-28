# 342 Power of Four
## Description
```
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
```

## Code
```c++
class Solution {
public:
    bool isPowerOfFour(int n) {
        double tmp = n;
        if( n == 1) return true;
        while(tmp > 4){
           tmp /= 4.00;
        }
        if(tmp == 4.00){
            return true;
        }
        else{
            return false;
        }
    }
};
```
##### For all the power of four number, after -1, it can be divided by 3 with reminder 0
```c++
class Solution {
public:
    bool isPowerOfFour(int num) {
        return num > 0 && !(num & (num - 1)) && (num - 1) % 3 == 0;
    }
};
```
