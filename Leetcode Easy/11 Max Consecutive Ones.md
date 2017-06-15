# 485. Max Consecutive Ones
## Description
```
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
```
## Background
 * res = (res>=flag? res : flag);
 * Use Greedy, from start to end, if the current length larger than the previous max_length, update the previous value else keep the previous value


## Code
C++

```c++
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int res = 0;
        int flag = 0 ;
        int length = nums.size();

        for(int i = 0; i < length; i++){
            if(nums[i] == 1) {
                flag++;
            }
            else{
             res = (flag >= res? flag : res);
             flag = 0;
           }
           /*  else{
                 if(flag >= res){
                     res = flag;
                     flag = 0;
                 }
                 else{
                     flag = 0;
                 }
             }      */
        }
        return max(res,flag);
    }
};
```
