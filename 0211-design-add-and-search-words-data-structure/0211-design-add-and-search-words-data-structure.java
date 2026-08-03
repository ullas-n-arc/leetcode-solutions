class Trie{
    Trie[] child;
    boolean isEnd;
    public Trie(){
        child=new Trie[26];
        isEnd=false;
    }
    void insert(String word){
        Trie cur=this;
        for(char ch:word.toCharArray()){
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a']=new Trie();
            }
            cur=cur.child[ch-'a'];
        }
        cur.isEnd=true;
    }
    boolean search(String word){
        return search(word,0,this);
    }
    private boolean search(String word,int i,Trie cur){
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
class WordDictionary {
    Trie myTrie;
    public WordDictionary() {
        myTrie=new Trie();
    }
    
    public void addWord(String word) {
        myTrie.insert(word);
    }
    
    public boolean search(String word) {
        return myTrie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */