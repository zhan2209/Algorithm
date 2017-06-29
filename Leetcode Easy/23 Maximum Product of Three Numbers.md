# 628. Maximum Product of Three Numbers
## Description
```
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24

Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

```
## Background
* Sort vector array
  * Example 1 ~ std::sort(myvector.begin(), myvector.end())*
  * Example 2 ~ std::sort(myvector.begin(), myvector.end(), myCompFunction)
* Find the three number has the Maximus Absolut value
  * Two (minimum)negatives and a positive
  * Three positive

## Code
```c++
class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        //if(nums.size() < 3) return 0;
        sort(nums.begin(),nums.end());
        return max(nums[0]*nums[1]*nums[nums.size()-1],nums[nums.size()-1]*nums[nums.size()-2]*nums[nums.size()-3]);
    }
};
```
