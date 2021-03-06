package leetcode.dfs_bfs;

/**
 * @author Shaman
 * @date 2020/2/18 00:05
 */

public class _200 {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if (grid[i][j]=='1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
        }
    }
}
