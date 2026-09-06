class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] freq = new int[50000];
        int[] firstSeen = new int[50000];
        int[] lastSeen = new int[50000];

        Arrays.fill(firstSeen, -1);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freq[num]++;

            if (firstSeen[num] == -1) {
                firstSeen[num] = i;
            }

            lastSeen[num] = i;
        }
        int degree = -1;
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> elements = new ArrayList<>();
        for(int i=0;i<freq.length;i++){
            if(freq[i]>degree){
                elements.clear();
                degree=freq[i];
                elements.add(i);
            }else if(freq[i]==degree){
                elements.add(i);
            }
        }
        for (int ele : elements) {
            ans = Math.min(ans, lastSeen[ele] - firstSeen[ele]+1);
        }
        return ans;
    }
}