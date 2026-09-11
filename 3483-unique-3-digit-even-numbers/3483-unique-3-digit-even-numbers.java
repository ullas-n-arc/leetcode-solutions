class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        Set<Integer> mySet=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i==j||i==k||j==k){
                        continue;
                    }
                    int num=(digits[i]*100)+(digits[j]*10)+(digits[k]*1);
                    if(num>=100&&num%2==0){
                        mySet.add(num);
                    }
                }
            }
        }
        return mySet.size();
    }
}