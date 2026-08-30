class Solution {
    int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
    class Pair{
        int row;
        int col;
        int effort;
        Pair(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
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
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.effort,b.effort));
        pq.offer(new Pair(0,0,0));
        int[][] effort=new int[n][m];
        for(int row[]:effort)Arrays.fill(row,Integer.MAX_VALUE);
        effort[0][0]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int row=p.row;
            int col=p.col;
            int curEffort=p.effort;
            for(int dir[]:dirs){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(isValid(newRow,newCol,n,m)){
                    int newEffort=Math.max(curEffort,Math.abs(heights[row][col]-heights[newRow][newCol]));
                    if(newEffort<effort[newRow][newCol]){
                        effort[newRow][newCol]=newEffort;
                        pq.offer(new Pair(newRow,newCol,newEffort));
                    }
                }
            }
        }
        return effort[n-1][m-1]<=maxEffort;
    }
    
    boolean isValid(int r,int c,int R,int C){
        if(r>=R||c>=C||r<0||c<0){
            return false;
        }
        return true;
    }
}