class WordDictionary {
    
    WordDictionary[] child;
    boolean isEnd;
    public WordDictionary() {
        child=new WordDictionary[26];
        isEnd=false;
    }
    
    public void addWord(String word) {
        WordDictionary cur=this;
        for(char ch:word.toCharArray()){
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a']=new WordDictionary();
            }
            cur=cur.child[ch-'a'];
        }
        cur.isEnd=true;
    }
    
    public boolean search(String word) {
       return search(word,0,this);
    }
    private boolean search(String word,int i,WordDictionary cur){
        if(i==word.length()){
            return cur.isEnd;
        }
        char ch=word.charAt(i);
        if(ch!='.'){
            int index=ch-'a';
            if(cur.child[index]==null){
                return false;
            }
            return search(word,i+1,cur.child[index]);
        }
        for(int j=0;j<26;j++){
            if(cur.child[j]!=null&&search(word,i+1,cur.child[j])){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */