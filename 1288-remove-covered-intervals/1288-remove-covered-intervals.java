class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        int ans=0;
        int currentEnd=0;
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        for(int[] interval:intervals){
            if(currentEnd<interval[1]){
                currentEnd=interval[1];
            }else{
                ans++;
            }
        }
        return n-ans;
    }
}