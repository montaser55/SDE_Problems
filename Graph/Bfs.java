class Solution {
	
    //Time: O(n)
	//Space: O(n)
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[V];
        
        q.add(0);
        vis[0]=true;
        
        while(!q.isEmpty()){
            Integer node= q.poll();
            bfs.add(node);
            
            for(Integer n:adj.get(node)){
                if(vis[n]==false){
                    q.add(n);
                    vis[n]=true;
                }   
            }
        }
        return bfs;
    }
}