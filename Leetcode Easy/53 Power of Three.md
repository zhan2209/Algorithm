# 326. Power of Three

## Description
```
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
```

## Code
```c++
class Solution {
public:
    bool isPowerOfThree(int n) {
        double tmp = n;
        if( n == 1) return true;
        while(tmp > 3){
           tmp /= 3.00;
        }
        if(tmp == 3.00){
            return true;
        }
        else{
            return false;
        }
    }
};
```
###### 3^19 = 1162261467;
```c++
class Solution {
public:
    bool isPowerOfThree(int n) {
         return (n > 0 && 1162261467 % n == 0);
    }
};
```
