# 476. Number Complement

## Question desctiption:

```javascript
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

```
* Self Explanation
 * For a unsigned integer, we need count how many digit from right to left;
  * then make a mask
  * handle the mask with the original number

* Example
```
num          = 00000101
mask         = 11111000
~mask & ~num = 00000010
```

## Background information
* ### [Two's Complement](link http://www.cs.uwm.edu/~cs151/Bacon/Lecture/HTML/ch03s09.html )
 * A positive integer in two's complement always has a 0 in the leftmost bit (sign bit) and is represented the same way as an unsigned binary integer.
 *  Exercise & Examples
```
Convert the following 4-bit 2's comp values to decimal:

	0111 = +(1 + 2 + 4) = +7
	1000 = -(0111 + 1) = -(1000) = -8
	0110 = +(2 + 4) = +6
	1001 = -(0110 + 1) = -0111 = -(1 + 2 + 4) = -7
	1110 = -(0001 + 1) = -0010 = -2
```
 * Heading Sign -/+
   * Negative number heading with 1
   * Positive number heading with 0

* ### Sign mark
 * INT_MAX
   * Maximum value for an object of type int
   * 32767 (2<sup>15</sup>-1) or greater*
 * INT_MIN
   * Minimum value for an object of type int
   * -32767 (-2<sup>15</sup>+1) or less*

* ### Integer.highestOneBit(num)
  * returns an int value with at most a single one-bit, in the position of the highest-order ("leftmost") one-bit in the specified int value.
  * It returns zero if the specified value has no one-bits in its two's complement binary representation, that is, if it is equal to zero.

## code!
### C++
`````c++
class Solution {
public:
    int findComplement(int num) {
        unsigned mask = ~0;
        while (num & mask) mask <<= 1;
        return ~mask & ~num;
    }
};
`````

### Java
```javascript
public class Solution {
    public int findComplement(int num) {
     return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
```
