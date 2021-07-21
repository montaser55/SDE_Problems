class Solution {
	
	//Time: O(4^(n*m))
	//Auxiliary Space: O(n*m)
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result=new ArrayList<>();
        Recursion(m,n,result,new String(),0,0);
        if(result.size()==0)result.add("-1");
        return result;
    }
    
    public static void Recursion(int[][] m,int n,ArrayList<String> result,String path,int x,int y){
        if(x<0||y<0||x==n||y==n||m[x][y]==0)return;
        if(x==n-1 && y==n-1){
            result.add(new String(path));
            return;
        }
        m[x][y]=0;
        Recursion(m,n,result,path+"D",x+1,y);
        Recursion(m,n,result,path+"L",x,y-1);
        Recursion(m,n,result,path+"R",x,y+1);
        Recursion(m,n,result,path+"U",x-1,y);
        m[x][y]=1;
    }
}