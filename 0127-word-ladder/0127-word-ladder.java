class Solution {
    class Pair{
        String word;
        int distance;
        Pair(String _word,int _distance){
            word=_word;
            distance=_distance;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<Pair> q=new ArrayDeque<>();
        q.offerLast(new Pair(beginWord,0));
        Set<String> set=new HashSet<>(wordList.size());
        for(String word:wordList){
            set.add(word);
        }
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            String curWord=p.word;
            int distance=p.distance;
            if(curWord.equals(endWord)){
                return distance+1;
            }
            //every char i should check
            for(int i=0;i<curWord.length();i++){
                StringBuilder sb=new StringBuilder(curWord);
                for(char ch='a';ch<='z';ch++){
                    char original=sb.charAt(i);
                    sb.setCharAt(i,ch);
                    String newString=sb.toString();
                    if(set.contains(newString)){
                        q.offerLast(new Pair(newString,distance+1));
                        set.remove(newString);
                    }
                    sb.setCharAt(i,original);
                }
            }
        }
        return 0;
    }
}