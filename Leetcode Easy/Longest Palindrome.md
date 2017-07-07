# 409. Longest Palindrome
## Description
```
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
```

## Background
* Create a hashtable store all the char and the corresponding times it appears
* check hashtable for each char,
  * if the number of the char can divided by 2, which means it can be Palindrome
    * so add the number to res and set the original val to 0
  * if the number can not divided by 2
    * if it is 3,5,7,9 which is larger than 2 then add 2 to res until it's 1
  * if at the end, the hashtable still has some char, we can get any 1 char in the middle of the Palindrome
## Code
```c++
class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> hashtable;
        for(char ch: s){
            ++hashtable[ch];
        } // end of create hash table
        if(hashtable.size() == 1) // if only 1 char in such as "ccc" or "sssss"
          return s.size();  // the size of s is the longestPalindrome

        int res = 0;
        int n = s.size();

        for(int i = 0; i < n; i++){
            if(hashtable[s[i]] % 2 == 0){
                res += hashtable[s[i]] ;
                hashtable[s[i]] = 0;
            }
            else{
                while(hashtable[s[i]] >2){
                    res += 2;
                    hashtable[s[i]] -= 2;
                }
            }
        }
        return n > res? res+1 : res;
    }
};
```
