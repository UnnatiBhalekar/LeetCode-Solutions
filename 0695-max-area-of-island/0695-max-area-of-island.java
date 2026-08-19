class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null || grid[0].length == 0 || grid.length == 0) {
            return 0;
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int grid[][], int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0; //marked visited
        int area = 1;
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r + 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r , c - 1);

        return area;
        
    }
}