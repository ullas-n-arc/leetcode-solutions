class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<asteroids.length;i++){
            int num=asteroids[i];
            if(stack.isEmpty()){
                stack.push(num);
            }else if(sameSign(stack.peek(),num)||(num>0&&stack.peek()<0)){
                stack.push(num);
            }else{
               while(!stack.isEmpty()&&num<0&&stack.peek()>0&&Math.abs(num)>stack.peek()){
                    stack.pop();
               }
               if(!stack.isEmpty()){
                    if(!sameSign(num,stack.peek())&&Math.abs(num)==stack.peek()){
                        stack.pop();
                    }else if(sameSign(stack.peek(),num)){
                        stack.push(num);
                    }
               }else{
                stack.push(num);
               }
            }
        }
        int[] result=new int[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }
    boolean sameSign(int x,int y){
        if((x>0&&y>0)||(x<0&&y<0)) return true;
        return false;
    }
}