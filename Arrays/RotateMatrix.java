class Solution {
	//Changing_manually
	//Time: O(n^2)
	//Space: O(1)
	public void rotateEquation(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
        
    }
	//Transpose_then_rotate
	//Time: O(n^2)
	//Space: O(1)
    public void rotateTranspose(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    
    public void transpose(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
    
    public void reverse(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][n-j-1];
                matrix[i][n-1-j]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}