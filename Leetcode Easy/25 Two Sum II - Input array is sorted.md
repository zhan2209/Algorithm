# 167. Two Sum II - Input array is sorted
## Description
```
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
```
## Background
* pair all numbers until find the sum of target
* if duplicate numbers, check equal target or not
  * if not then jump to the next numbers

* Set Two pointers one point to head one point to end
  * if the sum of head&end element larger than target
      * end point move to left to a smaller numbers
  * if the sum of head&end lement smaller than target
      * head point move to right to a larger numbers


## Code

```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int index1,index2;
        for(int i = 0; i < numbers.size(); i++){
            if(i<numbers.size()-1 && numbers[i]==numbers[i+1] && numbers[i]* 2 != target) i++;
            for(int j = i+1; j < numbers.size(); j++){
                if(numbers[i] + numbers[j] == target){
                    index1 = i + 1;
                    index2 = j + 1;
                    vector<int> res;
        			res.push_back(min(index1,index2));
       				res.push_back(max(index1,index2));
       				return res;
                }
                 if(numbers[j] == numbers[j+1]) j++;
            }
            if(numbers[i] == numbers[i+1]) i++;
        }


    }
};
```
* time O(nlogn) :arrow_up:
* time O(n) :arrow_down:
```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int end = numbers.size() - 1;
        int head = 0;
        vector<int> res;
        while (head < end){
            if(numbers[head] + numbers[end] == target){
                res.push_back(head + 1);
                res.push_back(end + 1);
                return res;
            }
            else if(numbers[head] + numbers[end] < target){
                head ++;
            }
            else{
                end--;
            }
        }
    }
};
```
