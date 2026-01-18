class Solution {
    public static int func(int i, int j, int[][] grid) {
        if (i < 0 || j < 0) return (int)(1e9);
        if (i == 0 && j == 0) return grid[i][j];

        int up = grid[i][j] + func(i - 1, j, grid);
        int left = grid[i][j] + func(i, j - 1, grid);

        return Math.min(up, left);
    }

    public static int memo(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) return (int)(1e9);
        if (i == 0 && j == 0) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + memo(i - 1, j, grid, dp);
        int left = grid[i][j] + memo(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public static int space(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = (i > 0) ? grid[i][j] + prev[j] : (int)(1e9);
                    int left = (j > 0) ? grid[i][j] + curr[j - 1] : (int)(1e9);
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }

    public int minPathSum(int[][] grid) {
        return space(grid);
    }
}