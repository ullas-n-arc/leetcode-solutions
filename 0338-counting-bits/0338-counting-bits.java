class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=1;i<=n;i++){
            int count=0;
            int j=i;
            while(j>0){
                j=j&(j-1);
                count++;
            }
            ans[i]=count;
        }
        return ans;
    }
}