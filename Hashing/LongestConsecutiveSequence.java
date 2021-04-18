class Solution {
	
	//Sort and compare
	//Time: O(nlogn)
	//Space: O(1)
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,max=0,count=0;
        for(int i=0;i<n;i++){
            if(i==0 || nums[i-1]+1==nums[i]){
                count++;
            }
            else if(nums[i-1]==nums[i]){
                continue;
            }
            else{
                max=Math.max(count,max);
                count=1;
            }
        }
        max=Math.max(count,max);
        return max;
    }
	//Hashing and Find
	//Time: O(n)
	//Space: O(n)
	public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }
        int max=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            else{
                int temp=nums[i];
                count=1;
                while(set.contains(temp+1)){
                    temp++;
                    count++;
                }
                max=Math.max(count,max);
            }
        }
        return max;
    }
}