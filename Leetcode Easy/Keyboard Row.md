# 500. Keyboard Row

Question desctiption:

Given a List of words, return the words that can be typed using letters of alphabet on only one row of American keyboard like the image below: ![Ta tea](https://leetcode.com/static/images/problemset/keyboard.png)
```
Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

```

## Things need
* #### C++
  * unordered_set<>
    * Unordered sets are containers that store unique elements in no particular order, and which allow for fast retrieval of individual elements based on their value.
  * tolower(c)
   * set all the char in current string c to lower case

# Code
* #### C++

```c++
class Solution {
public:
    vector<string> findWords(vector<string>& words) {
         unordered_set<char> row1{ 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
         unordered_set<char> row2{ 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' };
         unordered_set<char> row3{ 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
         // create set row with char member in the first/second/third row
         vector<unordered_set<char>> rows{ row1, row2, row3}; // create a set about the whole board

         vector<string> res;
         for(int i =0; i < words.size(); i++){//
             int row = 0;

             for (int k = 0; k < 3; k++){ // for each row
                if(rows[k].count((char)tolower(words[i][0])) > 0){
                    // for each words not empty, start to compare it with the row one by one
                    row = k; //set the current compare row as row_k
                }
             }
                res.push_back(words[i]);
                for(int j = 1; j < words[i].size(); ++j){  // for each words, check from start-to-end
                    if(rows[row].count((char)tolower(words[i][j]))==0){
                        res.pop_back();
                        break;
                    }
                }

         }
         return res;
    }
};
```
