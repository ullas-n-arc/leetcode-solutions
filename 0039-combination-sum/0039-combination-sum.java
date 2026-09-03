class Solution {
     List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        solve(candidates,target,new ArrayList<>(),0);//start is needed to prevent duplicate combinations(diff perms)
        return ans;
    }
    void solve(int[] candidates,int target,ArrayList<Integer> list,int start){
        if(target==0){
            ans.add(new ArrayList<>(list));//deep copy
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            solve(candidates,target-candidates[i],list,i);
            list.remove(list.size()-1);
        }
    }
}