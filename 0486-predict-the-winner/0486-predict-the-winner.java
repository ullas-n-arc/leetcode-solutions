class Solution {
    public boolean predictTheWinner(int[] nums) {
        // int index=0;
        // int counterIndex=nums.length-1;
        // boolean turnA=true;
        // int scoreA=0;
        // int scoreB=0;
        /*
            scoreA-scoreB>0
            scoreA>=ScoreB
            //maximize scoreA
            //minimize scoreB
            //player a tries to maximize 
            //player b tries to minimize
            //wow we always have a choice to pick odd scores / even scores
        */
        //i cant be greedy in every step future optima is required
        // while(index<=counterIndex){
        //     if(turnA){
        //         turnA=false;
        //         if(nums[index]<nums[counterIndex]){
        //             scoreA+=nums[counterIndex];
        //             counterIndex--;
        //         }else{
        //             scoreA+=nums[index];
        //             index++;
        //         }
        //     }else{
        //         turnA=true;
        //         if(nums[index]<nums[counterIndex]){
        //             scoreB+=nums[counterIndex];
        //             counterIndex--;
        //         }else{
        //             scoreB+=nums[index];
        //             index++;
        //         }
        //     }
        // }
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int scoreA=sol(nums);
        return scoreA>=sum-scoreA;
    }
    int sol(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=arr[i];
        }
        for(int i=0;i<n-1;i++){
        dp[i][i+1]=Math.max(arr[i],arr[i+1]);
        }
        for(int gap=3;gap<=n;gap++){
            for(int i=0;i+gap-1<n;i++){
                int j=i+gap-1;
                dp[i][j]=Math.max(arr[i]+Math.min(dp[i+1][j-1],dp[i+2][j]),arr[j]+Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }
        return dp[0][n-1];
    }
}