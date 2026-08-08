class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ans=-1;
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid+1]>arr[mid]){
                //increasing
                ans=mid+1;
                left=mid+1;
            }else{
                right=mid;
            }
            
        }
        return ans;
    }
}