class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int[] freq=new int[10];
        int assignKey=2;
        int result=0;
        for(int i=0;i<n;i++){
            if(assignKey>9){
                assignKey=2;
            }
            freq[assignKey]++;
            result+=freq[assignKey];
            assignKey++;
        }
        return result;
    }
}