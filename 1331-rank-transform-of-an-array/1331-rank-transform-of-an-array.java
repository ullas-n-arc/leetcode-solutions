class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0) return new int[]{};
        int[][] twod=new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            twod[i][0]=i;
            twod[i][1]=arr[i];
        }
        Arrays.sort(twod,(a,b)->a[1]-b[1]);

        int[] ans=new int[arr.length];
        int rank=1;
        ans[twod[0][0]]=rank;
        for(int i=1;i<arr.length;i++){
            if(twod[i][1]!=twod[i-1][1]){
                rank++;
            }
                ans[twod[i][0]]=rank;
        }
        return ans;
    }
}