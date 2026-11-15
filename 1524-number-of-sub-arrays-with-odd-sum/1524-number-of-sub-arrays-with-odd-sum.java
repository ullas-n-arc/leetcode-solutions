class Solution {

    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int ans = 0, oddCount = 0, evenCount = 1, prefixSum = 0;

        for(int num : arr){
            prefixSum += num;

            if(prefixSum % 2 == 0){
                ans = (ans + oddCount) % MOD;
                evenCount++;
            }else{
                ans = (ans + evenCount) % MOD;
                oddCount++;
            }
        }
        return ans;
    }
}