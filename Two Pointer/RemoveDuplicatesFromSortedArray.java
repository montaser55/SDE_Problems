class Solution {
	
	//Brute force
	//Time: O(n^2)
	//Space: O(1)
	public int removeDuplicates(int[] nums) {
		if(nums.length==0)return 0;
        int pos=1;
        for(int i=1;i<nums.length;i++){
            boolean isRepeat=false;
            for(int j=0;j<i;j++){
                if(nums[i]==nums[j]){
                    isRepeat=true;
                }
            }
            if(!isRepeat)nums[pos++]=nums[i];
        }
        return pos;
    }
	
	//Two pointer
	//Time: O(n)
	//Space: O(1)
    public int removeDuplicates(int[] nums) {
		if(nums.length==0)return 0;
        int modified=1,curr=1;
        while(curr<nums.length){
            if(nums[curr]!=nums[curr-1]){
                nums[modified++]=nums[curr];
            }
            curr++;
        }
        return modified;
    }
}