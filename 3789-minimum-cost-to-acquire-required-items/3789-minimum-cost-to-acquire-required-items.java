class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;

        if (need1 > need2) {
            ans += Math.min((long) costBoth, (long) cost1 + cost2) * need2;

            long rem1 = need1 - need2;
            ans += Math.min(costBoth, cost1) * rem1;

        } else {
            ans += Math.min((long) costBoth, (long) cost1 + cost2) * need1;

            long rem2 = need2 - need1;
            ans += Math.min(costBoth, cost2) * rem2;
        }

        return ans;
    }
}