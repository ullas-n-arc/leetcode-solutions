class Solution {
    private int mod=1_000_000_000+7;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int[] prefixSum=new int[n];
        prefixSum[0]=s.charAt(0)-'0';
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+(s.charAt(i)-'0');
        }
        int[] prefixConcat=new int[n];
        prefixConcat[0]=s.charAt(0)-'0';
        for(int i=1;i<n;i++){
            int r=s.charAt(i)-'0';
            if(r==0){
                prefixConcat[i]=prefixConcat[i-1];
            }else{
            prefixConcat[i]=(int)(((long)prefixConcat[i-1]*10+r)%mod);
            }
        }
        int[] nonZeroDigits=new int[n];
        int c=s.charAt(0)-'0';
        if(c!=0){
            nonZeroDigits[0]=1;
        }else{
            nonZeroDigits[0]=0;
        }
        for(int i=1;i<n;i++){
            int r=s.charAt(i)-'0';
            if(r!=0){
            nonZeroDigits[i]=nonZeroDigits[i-1]+1;}
            else{
            nonZeroDigits[i]=nonZeroDigits[i-1];
            }
        }
        long[] powerOf10=new long[n+1];
        powerOf10[0]=1;
        for(int i=1;i<=n;i++){
            powerOf10[i]=(powerOf10[i-1]*10)%mod;
        }
        long x=0;
        long sum=0;
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int cnt=0;
            if(l!=0){
            sum=(long)prefixSum[r]-prefixSum[l-1];
            cnt=nonZeroDigits[r]-nonZeroDigits[l-1];
            }
            else{
            sum=(long)prefixSum[r];
            cnt=nonZeroDigits[r];
            }
            if(l!=0){
            x=(long)((((prefixConcat[r]-prefixConcat[l-1]*powerOf10[cnt])%mod)+mod)%mod);
            }
            else{
            x=(long)(prefixConcat[r]);}

            ans[i]=(int)((sum*x)%mod);
            
        }
        return ans;
    }
}