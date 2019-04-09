# 231 Power of Two
## Description
```
Given an integer, write a function to determine if it is a power of two.
```
## Code
```c++

class Solution {
public:
    bool isPowerOfTwo(int n) {
        double tmp = n;
        if( n == 1) return true;
        while(tmp > 2){
           tmp /= 2.00;
        }
        if(tmp == 2.00){
            return true;
        }
        else{
            return false;
        }
    }
};
```
###### 2^31 = 2147483648;
```c++
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return (n > 0 && 2147483648 % n == 0);
    }
};
```
