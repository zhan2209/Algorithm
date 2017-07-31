
# 551. Student Attendance Record I
## Description
```
You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True

Example 2:
Input: "PPALLL"
Output: False
```
## Code
```c++
class Solution {
public:
    bool checkRecord(string s) {
        int flagA = 0, flagL = 0, flagP = 0;
        for(char ch : s){

            if(ch == 'A'){
                flagA++;
                flagL = 0;
                if(flagA > 1) return false;
            }
            else if(ch == 'P'){
                flagL = 0;
            }
            else{
                flagL++;
                if(flagL > 2) return false;
            }

        }

        return true;
    }
};
```
