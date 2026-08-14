class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        int inDegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offerLast(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.pollFirst();
            for(int n:adj[node]){
                inDegree[n]--;
                if(inDegree[n]==0){
                    q.offerLast(n);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]!=0){
                return false;
            }
        }
        return true;
    }
}