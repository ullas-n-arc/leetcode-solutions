class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans=new int[numCourses];
        int j=0;
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        int[] inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offerLast(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.pollFirst();
            ans[j++]=node;
            for(int n:adj[node]){
                inDegree[n]--;
                if(inDegree[n]==0){
                    q.offerLast(n);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]!=0){
                return new int[]{};
            }
        }
        return ans;
    }
}