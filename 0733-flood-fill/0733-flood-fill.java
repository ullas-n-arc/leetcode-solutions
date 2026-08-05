class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(initialColor!=color)
        dfs(image,sr,sc,initialColor,color);
        return image;
    }
    void dfs(int[][] image,int sr,int sc,int initialColor,int color){
        if(image[sr][sc]==initialColor){
            image[sr][sc]=color;
            int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
            for(int d[]:dir){
                int newRow=sr+d[0];
                int newCol=sc+d[1];
                if(newRow<image.length&&newRow>=0&&newCol<image[newRow].length&&newCol>=0&&image[newRow][newCol]==initialColor){
                    dfs(image,newRow,newCol,initialColor,color);
                }
            }
        }
    }
}