class Solution {

    List<List<Integer>> adj = new ArrayList<>();
    int[] vis;

    int[] inTime;
    int[] outTime;

    List<Integer> sequence = new ArrayList<>();

    int[] parent;
    int[] depth;

    void dfs(int node, String s, int d) {
        vis[node] = 1;
        depth[node] = d;

        inTime[node] = sequence.size();
        sequence.add(1 << (s.charAt(node) - 'a'));

        for (int x : adj.get(node)) {
            if (vis[x] == 0) {
                parent[x] = node;
                dfs(x, s, d + 1);
            }
        }

        outTime[node] = sequence.size();
        sequence.add(1 << (s.charAt(node) - 'a'));
    }

    int[] segmentTree;
    void buildSegment(int idx,int l,int r)
    {

        if(l > r) return;

        if(l == r)
        {
            segmentTree[idx] = sequence.get(l);

            return;
        }

        int mid = l + (r - l)/2;

        buildSegment(2*idx + 1,l,mid);
        buildSegment(2*idx + 2,mid + 1,r);

        segmentTree[idx] = segmentTree[2*idx + 1]^segmentTree[2*idx + 2];

        return;
    }

    void updateSegment(int idx,int l ,int r,int node,char ch)
    {
        if(l == r && l == node)
        {
            segmentTree[idx] = 1 << (int)(ch - 'a');
            return;
        }

        int mid = l + (r - l)/2;

        if(node <= mid) updateSegment(2*idx + 1,l,mid,node,ch);
        else updateSegment(2*idx + 2,mid + 1,r,node,ch);

        segmentTree[idx] = segmentTree[2*idx + 1]^segmentTree[2*idx + 2];

        return;
    }

    int rangeQuery(int idx,int l,int r,int L,int R)
    {
        if(L <= l && r <= R) return segmentTree[idx];

        int mid = l + (r - l)/2;

        int left = 0;
        int right = 0;
        if(L <= mid) left = rangeQuery(2*idx + 1,l,mid,L,R);
        if(mid < R) right = rangeQuery(2*idx + 2,mid + 1,r,L,R);

        return left^right;
    }

    int commonAncestor(int u,int v,int[][] lca)
    {
        if(u == v) return u;

        int res = -1;

        for(int i = 16; i >= 0; i--)
        {
            if(lca[u][i] != lca[v][i])
            {
                res = commonAncestor(lca[u][i],lca[v][i],lca);
                break;
            }
        }

        if(res == -1) res = lca[u][0];

        return res;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        
        inTime = new int[n];
        outTime = new int[n];

        vis = new int[n];

        parent = new int[n];
        depth = new int[n];

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] x : edges)
        {
            int u = x[0];
            int v = x[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0,s,0);

        segmentTree = new int[4*sequence.size()];

        buildSegment(0,0,sequence.size() - 1);

        int[][] lca = new int[n][17];

        for(int i = 0; i < n; i++) lca[i][0] = parent[i];

        for(int i = 1; i < 17; i++)
        {
            for(int j = 0; j < n; j++)
            {
                lca[j][i] = lca[lca[j][i - 1]][i - 1];
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(String x : queries)
        {
            if(x.charAt(0) == 'u')
            {
                int node = 0;
                int i = 7;

                while(x.charAt(i) != ' ')
                {
                    int val = (int)(x.charAt(i) - '0');

                    node = node*10 + val;

                    i++;
                }

                char ch = x.charAt(x.length() - 1);
                updateSegment(0,0,sequence.size()- 1,inTime[node],ch);
                updateSegment(0,0,sequence.size()- 1,outTime[node],ch);
            }
            else{
                int node = 0;
                int i = 6;

                while(x.charAt(i) != ' ')
                {
                    int val = (int)(x.charAt(i) - '0');

                    node = node*10 + val;

                    i++;
                }

                i++;
                int node2 = 0;
                while(i < x.length() && x.charAt(i) != ' ')
                {
                    int val = (int)(x.charAt(i) - '0');

                    node2 = node2*10 + val;

                    i++;
                }

                int xor1 = rangeQuery(0,0,sequence.size() - 1,0,inTime[node]);
                int xor2 = rangeQuery(0,0,sequence.size() - 1,0,inTime[node2]);

                int diff = Math.abs(depth[node] - depth[node2]);
                if(diff != 0)
                {
                    if(depth[node] > depth[node2])
                    {
                        List<Integer> bits = new ArrayList<>();
                        while(diff > 0)
                        {
                            if(diff % 2 == 1) bits.add(1);
                            else bits.add(0);

                            diff /= 2;
                        } 

                        for(int idx = bits.size() - 1; idx >= 0; idx--)
                        {
                            if(bits.get(idx) == 1) node = lca[node][idx];
                        }
                    }
                    else
                    {
                        List<Integer> bits = new ArrayList<>();
                        while(diff > 0)
                        {
                            if(diff % 2 == 1) bits.add(1);
                            else bits.add(0);

                            diff /= 2;
                        } 

                        for(int idx = bits.size() - 1; idx >= 0; idx--)
                        {
                            if(bits.get(idx) == 1) node2 = lca[node2][idx];
                        }
                    }
                }

                int LCA = commonAncestor(node,node2,lca);
                int LCAXOR = rangeQuery(0,0,sequence.size() - 1,inTime[LCA],inTime[LCA]);

                int actualXOR = xor1^xor2^LCAXOR;

                if(((actualXOR)&(actualXOR - 1)) == 0) res.add(true);
                else res.add(false);
            }
        }

        return res;
    }
}