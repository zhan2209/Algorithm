# 168. Excel Sheet Column Title
## Description
```
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
```
## Background
* keep divide 26 until result is less than 1
  * if remainder is 0 which means it should be 'Z'
  * at the same time, n = n-26 as a new n value
* reverse the whole string at the end
 
## Code
```c++
class Solution {
public:
    string convertToTitle(int n) {
        vector<int> remainder;
        string res = "";
        while(n > 0){
            if(n%26 ==0){
                res.push_back('Z');
                n = n-26;
                n = n/26;
            }
            else{
                res.push_back(n%26 -1 + 'A');
                n = n/26;
            }
        }
        reverse(res.begin(),res.end());
        return res;
    }
};
```
