class Solution {

    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;

        if (n <= 1) {
            return n;
        }

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; // last difference negative
            dp[i][1] = 1; // last difference positive
        }

        int ans = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    // Current difference is positive.
                    // Previous difference must be negative.
                    dp[i][1] = Math.max(
                            dp[i][1],
                            dp[j][0] + 1);
                }

                else if (nums[i] < nums[j]) {
                    // Current difference is negative.
                    // Previous difference must be positive.
                    dp[i][0] = Math.max(
                            dp[i][0],
                            dp[j][1] + 1);
                }
            }

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }
}