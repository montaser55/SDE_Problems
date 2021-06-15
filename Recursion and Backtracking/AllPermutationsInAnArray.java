class Solution{
	
	//Power Set
	//Time: O((2^n)*n)
	//Space: O(2^n)
	
	//Recursion taking and skipping each index
	//Time: O(2^n)+O(nlogn)	
	//Space: O(2^n)
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> result=new ArrayList<>();
        RecursionSum(arr,N,result,0,0);
        Collections.sort(result);
        return result;
    }
    
    void RecursionSum(ArrayList<Integer> arr, int N, ArrayList<Integer> result,int index,int sum){
        if(index==N){
            result.add(sum);
            return;
        }
        RecursionSum(arr,N,result,index+1,sum);
        sum+=arr.get(index);
        RecursionSum(arr,N,result,index+1,sum);
    }
}