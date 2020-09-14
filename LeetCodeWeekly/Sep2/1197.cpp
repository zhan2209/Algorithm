class Solution {
public:
    int minKnightMoves(int x, int y) {
        if(x == 0 && y == 0) return 0;
        vector<vector<int>> directions{{1,2},{2,1},{-1,2},{1,-2},{-1,-2},{-2,-1},{-2,1},{2,-1}};
        vector<vector<bool>> seen(601, vector<bool>(601, false));
        int res = 0;

        queue<pair<int, int>> q;
        q.push({0,0});
        while(!q.empty()){
            res++;
            for(int sz = q.size(); sz > 0; sz--){
                auto p = q.front();
                q.pop();
                int dist = abs(x-p.first)+abs(y-p.second);
                for(auto & d: directions){
                    int i = p.first+d[0], j = p.second+d[1];
                    if(i == x && y == j) return res;
                    if(seen[i+300][j+300]) continue;
                    seen[i+300][j+300] = true;
                    if(abs(x-i)+abs(y-j) < dist || dist <= 4){
                        q.push({i, j});
                    }
                }
            }
        }
        return 0;
    }
};