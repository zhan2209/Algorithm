# 504. Base 7
## Description
```
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].

```
## Background
* transfer cector<int> into string
 *      stringstream ss;
        copy(res.begin(), res.end(), ostream_iterator<int>(ss));
        string  val = ss.str();
* reverse
  * reverse(res.begin(), res.end());
  
## Code
```c++
class Solution {
public:
    string convertToBase7(int nums) {
        vector<int> res;
        int num = abs(nums);
        while(num >= 7){
            res.push_back(num%7) ;
            num /= 7;
        }
        nums < 0? res.push_back(-num): res.push_back(num);

        reverse(res.begin(), res.end());
        stringstream ss;
        copy(res.begin(), res.end(), ostream_iterator<int>(ss));
        string  val = ss.str();
        return val;
    }
};
```
