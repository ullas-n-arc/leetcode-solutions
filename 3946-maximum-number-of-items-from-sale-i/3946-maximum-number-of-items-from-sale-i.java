class Solution {
    int[][][] memo;
    int[] copies;
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        memo=new int[n][budget+1][2];
        for(int i=0;i<n;i++){
            for(int row[]:memo[i]){
                Arrays.fill(row,-1);
            }
        }
        copies=new int[n];
        for(int i=0;i<n;i++){
            int copy=0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(items[j][0]%items[i][0]==0){
                    copy++;
                }
            }
            copies[i]=copy;
        }
        solve(n-1,items,budget,0);
        return memo[n-1][budget][0];
    }
    int solve(int i,int[][] items,int budget,int bought){
        if(i<0){
            return 0;
        }
        if(budget<=0){
            return 0;
        }
        if(memo[i][budget][bought]!=-1){
            return memo[i][budget][bought];
        }
        int notTake=solve(i-1,items,budget,0);
        int take=Integer.MIN_VALUE;
        int price=items[i][1];
        if(price<=budget){
            if(bought==0){
                take=1+solve(i,items,budget-price,1)+copies[i];
            }else{
                take=1+solve(i,items,budget-price,1);
            }
        }
        return memo[i][budget][bought]=Math.max(take,notTake);
    }
}