
# 645. Set Mismatch
## Description
```
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Note:

    The given array size will in the range [2, 10000].
    The given array's numbers won't have any order.

```

## Background

* sort the array as increase 1~n
* the same two elemtns are the first duplicated numbers
* the other gap is when the next two elements increase 2
  * if not exist, then the last elemtns Missing

## Code
```c++
class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int n = nums.size();
        int res2 = 0, res1 = 0;
        sort(nums.begin(),nums.end());
        vector<int> res;
        for(int i = 0; i < n-1; i++){

            if( (nums[i]- nums[i+1]) != 1){
                if(nums[i] == nums[i+1])
                {
                    res1 = nums[i];
                }
                int test = abs(nums[i] - nums[i+1]);
                if( test >= 2)
                {
                    res2 = nums[i] + 1;
               }
            }
        }
        /*
        res.push_back(res1);
        if(res2 == 0) {
            res2= nums[0] ==1 ? nums[n-1] +1 : 1;
            res.push_back(res2);
        }
        else{
            res.push_back(res2);
        }
        */
        res.push_back(res1);
        res2 =  res2 != 0 ? res2 : (nums[0] == 1 ? nums[n-1] + 1 : 1);
        res.push_back(res2);
        return res;
    }
};
```
