class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                if(stack.isEmpty()||stack.peek()!='(')return false;
                stack.pop();
            }else if(ch==']'){
                if(stack.isEmpty()||stack.peek()!='[')return false;
                stack.pop();
            }else if(ch=='}'){
                if(stack.isEmpty()||stack.peek()!='{')return false;
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}