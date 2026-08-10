class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        int i=0;
        int left=0;
        for(int right=0;right<n;right++){
            while(dq.size()>0&&nums[dq.peekLast()]<nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(dq.peekFirst()<left){
                dq.pollFirst();
            }
            if(right-left+1==k){
                //valid window
                result[i++]=nums[dq.peekFirst()];
                left++;
            }
            

        }
        return result;
    }
}