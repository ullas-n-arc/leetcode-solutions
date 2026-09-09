class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans=0;
        int left=0;
        int countB=0;
        for(int right=0;right<blocks.length();right++){
            if(blocks.charAt(right)=='B'){
                countB++;
            }
            if(right-left+1>k){
                if(blocks.charAt(left)=='B') countB--;
                left++;
            }
            if(right-left+1==k){
                ans=Math.max(ans,countB);
            }
        }
        if(ans>=k) return 0;
        return k-ans;
    }
}