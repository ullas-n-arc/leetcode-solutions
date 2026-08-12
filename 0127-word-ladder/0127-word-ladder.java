class Solution {
    class Pair{
        String word;
        int length;
        Pair(String word,int length){
            this.word=word;
            this.length=length;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> mySet=new HashSet<>();
        for(String s:wordList){
            mySet.add(s);
        }
        Deque<Pair> q=new ArrayDeque<>();
        q.offerLast(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            String word=p.word;
            if(word.equals(endWord)){
                return p.length;
            }
            for(int i=0;i<word.length();i++){
                //explore a to z
                StringBuilder sb=new StringBuilder(word);
                for(int j=0;j<26;j++){
                    char curChar=sb.charAt(i);
                    sb.setCharAt(i,(char)(j+'a'));
                    String newString=sb.toString();
                    if(mySet.contains(newString)){
                        q.offerLast(new Pair(newString,p.length+1));
                        mySet.remove(newString);
                    }
                    sb.setCharAt(i,curChar);
                }
            }
        }
        return 0;
    }

}