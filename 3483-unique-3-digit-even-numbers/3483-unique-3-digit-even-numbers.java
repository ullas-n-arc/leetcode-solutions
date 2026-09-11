class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        int[] map=new int[10];
        int count=0;
        for(int num:digits){
            map[num]++;
        }
        for(int i=1;i<=9;i++){
            if(map[i]==0) continue;
            map[i]--;
            for(int j=0;j<=9;j++){
                if(map[j]==0) continue;
                map[j]--;
                for(int k=0;k<=8;k+=2){
                    if(map[k]==0) continue;
                    map[k]--;
                    count++;
                    map[k]++;
                }
                map[j]++;
            }
            map[i]++;
        }
        return count;
    }
}