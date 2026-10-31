class Solution {
    int n;
    int m;
    int mod = 1000000007;

    Long dp[][][];

    public long solve(int[][] grid, int i, int j, int dir) {

        if (i >= n || j >= m)
            return 0;

        if (i == n - 1 && j == m - 1)
            return 1;

        if (dp[i][j][dir] != null)
            return dp[i][j][dir];

        long ans = 0;

        if (grid[i][j] == 1) {

            if (dir == 0)
                ans = solve(grid, i + 1, j, 1);
            else
                ans = solve(grid, i, j + 1, 0);

        } else {

            long down = solve(grid, i + 1, j, 1);
            long right = solve(grid, i, j + 1, 0);

            ans = (down + right) % mod;
        }

        return dp[i][j][dir] = ans;
    }

    public int uniquePaths(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        dp = new Long[n][m][2];

        long ans = solve(grid, 0, 0, 0);

        return (int)(ans % mod);
    }
}