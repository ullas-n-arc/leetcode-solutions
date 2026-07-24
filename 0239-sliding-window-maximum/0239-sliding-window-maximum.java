class Solution {
    class Pair{
        int element;
        int index;
        Pair(int element,int index){
            this.element=element;
            this.index=index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeSet<Pair> set=new TreeSet<>((x,y)->{
            if(x.element!=y.element){
                return Integer.compare(y.element,x.element);
            }
            return Integer.compare(x.index,y.index);
        });
        int result[]=new int[nums.length-k+1];
        int i=0;
        int j=0;
        int idx=0;
        while(j<nums.length){
            set.add(new Pair(nums[j],j));
            if(j-i+1==k){
                Pair p=set.first();
                result[idx++]=p.element;//i want the element at index 0
                set.remove(new Pair(nums[i],i));//i want to remove element at index i
                i++;
            }
            j++;
        }
        return result;
    }
}