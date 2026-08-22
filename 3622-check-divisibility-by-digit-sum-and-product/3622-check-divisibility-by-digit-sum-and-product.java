class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum=0;
        int digitProduct=1;
        int temp=n;
        while(temp>0){
            int r=temp%10;
            digitSum+=r;
            digitProduct*=r;
            temp/=10;
        }
        return n%(digitSum+digitProduct)==0;
    }
}