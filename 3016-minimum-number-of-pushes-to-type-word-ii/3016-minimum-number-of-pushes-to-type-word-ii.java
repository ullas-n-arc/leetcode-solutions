class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            freq[word.charAt(i)-'a']++;
        }
        int result=0;
        int count=0;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--){
            int frequency=freq[i];
            int press=(count/8)+1;
            result+=press*frequency;
            count++;
        }
        return result;
    }
}