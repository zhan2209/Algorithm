# 453. Minimum Moves to Equal Array Elements
## Description
```
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
```
## Background
* Find the minimum number
* sum of the diff for each number with the minimum number is the total move

## Code
```c++
class Solution {
public:
    int minMoves(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int m= nums[0];
        int res = 0;
        for(int num: nums){
            res += (num-m);
        }

        return res;
    }
};
```
