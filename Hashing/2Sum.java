class Solution {
	
	//Brute Force
	//Time: O(n^2)
	//Space: O(1)
    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)return new int[]{i,j};
            }
        }
        return new int[]{0};
    }
	
	//Hash Map Traversal Twice
	//Time: O(n)
	//Space: O(1)
	public int[] twoSumHashMapTwice(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[]{0};
    }
	
	//Hash Map Single Loop
	//Time: O(n)
	//Space: O(n)
	public int[] twoSumHashMap(int[] nums, int target) {
       Map<Integer,Integer> map=new HashMap<Integer,Integer>();
       for(int i=0;i<nums.length;i++){
           int complement=target-nums[i];
           if(map.containsKey(complement)){
               return new int[]{i,map.get(complement)};
           }
           map.put(nums[i],i);
       } 
       return new int[]{0}; 
    }
}