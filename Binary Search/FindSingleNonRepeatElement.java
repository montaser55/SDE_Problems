class Solution {
	
	//Time: O(n)
	//Space: O(1)
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==0)return -1;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        return xor;
    }
	
	//Time: O(logn)
	//Space: O(1)
	public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(mid%2==0 && nums[mid]==nums[mid+1]||mid%2==1 && nums[mid]==nums[mid-1]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return nums[low];
    }
}