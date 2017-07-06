# 242. Valid Anagram
## Description
```
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
```

## Background
* Hash table -- the same as 33 (or #387 in leetcode)
  * Check s and t are exactly the same or not (include both null)
  * Check s and t are the same length or not, if not same length, must be false
  * check all the char in s is in t
  * Check no extra char in s than t


## Code
```c++
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s == t) return true;
        if(s.size() != t.size()) return false;

        unordered_map<char, int> hashtable;

        for(char ch : t){
            ++hashtable[ch];
        }

        for(char ch : s){
            if(hashtable[ch] == 0 ){
                return false;
            }
            else{
                hashtable[ch]--;
            }
        }
        return true;
    }
};
```
