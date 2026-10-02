class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        solve(n,0,0,new StringBuilder());
        return ans;
    }
    void solve(int n,int open,int close,StringBuilder sb){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        if(sb.length()>2*n) return;
        if(open<n){
            int curLen=sb.length();
            solve(n,open+1,close,sb.append("("));
            sb.setLength(curLen);
        }
        if(close<open){
            int curLen=sb.length();
            solve(n,open,close+1,sb.append(")"));
            sb.setLength(curLen);
        }
    }
}