class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int rightSideMatch[]=new int[n];
        int rightMatch=0;
        int j=m-1;
        for(int i=n-1;i>=0;i--){
            if(j>=0&&word2.charAt(j)==word1.charAt(i)){
                rightMatch++;
                j--;
            }
            rightSideMatch[i]=rightMatch;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        boolean changePower=true;
        int i=0;
        j=0;
        while(i<n&&j<m){
            if(word1.charAt(i)==word2.charAt(j)){
                ans.add(i);
                j++;
            }else if(changePower&&i<n-1&&rightSideMatch[i+1]>=m-j-1){
                ans.add(i);
                j++;
                changePower=false;
            }
            i++;
        }
        if(j==m){
            int[] result=new int[m];
            for(i=0;i<m;i++){
                result[i]=ans.get(i);
            }
            return result;
        }
        return new int[]{};
    }
}