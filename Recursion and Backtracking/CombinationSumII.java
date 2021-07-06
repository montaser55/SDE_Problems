class Solution {
	
	//Time: O(2^n *k)
	//Space: O(k*x)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        RecursionCombinationSum(candidates, target, new ArrayList<>(),result,0);
        return result;
    }
    
    public void RecursionCombinationSum(int[] candidates, int target, List<Integer> subset, List<List<Integer>> result, int index){
        if(target==0){
            result.add(new ArrayList<>(subset));
            return;
        }
                
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])continue;
            if(candidates[i]>target)break;
            subset.add(candidates[i]);
            RecursionCombinationSum(candidates, target-candidates[i],subset,result,i+1);
            subset.remove(subset.size()-1);
            
        }
    }
}