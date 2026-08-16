class Solution {
    public boolean stoneGameIX(int[] stones) {
        int count[]=new int[3];
        //3 possible remainders 0,1,2
        //if remainder is 1 dont choose 2 
        //if cur remainder is 2 dont choose 1
        for(int n:stones){
            count[n%3]++;
        }
        int a=count[1];//remainder 1
        int b=count[2];//remainder 2
        int c=count[0];//remainder 0
        if(a==0&&b==0){
            return false;
        }
        //if no. of 0's is even it does not change winner
        //if it is odd it decides which player get curcial turn
        if(c%2==0){
            return a>0&&b>0;
        }
        return Math.abs(a-b)>2;
    }
}