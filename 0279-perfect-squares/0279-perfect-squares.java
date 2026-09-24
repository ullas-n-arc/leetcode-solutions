class Solution {
    //perfect squares
    //[1->1]
    //[2->1]
    //[3->2] (1+2)
    //12
    //[1,4,9]
    int[] dp;
    public int numSquares(int n) {
        ArrayList<Integer> perfectSquares=new ArrayList<>();
        int i=1;
        while(true){
            int square=i*i;
            if(square>n) break;
            perfectSquares.add(square);
            i+=1;
        }
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        System.out.println(perfectSquares.toString());
        return myFun(perfectSquares,n);
    }
    int myFun(List<Integer> arr,int target){
        if(target==0){
            return 0;
        }
        if(target<0){
            return Integer.MAX_VALUE - 1;
        }
        if(dp[target]!=-1) return dp[target];
        int res=Integer.MAX_VALUE;
        for(int num:arr){
            res=Math.min(res,1+myFun(arr,target-num));
        }
        return dp[target]=res;
    }
}