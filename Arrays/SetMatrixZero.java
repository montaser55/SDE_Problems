class Solution {
	
	//Brute-Force
	//Time: O((n*m)*(n+m))
	//Space: O(1)
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    for(int k=0;k<m;k++){
                        if(matrix[i][k]!=0)matrix[i][k]=-999;
                    }
                    for(int k=0;k<n;k++){
                        if(matrix[k][j]!=0)matrix[k][j]=-999;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-999)matrix[i][j]=0;
            }
        }
    }
	
	//Extra Array
	//Time: O(n*m)
	//Space: O(n+m)
	public void setZeroesExtraArray(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] row=new int[n];
        int[] col=new int[m];
        for(int i=0;i<n;i++){
            for(ixnt j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1||col[j]==1)matrix[i][j]=0;
            }
        }
    }
	
	//Within Matrix
	//Time: O(n*m)
	//Space: O(1)
	public void setZeroesNoExtraArray(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean firstCol=false;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){firstCol=true;break;}
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)matrix[i][j]=0;
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(firstCol){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        
    }
}