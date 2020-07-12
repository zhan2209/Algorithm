class UnionFind{
    private int[] father = null;
    private int cnt;
    public UnionFind(int n){
        father = new int[n];
        for(int i = 0; i < n; i++){
            father[i] = i;
        }
    }
    public int find(int x){
        if(father[x] == x){
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            father[rootA] = rootB;
        }
    }
    public boolean isSame(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }
}

class Solution {
    final int[] dx = {-1,1,0,0};
    final int[] dy = {0,0,-1,1};
     
    private boolean inBound(int x,int y, int m, int n){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    private int convertToId(int x,int y,int n){
        return x * n + y;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        if(m == 0 || n == 0 || positions == null || positions.length == 0){
            return ans;
        }
        
        UnionFind uf = new UnionFind(m * n);
        
        boolean[][] grid = new boolean[m][n];
        int k = positions.length;
        int cnt = 0;

        for(int i = 0; i < k; i++){
           int x = positions[i][0];
           int y = positions[i][1];
            if(!grid[x][y]){
                grid[x][y] = true;
                cnt++;
                int id = convertToId(x,y,n);
                for(int j = 0; j < 4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(inBound(nx,ny,m,n) && grid[nx][ny]){
                        int nid = convertToId(nx,ny,n);
                        if(!uf.isSame(id,nid)){
                            uf.union(id,nid);
                            cnt--;
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
//并查集