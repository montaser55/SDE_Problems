class Solution
{
	//BFS (Kahn's Algorithm)
	//Time: O(n+e)
	//Space: O(n)+ O(n)
    static int[] topoSortBfs(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] topo = new int[V];
        int[] inDegree = new int[V];
        
        for(int i=0;i<V;i++){
            for(int n:adj.get(i)){
                inDegree[n]++;
            }
        }
        
        Queue<Integer> q= new LinkedList<Integer>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int index=0;
        while(!q.isEmpty()){
            int n=q.poll();
            
            topo[index++]=n;
            
            for(int i:adj.get(n)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    q.add(i);
                }
            }
        }
        return topo;
    }
	
	//DFS
	//Time: O(n+e)
	//Space: O(n)+O(n)
	static int[] topoSortDfs(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] topo = new int[V];
        boolean[] vis = new boolean[V];
        Stack<Integer> s= new Stack<>();
        
        for(int i=0;i< V;i++){
            if(vis[i]==false){
                topoDfs(i,adj,vis,s);
            }
        }
        
        int ind=0;
        while(!s.isEmpty()){
            topo[ind++]=s.pop();
        }
        return topo;
    }
    
    static void topoDfs(int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> s)
    {
        vis[n] = true;
        
        for(int i:adj.get(n)){
            if(vis[i]==false){
                topoDfs(i,adj,vis,s);
            }
        }
        
        s.push(n);
    }
}

