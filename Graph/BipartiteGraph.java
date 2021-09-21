class Solution
{
	//BFS
	//Time: O(n+e)
	//Space: O(n)+O(n)
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color= new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;
        }
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!bfsCheck(i,adj,color)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bfsCheck(int n, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q= new LinkedList<>();
        
        q.add(n);
        color[n]=0;
        
        while(!q.isEmpty()){
            int node= q.poll();
            
            for(int i:adj.get(node)){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.add(i);
                }
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        
        return true;
    }
	
	//DFS
	//Time: O(n+e)
	//Space: O(n)
	public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color= new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;
        }
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!dfsCheck(i,-1,adj,color))return false;
            }
        }
        return true;
    }
    
    public boolean dfsCheck(int n,int parent,ArrayList<ArrayList<Integer>> adj, int[] color){
        if(parent==-1){color[n]=0;}
        else{
            color[n]=1-color[parent];
        }
        
        for(int i:adj.get(n)){
            if(color[i]==-1){
                if(!dfsCheck(i,n,adj,color))return false;
            }
            else if(color[i]==color[n]){
                return false;
            }
        }
        
        return true;
    }
}