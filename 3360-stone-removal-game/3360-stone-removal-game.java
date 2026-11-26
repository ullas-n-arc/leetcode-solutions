class Solution {
    public boolean canAliceWin(int n) {
        for(int i=10;i>0;i--){
            if(n>0&&n>=i){
                n=n-i;
            }else{
                return (i%2!=0);
            }
        }
        return false;
    }
}