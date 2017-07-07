# 383. Ransom Note
## Description
```
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
```
## Background
* Hash table
  *  unordered_map<char, int> hash_table(size);
    * char as the key-- can locate element by key
    * int as the value -- changeable
 * ++hash_table["a"]
   * add one to the value which the key is "a"

## Code
```c++
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char, int> hash_table(26);
        for(int i = 0; i < magazine.size(); i++){
              ++hash_table[magazine[i]]; // magazine[i] as the key
        }
        for(int i = 0; i < ransomNote.size(); i++){
            if(--hash_table[ransomNote[i]] < 0){
                return false;
            }
        }
        /*
        for (char c : magazine) ++m[c];
        for (char c : ransomNote) {
            if (--m[c] < 0) return false;
        }
        */
        return true;
    }
};
```
