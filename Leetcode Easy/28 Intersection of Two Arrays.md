# 349. Intersection of Two Arrays
## Description
```
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
```

## Background
* Add one vector to the end of the other vector
  * nums1.insert(nums1.begin(),nums2.begin(),nums2.end());
* Find the intersection of a set then convert set to vector
  * Use set_intersection // only for set<>
    * set_intersection(set1.begin(), set1.end(),
                    set2.begin(), set2.end(),
                    inserter(res, res.begin()));
  * Convert set to vector
    * vector<int>(set.begin(),set.end());

## Code
```c++
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<int> res;
        int i = 0, j = 0;
        while (i< nums1.size() && j < nums2.size()){
            if(nums1[i] < nums2[j] ){
                i++;
            }
            else if(nums1[i] > nums2[j] ){
                j++;
            }
            else{
                if(res.empty() || nums1[i] != res.back()){
                    res.push_back(nums1[i]);
                }
                i++;
                j++;
            }
        }

        return res;

    }
};
```

```c++
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<int> res;


        for (int i = 0, j = 0; i< nums1.size() && j < nums2.size();){
            if(nums1[i] < nums2[j] ) i++;
            else if(nums1[i] > nums2[j] )j++;
            else{
                if(res.empty() || nums1[i] != res.back()) res.push_back(nums1[i]);
                i++;
                j++;
            }
        }
        return res;

    }
};
```

```c++
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int> res;
        set<int> n1(nums1.begin(), nums1.end());
        set<int> n2(nums2.begin(), nums2.end());

        set_intersection(n1.begin(), n1.end(),
                         n2.begin(),n2.end(),
                         inserter(res,res.begin()));

        return vector<int>(res.begin(), res.end());
    }
};
```
