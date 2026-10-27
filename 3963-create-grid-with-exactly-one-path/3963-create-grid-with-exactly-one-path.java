class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid=new char[m][n];
        for(char[] ch:grid){
            Arrays.fill(ch,'#');
        }
        bfs(0,0,grid);
        String[] result=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(grid[i][j]);
            }
            result[i]=sb.toString();
        }
        return result;
    }
    void bfs(int i,int j,char[][] grid){
        if(i>=grid.length||j>=grid[0].length){
            return;
        }
        grid[i][j]='.';
        if(i==grid.length-1&&j==grid[0].length-1){
            return;
        }
        if(i==grid.length-1){
            bfs(i,j+1,grid);
        }
        if(j==grid[0].length-1){
            bfs(i+1,j,grid);
        }
        int random=new Random().nextInt();
        if(random%2==0){
            bfs(i+1,j,grid);
        }else{
            bfs(i,j+1,grid);
        }
    }
}