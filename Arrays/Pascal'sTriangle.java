class Solution {
	
	//Brute-Force
	//Time: O(n^2)
	//Space: O(n^2)
    public List<List<Integer>> generateBruteForce(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> curr,pre=null;
        for(int i=0;i<numRows;i++){
            curr=new ArrayList<Integer>();
            for(int j=0;j<i+1;j++){
                if(j==0||j==i){
                    curr.add(1);
                }
                else{
                    curr.add(pre.get(j-1)+pre.get(j));
                }
            }
            result.add(curr);
            pre=curr;
        }
        return result;
    }
	
	//Only one value
	//Time: O(n)
	//Space: O(1)
	public static int generateOneValue(int row,int col) {
        int result=1;
        for(int i=1;i<col;i++){
            result*=--row;
            result/=i;
        }
        return result;
    }
	
	//Only one row
	//Time: O(n)
	//Space: O(n)
	public List<Integer> generateOneRow(int Row) {
        List<Integer> row=new ArrayList<Integer>();
        int result=1;
        row.add(result);
        for(int i=1;i<Row;i++){
            result*=--Row;
            result/=i;
            row.add(result);
        }
        return row;   
    }
}