class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>();
        int currentNumber=1;
        for(int i=0;i<n;i++){
            ans.add(currentNumber);
            if(currentNumber*10<=n){
                currentNumber*=10;
            }else{
                while(currentNumber>=n||currentNumber%10==9){
                    currentNumber/=10;
                }
                currentNumber++;
            }
        }
        return ans;
    }
}