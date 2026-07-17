class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n=nums.length;
        int maxVal=nums[0];
        for(int i=1;i<n;i++){
            maxVal=Math.max(maxVal,nums[i]);
        }
        int divisors[]=new int[maxVal+1];
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=1;j*j<=num;j++){
                if(num%j==0){
                    divisors[j]++;
                    if(num/j!=j){
                        divisors[num/j]++;
                    }
                }
                
            }
        }
        long[] pairsWithGcd=new long[maxVal+1];
        for(int factor=maxVal;factor>=1;factor--){
            long count=divisors[factor];
            pairsWithGcd[factor]=count*(count-1)/2;//nc2
            //correction
            for(int multiples=2*factor;multiples<=maxVal;multiples+=factor){
                pairsWithGcd[factor]-=pairsWithGcd[multiples];
            }
        }
        long[] prefixCountGcd=new long[maxVal+1];
        for(int g=1;g<=maxVal;g++){
            prefixCountGcd[g]=prefixCountGcd[g-1]+pairsWithGcd[g];
        }
        int[] result=new int[queries.length];
        int k=0;
        for(long query:queries){
            int l=1;
            int r=maxVal;
            int ans=1;
            while(l<=r){
                int midGcd=l+(r-l)/2;
                if(prefixCountGcd[midGcd]>query){
                    ans=midGcd;
                    r=midGcd-1;
                }else{
                    l=midGcd+1;
                }
            }
            result[k++]=ans;
        }
        return result;
    }
}