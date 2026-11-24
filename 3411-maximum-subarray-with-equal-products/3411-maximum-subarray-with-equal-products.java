class Solution {
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            long prod = nums[i], g = nums[i], l = nums[i];

            for (int j = i + 1; j < n; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = l / gcd(l, nums[j]) * nums[j];

                if (prod > g * l) break;
                if (prod == g * l) ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }
}