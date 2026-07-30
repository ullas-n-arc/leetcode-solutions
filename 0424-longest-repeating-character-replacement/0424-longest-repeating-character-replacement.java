class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int different=0;
        int maxLength=0;
        int maxFreq=0;
        int[] freq=new int[26];
        for(int right=0;right<s.length();right++){
            int currentChar=s.charAt(right)-'A';
            freq[currentChar]++;
            int curLen=right-left+1;
            maxFreq=fun(freq);
            while(curLen-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
                curLen=right-left+1;
                maxFreq=fun(freq);
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
    int fun(int[] nums){
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        return max;
    }
}