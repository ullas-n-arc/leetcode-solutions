class MyHashSet {
    int m=(int)1e6+7;
    boolean arr[];
    public MyHashSet() {
        arr=new boolean[m];
    }
    
    public void add(int key) {
        int k=key%m;
        arr[k]=true;
    }
    
    public void remove(int key) {
        int k=key%m;
        arr[k]=false;
    }
    
    public boolean contains(int key) {
        int k=key%m;
        return arr[k];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */