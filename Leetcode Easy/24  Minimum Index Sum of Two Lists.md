# 599. Minimum Index Sum of Two Lists
## Description
```
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
```

## Background
* Find the Minimum index sum
  * if l1 == l2 check current index sum less than previous or not
    * if less than previous, update previous index sum and store the current string
* add a new Element into a vector use <b>push_back()</b>
## Code
```c++
class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        int pre = 2000;
        vector<string> res;

        for(int i = 0; i < list1.size(); i++){
            for(int j = 0; j < list2.size(); j++){
                int cur = 0;
                if(list1[i] == list2[j]){
                    cur = i + j;
                    if(cur <= pre){
                        res.push_back(list1[i]);
                        pre = cur;
                    }
                }
            }
        }
        return res;
    }
};
```
