class Trie {
    Trie[] child;
    boolean isEnd;
    public Trie() {
        child=new Trie[26];
        isEnd=false;
    }
    
    public void insert(String word) {
        Trie cur=this;
        for(char ch:word.toCharArray()){
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a']=new Trie();
            }
                cur=cur.child[ch-'a'];
        }
        cur.isEnd=true;
    }
    
    public boolean search(String word) {
        Trie cur=this;
        for(char ch:word.toCharArray()){
            if(cur.child[ch-'a']==null)return false;
            cur=cur.child[ch-'a'];
        }
        if(cur.isEnd==true){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        Trie cur=this;
        for(char ch:prefix.toCharArray()){
            if(cur.child[ch-'a']==null) return false;
            cur=cur.child[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */