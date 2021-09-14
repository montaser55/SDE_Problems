class Solution {
    
	//DFS
	//Time: O(n+e)
	//Space: O(2n)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] dfsVis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if (Cycle(i,adj,vis,dfsVis)==true)return true;
            }
        }
        return false;
        
    }
    
    public boolean Cycle(int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVis){
        vis[n]=true;
        dfsVis[n]=true;
        
        for(int i:adj.get(n)){
            if(vis[i]==false){
                if(Cycle(i,adj,vis,dfsVis)==true)return true;
            }
            else if(dfsVis[i]==true){
                return true;
            }
        }
        
        dfsVis[n]=false;
        return false;
    }
}