class Solution {
    int  t[][];
    public int stoneGameV(int[] stoneValue) {
        t=new int[stoneValue.length][stoneValue.length];
        for(int row[]:t){
            Arrays.fill(row,-1);
        }
        int prefixSum[]=new int[stoneValue.length];
        prefixSum[0]=stoneValue[0];
        for(int i=1;i<stoneValue.length;i++){
            prefixSum[i]=prefixSum[i-1]+stoneValue[i];
        }
        return solve(stoneValue,prefixSum,0,stoneValue.length-1);
    }
    int solve(int[] stoneValue,int[] prefixSum,int l,int r){
        if(l>=r){
            return 0;
        }
        if(t[l][r]!=-1){
            return t[l][r];
        }
        int score=0;
        for(int mid=l;mid<=r-1;mid++){
            int leftSum=prefixSum[mid];
            if(l!=0){
                leftSum-=prefixSum[l-1];
            }
            int rightSum=prefixSum[r]-prefixSum[mid];
            if(leftSum<rightSum){
                score=Math.max(score,leftSum+solve(stoneValue,prefixSum,l,mid));
            }else if(leftSum>rightSum){
                score=Math.max(score,rightSum+solve(stoneValue,prefixSum,mid+1,r));
            }else{
                score=Math.max(score,Math.max(leftSum+solve(stoneValue,prefixSum,l,mid),rightSum+solve(stoneValue,prefixSum,mid+1,r)));
            }
        }
        return t[l][r]=score;
    }
}