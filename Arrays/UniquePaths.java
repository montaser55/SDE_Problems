class Solution {
	
	//Recursion
	//Time: O(2^max(m,n))
	//Space: O(2^max(m,n))
    public int uniquePathsRecursive(int m, int n) {
        return countPaths(m,n,0,0);
    }
    
    public int countPaths(int m,int n,int i,int j){
        if(i==m-1 && j==n-1)return 1;
        else if(i>=m || j>=n)return 0;
        else return countPaths(m,n,i+1,j)+countPaths(m,n,i,j+1);
    }
	
	//DP Recursion
	//Time: O(m*n)
	//Space: O(m*n)
	public int uniquePathsDPRecursion(int m, int n) {
        int[][] dp=new int[m][n];
        return countPaths(m,n,0,0,dp);
    }
    
    public int countPaths(int m,int n,int i,int j,int[][] dp){
        if(i==m-1 && j==n-1)return 1;
        else if(i>=m || j>=n)return 0;
        
        if (dp[i][j]!=0)return dp[i][j];
        else return dp[i][j]=countPaths(m,n,i+1,j,dp)+countPaths(m,n,i,j+1,dp);
    }
	
	//DP Iterative
	//Time: O(m*n)
	//Space: O(m*n)
	public int uniquePathsDPIterative(int m, int n) {
        int[][] dp=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0)dp[i][j]=1;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];              
            }
        }
        return dp[m-1][n-1];
    }
	
	//Combination 
	//Time: O(min(m,n))
	//Space: O(1)
	public int uniquePathsCombination(int m, int n) {
        long result=1;
        int min=Math.min(m,n);
        int numerator=m+n-2;
        for(int i=0;i<min-1;i++){
            result*=numerator--;
            result/=(i+1);
        }
        return (int)result;
    }
	
	
}