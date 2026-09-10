class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=grumpy.length;
        int base=0;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                base+=customers[i];
            }
        }
        int windowExtra=0,maxExtra=0;
        int left=0;
        for(int right=0;right<n;right++){
            if(grumpy[right]==1){
                windowExtra+=customers[right];
            }
            if(right-left+1==minutes){
                maxExtra=Math.max(maxExtra,windowExtra);
                if(grumpy[left]==1){
                    windowExtra-=customers[left];
                }
                left++;
            }
        }
        return base+maxExtra;
    }
}