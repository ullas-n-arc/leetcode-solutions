class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // myFun(n);
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=0;j<i;j++){
                count+=(dp[j]*dp[i-j-1]);
            }
            dp[i]=count;
        }
        return dp[n];
    }
    int myFun(int n){
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int count=0;
        for(int i=0;i<n;i++){
            count+=(myFun(i)*myFun(n-i-1));
        }
        dp[n]=count;
        return dp[n];
    }
    
}