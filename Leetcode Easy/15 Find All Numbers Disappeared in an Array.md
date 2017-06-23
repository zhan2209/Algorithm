# Find All Numbers Disappeared in an Array
## Description
```
Given an array of integers where | 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[5,6]
```
## Background information
* O(n) time
* no extra space O(1)
* swap(int a, int b) to switch a and b
* Explanation

|4 |3 |2 |7 |8 |2 |3 |1 | Original array
|--|--|--|--|--|--|--|--|
|7 | 3 | 2 | 4 | 8 | 2 | 3 | 1| swap(4,7), 4 is in num[4-1] and back to check nums[0] again
|3 | 3 | 2 | 4 | 8 | 2 | 3 | 1|
|2 | 3 | 3 | 4 | 8 | 2 | 7 | 1|
|3 | 2 | 3 | 4 | 8 | 2 | 7 | 1|
|1 | 2 | 3 | 4 | 0 | 2 | 7 | 8|
|1 | 2 | 3 | 4 | 1 | 2 | 7 | 8|


##  Code

```c++
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {

        for(int i = | 0; i < nums.size(); i++ ){
             if (nums[i] != nums[nums[i]-1]){
                swap(nums[i],nums[nums[i]-1]);
                --i;
             }
         }
         vector<int> res;
         for(int i = | 0; i < nums.size(); i++){
             if(nums[i] != i+1){
                 res.push_back(i+1);
             }
         }
         return res;
    }
};

```
