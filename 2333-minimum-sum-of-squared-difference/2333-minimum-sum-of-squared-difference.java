class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        long k = (long) k1 + k2;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        int[] freq = new int[maxDiff + 1];
        long total = 0;

        for (int d : diff) {
            freq[d]++;
            total += d;
        }

        if (k >= total) return 0;

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            long count = freq[d];

            if (count == 0) continue;

            long operationsNeeded = count;

            if (k >= operationsNeeded) {
                freq[d - 1] += freq[d];
                freq[d] = 0;
                k -= operationsNeeded;
            } else {
                long lowerCount = k;
                freq[d] -= (int) lowerCount;
                freq[d - 1] += (int) lowerCount;
                k = 0;
            }
        }

        long ans = 0;

        for (int d = 0; d < freq.length; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}