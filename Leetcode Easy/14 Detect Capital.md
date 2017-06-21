# 520 Detect Capital
## Description
```
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:
Input: "USA"
Output: True

Example 2:
Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
```
## Background Information
 * [Letter'e ASCII Value](http://sticksandstones.kstrom.com/appen.html)


 Letter	| ASCII |	Binary	 |-| Letter	  | ASCII 	 | Binary
 -------|-------|----------|-|----------|----------|-------
 a	|097 | 01100001	|-|A | 065 | 01000001
 b | 098 | 01100010	|-|B | 066 | 01000010
 c | 099 | 01100011	|-|C | 067 | 01000011
 d | 100 | 01100100	|-|D | 068 | 01000100
 e | 101 | 01100101	|-|E | 069 | 01000101
 f | 102 | 01100110	|-|F | 070 | 01000110
 g | 103 | 01100111	|-|G | 071 | 01000111
 h | 104 | 01101000	|-|H | 072 | 01001000
 i | 105 | 01101001	|-|I | 073 | 01001001
 j | 106 | 01101010	|-|J | 074 | 01001010
 k | 107 | 01101011	|-|K | 075 | 01001011
 l | 108 | 01101100	|-|L | 076 | 01001100
 m | 109 | 01101101	|-|M | 077 | 01001101
 n | 110 | 01101110	|-|N | 078 | 01001110
 o | 111 | 01101111	|-|O | 079 | 01001111
 p | 112 | 01110000	|-|P | 080 | 01010000
 q | 113 | 01110001	|-|Q | 081 | 01010001
 r | 114 | 01110010	|-|R | 082 | 01010010
 s | 115 | 01110011	|-|S | 083 | 01010011
 t | 116 | 01110100	|-|T | 084 | 01010100
 u | 117 | 01110101	|-|U | 085 | 01010101
 v | 118 | 01110110	|-|V | 086 | 01010110
 w | 119 | 01110111	|-|W | 087 | 01010111
 x | 120 | 01111000	|-|X | 088 | 01011000
 y | 121 | 01111001	|-|Y | 089 | 01011001
 z | 122 | 01111010	|-|Z | 090 | 01011010

* Other special ASCII

 91 = [  square brackets or box brackets, opening bracket <br>
 92 = \  Backslash , reverse slash <br>
 93 = ]  box brackets or square brackets, closing bracket <br>
 94 = ^  Circumflex accent or Caret <br>
 95 = _   underscore , understrike , underbar or low line<br>
 96 = \` Grave accent <br>

 * word[i] <= 'Z' which compared the ASCII value, point to [A-Z]

*  [More ASCII code value](http://www.theasciicode.com.ar/ascii-table-characters.pdf)

## Code
```c++
class Solution {
public:
    bool detectCapitalUse(string word) {
        int len = word.size(), count = 0;

        for(int i = 0; i < len; i++){
            if (word[i] <= 'Z') count++;
        }
      /*
        if(count == len || count == 0 || (count == 1 && word[0] <= 'Z' )) return true;
        else{
            return false;
        }
        */

        return (count == len || count == 0 || (count == 1 && word[0] <= 'Z' )) ?  true: false;
    }
};
```
