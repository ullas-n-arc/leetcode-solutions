class Solution {
    public long sumAndMultiply(int n) {
        long x=0;
        long sum=0;
        while(n>0){
            int r=n%10;
            if(r!=0){
                x=(x*10)+r;
            }
            sum+=r;
            n=n/10;
        }
        //reverse x
        long newX=0;
        while(x>0){
            long r=x%10;
            newX=newX*10+r;
            x=x/10;
        }
        return sum*newX;
    }
}