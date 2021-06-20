class Solution {
	
	//Time: O(2^n * n) [n time to put in a new arraylist]
	//Space: O(2^n)*O(k) [2^n lists with k length average]
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        RecursionSubset(nums,result,new ArrayList<>(),0);
        return result;
    }
    
    void RecursionSubset(int[] nums, List<List<Integer>> result, List<Integer> subset,int index){
        result.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]){continue;}
            subset.add(nums[i]);
            RecursionSubset(nums,result,subset,i+1);
            subset.remove(subset.size()-1);
        }
        
    }
}