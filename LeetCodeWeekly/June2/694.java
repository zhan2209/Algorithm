class Solution {

    private int row,col;

    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private Set<String> set;

    public int numDistinctIslands(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i, j, path);
                    set.add(path.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder path) {
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (verify(x, y) && grid[x][y] == 1) {
                path.append(k);
                dfs(grid, x, y, path);
                // 代表往回走了一步
                path.append("-");
            }
        }
    }

    private boolean verify(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}