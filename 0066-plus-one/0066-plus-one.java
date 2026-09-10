class Solution {
    public int[] plusOne(int[] digits) {
        Deque<Integer> dq=new ArrayDeque<>();
        int carry=0;
        if(digits[digits.length-1]==9){
            dq.offerFirst(0);
            carry++;
        }else{
            dq.offerFirst(digits[digits.length-1]+1);
        }
        for(int i=digits.length-2;i>=0;i--){
            if(carry+digits[i]>9){
                carry=1;
                dq.offerFirst(0);
            }else{
                if(carry>0){
                    dq.offerFirst(carry+digits[i]);
                    carry=0;
                }else{
                    dq.offerFirst(digits[i]);
                }
            }
        }
        if(carry>0){
            dq.offerFirst(carry);
        }
        int[] ans=new int[dq.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=dq.pollFirst();
        }
        return ans;
    }
}