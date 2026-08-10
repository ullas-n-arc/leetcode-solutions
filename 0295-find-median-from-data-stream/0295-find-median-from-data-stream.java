class MedianFinder {
    /*
    iam preferring to store median in left side (thats why max heap stores num<=peek)
    */
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
       max =new PriorityQueue<>(Collections.reverseOrder());//i neeed tha max in all minimums4
       min=new PriorityQueue<>();//min in all the max elements
    }
    
    public void addNum(int num) {
        if(max.size()==0){
            max.offer(num);
        }else if(num<=max.peek()){
            max.offer(num);
        }else{
            min.offer(num);
        }
        //rebalnce at any point of time the size diffference should not cross 1 
        //and also as iam storing median in left part of the array (max heap) hence min heap //should always be less in size than max heap
        if(max.size()-min.size()>1){
            int ele=max.poll();
            min.offer(ele);
        }else if(max.size()<min.size()){
            int ele=min.poll();
            max.offer(ele);
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            return ((double)(max.peek()+min.peek())/2);
        }else{
            return (double)max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */