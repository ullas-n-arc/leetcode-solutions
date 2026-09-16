class Solution {
    class DSU{
        int n;
        HashMap<String,Integer> rank;//initially rank shall be 0 for all strings
        HashMap<String,String> parent;//email->parent
        DSU(int n){
            parent=new HashMap<>();
            rank=new HashMap<>();
        }
        String findRepresentative(String email){
            if(!parent.containsKey(email)){
                parent.put(email, email);
                rank.put(email, 0);
                return email;
            }
            if(parent.get(email).equals(email)){
                return email;
            }
            parent.put(email, findRepresentative(parent.get(email)));
            return parent.get(email);
        }
        void unionByRank(String e1,String e2){
            String uPU=findRepresentative(e1);
            String uPV=findRepresentative(e2);
            if(uPU.equals(uPV)) return;
            if(!rank.containsKey(uPU)&&!rank.containsKey(uPV)){
                rank.put(uPU,1);
                rank.put(uPV,0);
                parent.put(uPV,uPU);
                
            }else if(!rank.containsKey(uPU)){
                rank.put(uPU,0);
                parent.put(uPU,uPV);
            }else if(!rank.containsKey(uPV)){
                rank.put(uPV,0);
                parent.put(uPV,uPU);
            }else if(rank.get(uPU)<rank.get(uPV)){
                parent.put(uPU,uPV);
            }else if(rank.get(uPU)>rank.get(uPV)){
                parent.put(uPV,uPU);
            }else{
                parent.put(uPV,uPU);
                rank.put(uPU,rank.get(uPU)+1);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashSet<String> uniq=new HashSet<>();
        HashMap<String, String> emailToName = new HashMap<>();
        for(List<String> list:accounts){
            String name = list.get(0);
            for(int i=1;i<list.size();i++){
                String email=list.get(i);
                uniq.add(email);
                emailToName.put(email,name);
            }
        }
        DSU dsu=new DSU(uniq.size());
        for(List<String> list:accounts){
            for(int i=1;i<list.size()-1;i++){
                dsu.unionByRank(list.get(i),list.get(i+1));
            }
        }
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> groups=new HashMap<>();
        for(String email:uniq){
            String representative=dsu.findRepresentative(email);
            groups.computeIfAbsent(representative,k-> new ArrayList<>());
            groups.get(representative).add(email);
        }
        for (Map.Entry<String, ArrayList<String>> entry: groups.entrySet()) {

            ArrayList<String> emails = entry.getValue();

            Collections.sort(emails);

            String name = emailToName.get(emails.get(0));

            ArrayList<String> account = new ArrayList<>();

            account.add(name);
            account.addAll(emails);

            ans.add(account);
        }
        return ans;
        //one hell of a problem
    }
}