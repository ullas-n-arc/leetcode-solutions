class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Deque<Integer> stack=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        int[] teleport=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                teleport[i]=stack.peek();
                teleport[stack.pop()]=i;
            }
        }
        int i=0;
        boolean forward=true;
        while(n>0){
            if(s.charAt(i)=='('){
                i=teleport[i];
                forward=!forward;
            }else if(s.charAt(i)==')'){
                i=teleport[i];
                forward=!forward;
            }
            if(s.charAt(i)=='('||s.charAt(i)==')'){
                //do nothing
            }else{
            sb.append(s.charAt(i));
            }
            if(forward){
                i=i+1;
            }else{
                i=i-1;
            }
            n--;
        }
        return sb.toString();
    }
}