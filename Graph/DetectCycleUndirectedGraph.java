class Solution {
	
	//DFS
    //Time: O(N+E)
	//Space: O(N)
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(Cycle(i,-1,adj,vis)==true)return true;
            }
        }
        return false;
    }
    
    public boolean Cycle(int n, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[n]=true;
        for(int i:adj.get(n)){
            if(vis[i]==false){
                if(Cycle(i,n,adj,vis)==true)return true;
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
}