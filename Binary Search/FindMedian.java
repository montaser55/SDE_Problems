public class Solution {
	
	//Time: O(32*n*log2 m);
	//Space: O(1)
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low=Math.min(low,A.get(i).get(0));
            high=Math.max(high,A.get(i).get(m-1));
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int count=0;
            for(int i=0;i<n;i++){
                count+=countNumberLessThanMidinArray(A.get(i),mid);
            }
            if(count<=(n*m)/2)low=mid+1;
            else high=mid-1;
        }
        return low;
    }

    public int countNumberLessThanMidinArray(ArrayList<Integer> A,int value){
        int low=0;
        int high=A.size()-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(A.get(mid)<=value){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}
