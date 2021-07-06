class Solution {
	
	//Time: O(2^n * k) 
	//Space: O(K*x)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        RecursionSum(candidates,target,result,new ArrayList<>(),0);
        return result;
    }
    
    public void RecursionSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> subset,int index){
        if(index==candidates.length){
            if(target==0){
                result.add(new ArrayList<>(subset));
            }
            return;
        }
        if(candidates[index]<=target){
            subset.add(candidates[index]);
            RecursionSum(candidates, target- candidates[index], result, subset, index);
            subset.remove(subset.size()-1);
        }
        RecursionSum(candidates, target, result, subset, index+1);
    }   
}