class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                StringBuilder temp=new StringBuilder();
                while(!stack.isEmpty()){
                    char c=stack.pop();
                    if(c!='('){
                        temp.append(c);
                    }else{
                        break;
                    }
                }
                for (int i=0;i<temp.length();i++){
                    stack.push(temp.charAt(i));
                }
            }else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            char c=stack.pop();
            if(c!='('){
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}