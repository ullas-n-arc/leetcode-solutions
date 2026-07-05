class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque();
        int ans=0;
        for(String token:tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int val2=stack.pollLast();
                int val1=stack.pollLast();
                if(token.equals("+")){
                    ans=(val1+val2);
                }else if(token.equals("-")){
                    ans=(val1-val2);
                }else if(token.equals("*")){
                    ans=(val1*val2);
                }else{
                    ans=(val1/val2);
                }
                stack.offerLast(ans);
            }else{
                stack.offerLast(Integer.parseInt(token));
            }
        }
        return stack.pollLast();
    }
}