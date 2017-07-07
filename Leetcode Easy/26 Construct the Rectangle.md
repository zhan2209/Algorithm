# 492 Construct the Rectangle
## Description
```
For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

1. The area of the rectangular web page you designed must equal to the given target area.

2. The width W should not be larger than the length L, which means L >= W.

3. The difference between length L and width W should be as small as possible.
You need to output the length L and the width W of the web page you designed in sequence.

Example:
Input: 4
Output: [2, 2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
Note:
The given area won't exceed 10,000,000 and is a positive integer
The web page's width and length you designed must be positive integers.
```
## Background
* check the rectangle can be a square or not
    * if sqrt(area) is integers which means it can be a square
    * if sqrt(area) is not a integer, then check it can be divided by the nearest integer of sqrt(area)
      * else check the next nearest number
* Find the root of a number
  * sqrt(nums)
* Check a number is integers or not
  * num == int(num)

## Code
```c++
class Solution {
public:
    vector<int> constructRectangle(int area) {
        vector<int> res;
        if(sqrt(area) == int(sqrt(area))){
             res.push_back(sqrt(area));
             res.push_back(sqrt(area));
             return res;
        }


        for(int tmp = int(sqrt(area));tmp > 1; tmp--){
            if(area%tmp == 0){
                res.push_back(max(tmp,area/tmp));
                res.push_back(min(tmp,area/tmp));
                return res;
            }
        }
            res.push_back(area);
            res.push_back(1);
            return res;
    }
};

```
