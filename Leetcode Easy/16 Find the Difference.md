#
## Description
```
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.

```
## Background information
* for( char a : t)
* for( int i = 0; i <length; i++)
  * for each element in target string

## Code  
```c++
class Solution {
public:
    char findTheDifference(string s, string t) {
        char res = 0;
        for(int i = 0; i < s.size(); i++){
            res ^= s[i];
        }
        for(char a : t){
            res ^= a;
        }
        return res;
    }
};
```
