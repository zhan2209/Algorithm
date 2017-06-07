# Array Partition I

Question desctiption:

```javascript
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4.
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
```
## Things need to know
* what is Hamming distance
  * Hamming distance: the Hamming distance between two strings of equal length is the number of positions at which the corresponding symbols are different
* Bitwise operators
  * & : return 1 if both bit are the same
  * | : return 1 if any bit is exit
  * ^ : return 1 if two bit are different
* Operators review
  * ~  : change to 1 if current bit is 0, change to 0 if current bit is 1
  * << : bit move left (A<<1, A move 1 bit toward left)
  * \>> : bit move right (A>>1, A move 1 bit toward right)

## code!
### C++
`````c++
class Solution {
public:
    int hammingDistance(int x, int y) {
        int count = 0;
        int z = x^y;
        while (z > 0){
            if(((z>>1<<1)-z) != 0){ // move z to right then back left, if it's the same value with before, which means the last digit is 0, otherwise counter +1
            count++;
            }
            z = z>>1;
        }
        return count;
    }
};
`````

### Java
```javascript
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y); //Java had this special function which can count bit.
        // remember this function is under Integer.bitCount()
    }
}
```
