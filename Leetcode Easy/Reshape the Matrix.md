# 566. Reshape the Matrix

## Description
````
n MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.


Example 1:
Input:
nums =
      [[1,2],
       [3,4]]
      r = 1, c = 4
Output:
      [[1,2,3,4]]

Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.


Example 2:
Input:
      nums =
      [[1,2],
       [3,4]]
      r = 2, c = 4
Output:
      [[1,2],
       [3,4]]

Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.

Note:
The height and width of the given matrix is in range [1, 100].
The given r and c are all positive.

````

## Background information
* push_back()
  * target.push_back(new item)
  * Adds a new element at the end of the vector, after its current last element. The content of val is copied (or moved) to the new element.
* pop_back()
  * target.pop_back(new item)
  * Removes the last element in the vector, effectively reducing the container size by one.



## Code

 ### C++
```C++
class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        int width = nums[0].size();
        int length = nums.size();
        vector<int> tmp = {};

        if ( r == 0||c ==0 || (length* width != c*r) || ((length* width)%(r*c) != 0) ||((length* width)/r != c) ) {
            return nums;
        } // Check if the current nums has 0 element(r or c is 0), then return empty.
        // if the sum of element is not equal to the final matrix elements number return original nums
        // if the sum of elements can not devided into the target r*c matrix, return original
        else {
            for(int i = 0; i < length ; i++){
                for(int j = 0; j < width; j++){
                 tmp.push_back(nums[i][j]);
                }
            }
        }
        // push all the elements into a one-domination Array
        vector<vector<int>> res ;
      /*  if(r == 1){
             res.push_back(tmp);
             return res;
        }
        else{
        */
            int k = 0;
            for(int i = 0; i < r; i++){
                vector<int> tmp_res;
                for (int j = 0; j < c; j++){
                      tmp_res.push_back(tmp[k++]);
                }
                res.push_back(tmp_res);
            }
            return res;
      //  }
    }
};
```
