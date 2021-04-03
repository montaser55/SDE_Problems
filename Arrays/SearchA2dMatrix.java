class Solution {
	
	//BruteForce
	//Time: O(n^2)
	//Space: O(1)
    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
    }
	
	//RowWiseBinarySearch
	//Time: O(n logm)
	//space: O(1)
	public boolean searchMatrixRowBinarySearch(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            if(binarySearch(matrix[i],0,m-1,target))return true;
            System.out.println();
        }
        return false;
    }
    
    public boolean binarySearch(int[] matrix, int start, int end,int target){
        if(start<=end){
            int mid=(start+end)/2;
            if(matrix[mid]==target)return true;
            else if(matrix[mid]>target)return binarySearch(matrix,start,mid-1,target); 
            else return binarySearch(matrix,mid+1,end,target);
        }
        return false;
    }
	
	//Another variant solution. Row and column sorted separately
	//Time: O(n+m)
	//space: O(1)
    public boolean searchMatrixRowColumnSeparateSort(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int i=0,j=m-1;
        while(i<n && j>=0){
            if(matrix[i][j]==target)return true;
            else if(matrix[i][j]>target)j--;
            else i++;
        }
        return false;
    }
	
	
	//Total Matrix Binary Search
	//Time: O(log n*m)
	//Space: O(1)
	
	public boolean searchMatrixTotalBinary(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int end=n*m;
        return binarySearch(matrix,0,end-1,target);
    }
    
    public boolean binarySearch(int[][]matrix,int start,int end,int target){
        int m=matrix[0].length;
        if(start<=end){
            int mid=(start+end)/2;
            if(matrix[mid/m][mid%m]==target)return true;
            else if(matrix[mid/m][mid%m]>target)return binarySearch(matrix,start,mid-1,target);
            else return binarySearch(matrix,mid+1,end,target);
        }
        return false;
    }
	



}