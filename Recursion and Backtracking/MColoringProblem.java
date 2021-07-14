class solve 
{
	//Time: O(M^N) [N=G.length]
	//Space: O(N)
    public static boolean isSafe(List<Integer>[] G, int index, int[] color,int expectedColor){
        List<Integer> curr=G[index];
        for(int i=0;i<curr.size();i++){
            if(color[curr.get(i)]==expectedColor){
                return false;
            }
        }
        return true;
    }
    
    public static boolean Recursion(List<Integer>[] G, int[] color, int index, int M){
        if(index==G.length){
            return true;
        }
        
        for(int i=1;i<=M;i++){
            if(isSafe(G,index,color,i)){
                color[index]=i;
                if(Recursion(G,color,index+1,M)==true)return true;
                color[index]=0;
            }
        }
        return false;
    }
    
	public static boolean graphColoring(List<Integer>[] G, int[] color, int M) 
    {
        return Recursion(G,color,0,M);
    }
}