class Solution {
    class Pair{
        int val;
        int index;
        Pair(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        //brute force wont work it would become 10^10
        int n=temperatures.length;
        Deque<Pair> stack=new ArrayDeque<>();
        stack.offerLast(new Pair(temperatures[n-1],n-1));
        int[] result=new int[temperatures.length];
        result[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int cur=temperatures[i];
            while(!stack.isEmpty()){
                if(cur>=stack.peekLast().val){
                    stack.pollLast();
                }else{
                    result[i]=stack.peekLast().index-i;
                    break;
                }
            }
            if(stack.isEmpty()){
                result[i]=0;
            }
            stack.offerLast(new Pair(temperatures[i],i));
        }
        return result;  
    }
}