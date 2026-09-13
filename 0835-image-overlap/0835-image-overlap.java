class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int ans=0;
        int n=img1.length;
        for(int rowOffset=-n+1;rowOffset<n;rowOffset++){
            for(int columnOffset=-n+1;columnOffset<n;columnOffset++){
                int count=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        int newRow=i+rowOffset;
                        int newColumn=j+columnOffset;
                        if(newRow>=0&&newRow<n&&newColumn<n&&newColumn>=0){
                            if(img1[i][j]==1&&img2[newRow][newColumn]==1){
                                count++;
                            }
                        }
                    }
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}