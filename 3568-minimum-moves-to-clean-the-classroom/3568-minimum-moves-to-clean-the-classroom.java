class Solution {
    /*
    */
    class Pair{
        int row;
        int col;
        int energy;
        int mask;
        int distance;
        public Pair(int row,int col,int energy,int mask,int distance){
            this.row=row;
            this.col=col;
            this.energy=energy;
            this.mask=mask;
            this.distance=distance;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int rows=classroom.length;
        int cols=classroom[0].length();
        char[][] grid=new char[rows][cols];
        int startRow=-1;
        int startCol=-1;
        // Give every L a unique bit.
        int[][] litterId = new int[rows][cols];
        for (int[] row : litterId){
            Arrays.fill(row,-1);
        }
        int litterCount=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                char ch=classroom[i].charAt(j);
                grid[i][j]=ch;
                if(ch=='S'){
                    startRow=i;
                    startCol=j;
                }
                if(ch=='L'){
                    litterId[i][j]=litterCount;
                    litterCount++;
                }
            }
        }
        if(litterCount==0){
            return 0;
        }
        /*
         If there are k litter cells
        000 -> none collected
          001 -> litter 0 collected
          010 -> litter 1 collected
          011 -> litter 0 and 1 collected
          ...
         
          When mask == allMask, every L has been collected.
         */
        int allMask=(1<<litterCount)-1;
        boolean[][][][] visited=new boolean[rows][cols][energy+1][1<<litterCount];
        Deque<Pair> q = new ArrayDeque<>();
        q.offerLast(
            new Pair(
                startRow,
                startCol,
                energy,
                0,
                0
            )
        );
        visited[startRow][startCol][energy][0]=true;
        int[][] dirs={
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int row=p.row;
            int col=p.col;
            int curEnergy=p.energy;
            int curDistance=p.distance;
            int curMask=p.mask;
            for(int d[]:dirs){
                int newRow=row+d[0];
                int newCol=col+d[1];
                if(!isValid(newRow,newCol,rows,cols)){
                    continue;
                }
                if(grid[newRow][newCol]=='X') continue;
                int newEnergy=curEnergy-1;
                if(newEnergy<0){
                    continue;
                }
                int newMask=curMask;
                if(grid[newRow][newCol]=='L'){
                    int id=litterId[newRow][newCol];
                    newMask|=(1<<id);
                }
                if(grid[newRow][newCol]=='R'){
                    newEnergy=energy;
                }
                if(newMask==allMask) return curDistance+1;
                if(visited[newRow][newCol][newEnergy][newMask]){
                    continue;
                }
                visited[newRow][newCol][newEnergy][newMask]=true;
                q.offerLast(
                    new Pair(
                        newRow,
                        newCol,
                        newEnergy,
                        newMask,
                        curDistance+1
                    )
                );
            }
        }
        return -1;
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||r>=R||c<0||c>=C) return false;
        return true;
    }
}