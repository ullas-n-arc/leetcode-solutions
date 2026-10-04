class Solution {
    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return solve(n);
    }

    int solve(int t) {
        if (t == 1)
            return 1;
        if (memo[t] != 0)
            return memo[t];
        int res = 0;
        for (int i = 1; i < t; i++)
            res = Math.max(res, i * Math.max(t - i, solve(t - i)));
        return memo[t] = res;
    }
}