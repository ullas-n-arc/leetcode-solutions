class Solution {
    public int maxDigitRange(int[] nums) {
        int n=nums.length;
        int[] digitRange=new int[n];
        int max=0;
        int sum=0;
        int i=0;
        for(int num:nums){
            digitRange[i]=calculateDigitRange(num);
            max=Math.max(max,digitRange[i]);
            i++;
        }
        for(i=0;i<n;i++){
            if(digitRange[i]==max){
                sum+=nums[i];
            }
        }
        return sum;
    }
    int calculateDigitRange(int n){
        int max=0;
        int min=9;
        while(n>0){
            int r=n%10;
            max=Math.max(max,r);
            min=Math.min(min,r);
            n=n/10;
        }
        return max-min;
    }
}