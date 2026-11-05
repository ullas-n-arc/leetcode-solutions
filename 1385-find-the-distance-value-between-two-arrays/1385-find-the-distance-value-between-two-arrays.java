class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int n=arr1.length;
        int count=0;
        for(int num:arr1){
            int left=0;
            int right=arr2.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(arr2[mid]>=num-d&&arr2[mid]<=num+d){
                    count++;
                    break;
                }else if(arr2[mid]<num-d){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return n-count;
    }
}