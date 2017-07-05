# 171. Excel Sheet Column Number
## Description
```
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
```
## Background
* change a number 26-decimal to 10-decimal
* number1* 26^EXP + number2* 26^(EXP-1) + ...+ number(n-1)\*26^1 + number_n
* Calculate power
  * pow(base, exp);

| A | B |............. |H | S |.......| C | D |
| --- | --- | --- | --- | --- | --- | --- | --- |
|(ASCII-A) *26^EXP_length|(ASCII-B) *26^EXP_length-1|EXP--|(ASCII-H) *26^EXP|(ASCII-S)* 26^EXP|...|(ASCII-C) *26^1|(ASCII-D) *26^0|


## Code
```c++
class Solution {
public:
    int titleToNumber(string s) {
        int res = 0;
        int fac = 0;
        for(int i = s.size()- 1; i >= 0; i--){
            res += (s[i] - 'A' + 1) * (pow(26,fac++));
        }
        return res;
    }
};

```
