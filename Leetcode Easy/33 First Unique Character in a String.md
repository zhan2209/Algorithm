# 387. First Unique Character in a String
## Description
```
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
```
## Background
* create a hashtable store all the char and how many time this letter in s
* search in s find the first char appear one time
* if not exist return -1

## Code
```c++
class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, int> hashtable;
        for(char ch : s){
            ++hashtable[ch];
        }
        int res = 0;
        for(int i = 0; i <s.size(); i++){
            if (hashtable[s[i]] == 1){
                return i;
            }
        }
        return -1;
    }
};
```
