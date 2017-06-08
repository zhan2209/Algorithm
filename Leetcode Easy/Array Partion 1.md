# 561. Array Partition I

Question desctiption:

```javascript
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4.
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
```
* Self Explanation
  * max(sun(min(ai,bi)))
  * for all pairs from i =0 to i = n, the sum of the min nunmber in each pair as max as possible, and return the max sum

## Things need to know
#### C++
* Sort()
  * sort(nums.begin( ), nums.end( ));
   * Sorts the elements in the range [first,last) into ascending order
   *
  * nums.begin( )
   * get the very first vetcor< int>
  * numbs.end( )
   * get the end vector< int>
* zise()
  * nums.size();
   * Get the length of a vector< int>
   *  Returns the number of elements in
 the vector.
* vector< int>
  * Parameters
   * alloc
   * n : Initial container size
   * val
   * first, last

#### Java
* get int[] array length
 * int array_length= array.length;


## code!
### C++
`````c++
class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
         sort(nums.begin(), nums.end());
         int n = nums.size();
         int sum = 0;
         for(int i = 0; i< n; i = i+2){
             sum += nums[i];
         }
         return sum;
    }
};
`````

### Java
```javascript
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0 ;
        for (int i = 0 ; i < n; i = i+2){
            sum += nums[i];
        }
        return sum;
    }
}
```
