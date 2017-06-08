# 461. Hamming Distance

Question desctiption:

```javascript
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
  1   (0 0 0 1)
  4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

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
