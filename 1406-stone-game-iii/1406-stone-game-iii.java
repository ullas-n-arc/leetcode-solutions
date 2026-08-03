class Solution {
    int t[];
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        t=new int[n+1];
        Arrays.fill(t,-1);
        int diff=solve(stoneValue,n,0);//alice - bob;
        if(diff>0){
            return "Alice";
        }else if(diff<0){
            return "Bob";
        }
        return "Tie";
    }
    int solve(int[] stoneValue,int n,int i){
         if(i>=n) return 0;
         if(t[i]!=-1) return t[i];
         int result=stoneValue[i]-solve(stoneValue,n,i+1);
         if(i+1<n)
         result=Math.max(result,stoneValue[i]+stoneValue[i+1]-solve(stoneValue,n,i+2));
         if(i+2<n)
         result=Math.max(result,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-solve(stoneValue,n,i+3));
         return t[i]=result;
    }
}