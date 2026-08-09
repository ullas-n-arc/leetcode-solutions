class Solution {
    class Pair{
        int row,col,newColor,oldColor;
        Pair(int row,int col,int newColor,int oldColor){
            this.row=row;
            this.col=col;
            this.newColor=newColor;
            this.oldColor=oldColor;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        Deque<Pair> q=new ArrayDeque<>();
        q.offerLast(new Pair(sr,sc,color,image[sr][sc]));
        image[sr][sc]=color;
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int r=p.row;
            int c=p.col;
            int newColor=p.newColor;
            int oldColor=p.oldColor;
            int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
            for(int d[]:dir){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0&&row<image.length&&col>=0&&col<image[row].length&&image[row][col]==oldColor){
                    image[row][col]=newColor;
                    q.offerLast(new Pair(row,col,newColor,oldColor));
                }
            }
        }
        return image;
    }
    
}