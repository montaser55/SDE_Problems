class Solution {
	
    //Time: O(n+e)
	//Space: O(n+e)+O(n)+O(n)
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs=new ArrayList<>();
        boolean vis[]=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs.add(i);
                vis[i]=true;
                dfs(adj,dfs,vis,i);
            }
        }
        return dfs;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs,boolean[] vis,int n){
        for(int i:adj.get(n)){
            if(vis[i]==false){
                dfs.add(i);
                vis[i]=true;
                dfs(adj,dfs,vis,i);
            }
        }
    }
}