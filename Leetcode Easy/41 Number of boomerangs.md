# 447. Number of Boomerangs
## Description
```
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
```

## Code
```c++
/*
[[0,0],[1,0],[2,0]]
[[0,0],[1,0],[2,0],[1,1]]
[[0,0],[1,0],[2,0],[1,1],[1,-1]]
[[0,0],[1,0],[2,0],[3,0],[4,0],[2,1],[2,-1],[2,2],[2,-1]]
*/
class Solution {
public:
    //遍历所有点，让每个点都做一次点a，然后遍历其他所有点，统计和a距离相等的点有多少个，
    //然后分别带入n(n-1)计算结果并累加到res中，只有当n大于等于2时，res值才会真正增加
    int numberOfBoomerangs(vector<pair<int, int>>& points) {
        if(points.size() < 3) return 0;

        int res = 0;
        for (int i = 0; i < points.size(); i++){
            vector<int> dis;
            for(int j = 0; j < points.size(); j++){
                int a = pow((points[i].first - points[j].first),2) + pow((points[i].second - points[j].second),2);
                dis.push_back(a);
            }
            vector<int> count;
            sort(dis.begin(),dis.end());
            int l = 1;
            for(int k = 0; k < dis.size();){
                if(dis[k] == dis[k+l]){
                    l++;
                }
                else{
                    count.push_back(l);
                    k = k+l;
                    l = 1;
                }
            }

            for( int q = 0; q < count.size(); q++){
                if(count[q] >= 2){
                   res += count[q]*(count[q]-1);
                }
            }
        }
        return res;
    }
};
```
## Problem

 Thought it shows the 4th test data answer, but it should be their test Problem give the wrong answer
```
Run Code Result:×

Your input

[[0,0],[1,0],[2,0]]
[[0,0],[1,0],[2,0],[1,1]]
[[0,0],[1,0],[2,0],[1,1],[1,-1]]
[[0,0],[1,0],[2,0],[3,0],[4,0],[2,1],[2,-1],[2,2],[2,-1]]
Your answer

2
8
20
80
Expected answer

2
8
20
76
```
