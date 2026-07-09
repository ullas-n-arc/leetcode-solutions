class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] components=new int[n];
        int compId=0;
        components[0]=compId;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]>maxDiff){
                compId++;
            }
            components[i]=compId;
        }
        int k=0;
        boolean[] ans=new boolean[queries.length];
        for(int[] query:queries){
            int u=query[0];
            int v=query[1];
            ans[k++]=(components[u]==components[v]);
        }
        return ans;
    }
}