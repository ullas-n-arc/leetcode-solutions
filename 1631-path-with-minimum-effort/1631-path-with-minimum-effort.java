class Solution {
    int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        //i will try binary search on answer+bfs
        //i want to minimize effort say k
        int low=0;
        int high=0;
        for(int row[]:heights){
            for(int num:row){
                high=Math.max(high,num);
            }
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isFeasible(heights,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    boolean isFeasible(int[][] heights,int maxEffort){
        int minEffort=0;
        int n=heights.length;
        int m=heights[0].length;
        if(n==1&&m==1) return true;
        Deque<Pair> q=new ArrayDeque<>();
        q.offerLast(new Pair(0,0));
        boolean visited[][]=new boolean[n][m];
        visited[0][0]=true;
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int row=p.row;
            int col=p.col;
            for(int dir[]:dirs){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(isValid(newRow,newCol,n,m)&&visited[newRow][newCol]==false){
                   int diff=Math.abs(heights[row][col]-heights[newRow][newCol]);
                   if(diff<=maxEffort){
                    if(newRow==n-1&&newCol==m-1) return true;
                    visited[newRow][newCol]=true;
                    q.offer(new Pair(newRow,newCol));
                   }
                }
            }
        }
        return false;
    }
    
    boolean isValid(int r,int c,int R,int C){
        if(r>=R||c>=C||r<0||c<0){
            return false;
        }
        return true;
    }
}