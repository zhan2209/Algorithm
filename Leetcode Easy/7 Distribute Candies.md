# 575. Distribute Candies

## Description
```
Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
The sister has three different kinds of candies.

Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
The sister has two different kinds of candies, the brother has only one kind of candies.

Note:
The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].
```
## Explanation
* the maximum of kinds is n/2
* if the current kind < n/2, then the maximum sister can get is the current kinds
* else she can get n/2 kinds of candies

## Background information
* convert array into un_ordered set
  *   unordered_set<int> tmp(candies.begin(), candies.end());
  *   unordered_set<int>(candies.begin(), candies.end());

* min(a,b)
  * Returns the smallest of a and b. If both are equivalent, a is returned.
  * a and b must in the same data type
    * min(1,2)
    * min('a','b')
## Code

```c++
class Solution {
public:
    int distributeCandies(vector<int>& candies) {
        int length = candies.size();
        unordered_set<int> tmp(candies.begin(), candies.end());
        int tmp_length = tmp.size();
        return min(tmp_length, length/2);
    }
};

//=========one line code===========
class Solution {
public:
    int distributeCandies(vector<int>& candies) {
       return min(unordered_set<int>(candies.begin(), candies.end()).size(), candies.size() / 2);
    }
};

```
