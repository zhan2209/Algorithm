# 657. Judge Route Circle
## Description
```
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
```
## Background

* To detect the robot move back to the original position or not
  * in L-R move, the total is 0 if move back
  * in U-D move, the total is 0 if move back

* unordered_map<char, int> table(size);
  * char as search key
  * int as calaulate number

## code
```c++
class Solution {
public:
    bool judgeCircle(string moves) {
        unordered_map <char, int> hashtable(4);
        for(int i = 0; i < moves.size(); i++){
            moves[i] == 'U' ? ++hashtable['U']: hashtable['U'] ;
            moves[i] == 'L' ? ++hashtable['L']: hashtable['L'] ;
            moves[i] == 'D' ? --hashtable['D']: hashtable['D'] ;
            moves[i] == 'R' ? --hashtable['R']: hashtable['R'] ;
        }
        if(hashtable['U'] + hashtable['D'] == 0
           && hashtable['R'] + hashtable['L'] == 0  ){
            return true;
        }
        else{
         return false;
        }
    }
};
```
