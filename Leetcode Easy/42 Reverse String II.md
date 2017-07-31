# 541. Reverse String II
## Description
```
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
```

# Code
```c++
class Solution {
public:
    string reverseStr(string s, int k) {
        for(int n = 0; n*k < s.size(); n++){
            if(n%2 == 0){
                int start = n * k;
                int end =  n*k +k -1 > s.size()-1 ? s.size()-1 : n*k +k -1 ;
                for(int count = 0; count < k/2 && (end-count > start+count); count++){
                    swap(s[start + count], s[ end-count]);                  
                }
            }
        }
        return s;
    }
};
```
