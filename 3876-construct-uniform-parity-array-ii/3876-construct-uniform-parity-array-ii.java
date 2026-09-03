class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0];
        int oddCount=0;
        for(int num:nums1){
            min=Math.min(num,min);
            if(num%2==1) oddCount++;
        }
        if(min%2==1){
            //if min is odd then we cant convert it to even so we have to make all elements as odd
            //odd-even=odd
            //so i have to conver even number as odd
            //even-odd=odd 
            return true;
        }else{
            //min is even then we cant make every element as odd
            //even-odd=odd(not possible)
            //only all even is possible
            //even-even=even
            // so if there is atleast 1 odd then it is not possible to make it even 
            if(oddCount>0) return false;
            return true;
        }
    }
}