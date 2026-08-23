class Solution {
    public boolean sumGame(String num) {
        //if #? is odd alice always wins because she will have the last chance of making choice
        int n=num.length();
        int leftKnownSum=0;
        int rightKnownSum=0;
        int leftQnMarkCount=0;
        int rightQnMarkCount=0;
        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?'){
                if(i<n/2){
                    leftQnMarkCount++;
                }else{
                    rightQnMarkCount++;
                }
            }else{
                if(i<n/2){
                    leftKnownSum+=num.charAt(i)-'0';
                }else{
                    rightKnownSum+=num.charAt(i)-'0';
                }
            }
        }
        if((leftQnMarkCount+rightQnMarkCount)%2==1){
            return true;
        }
        int left=2*leftKnownSum+9*leftQnMarkCount;//weight of each qn mark is 4.5 from derivation
        int right=2*rightKnownSum+9*rightQnMarkCount;
        if(left==right){
            return false;
        }
        return true;
    }
}