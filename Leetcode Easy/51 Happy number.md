# 202 Happy number
## Description
```
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
```

## Background
1. check sum
2. check this sum is already exit or not
    1. if exit, return false
    2. check new sum

3. find()
    1. <u>find(list.begin(), list.end(), x) != list.end();</u>
        1. if x in list, return true
        2. else return the end of list
## Code

```c++
class Solution {
public:
    bool isHappy(int n) {
        if (n == 1) return true;   

        unordered_set<int> tmp = {0,n};
        int res = testHappy(n);

        while(res != 1){
            if( find(tmp.begin(), tmp.end(), res) != tmp.end()){ // cout<< "end: "<< res << endl;
                return false;
            }
            else{
                tmp.insert(res); // cout<< res << endl;
                res = testHappy(testHappy(res)); //res = testHappy(res);
            }   
        }

        if(res == 1){
           // cout<< "end: "<< res << endl;
           return true;
        }

        return false;
    }

    int testHappy(int n){
        int total = 0;
        while( n/10 != 0){           
            total += (n%10) * (n%10);
            n = n/10;
        }
        total += n*n;
        return total;
    }
};
```
