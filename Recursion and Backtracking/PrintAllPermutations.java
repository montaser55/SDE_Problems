class Solution {
	
	
	//Recursion through array each time with a freq map
	//Time: o(n!*n)
	//Space: O(n)+O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Recursion(nums,new ArrayList<>(),result,new boolean[nums.length]);
        return result;
    }
    
    public void Recursion(int[] nums, List<Integer> subset, List<List<Integer>> result, boolean[] freq){
        if(subset.size()==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(freq[i]==false){
                freq[i]=true;
                subset.add(nums[i]);
                Recursion(nums,subset,result,freq);
                subset.remove(subset.size()-1);
                freq[i]=false;
            }
        }
        
    }
	
	//Swap the initial array. Save space.
	//Time: O(n!*n)
	//Space: O(1)
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Recursion(nums,result,0);
        return result;
    }
    
    public void Recursion(int[] nums, List<List<Integer>> result, int index){
        if(index==nums.length){
            List<Integer> subset=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                subset.add(nums[i]);
            }
            result.add(subset);
            return;
        }
        
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            Recursion(nums,result,index+1);
            swap(nums,index,i);
        }
    }
    
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}