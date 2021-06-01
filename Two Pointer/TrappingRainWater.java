class Solution {
	
	//Find rightMax for each index
	//Time: O(n^2)
	//Space: O(1)
    public int trap(int[] nums) {
        int leftMax=0,rightMax=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            rightMax=0;
            for(int j=i+1;j<nums.length;j++){
                rightMax=Math.max(nums[j],rightMax);
            }
            int min=Math.min(leftMax,rightMax);
            sum+=Math.max(min-nums[i],0);
            leftMax=Math.max(nums[i],leftMax);
        }
        return sum;
    }
	
	//With extra rightMax array
	//Time: O(n)
	//Space: O(n)
	 public int trap(int[] nums) {
        int leftMax=0,rightMax=0;
        int sum=0;
        int[] rightMaxArr=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            rightMaxArr[i]=rightMax;
            rightMax=Math.max(nums[i],rightMax);
        }
        for(int i=0;i<nums.length;i++){
            rightMax=rightMaxArr[i];
            int min=Math.min(leftMax,rightMax);
            sum+=Math.max(min-nums[i],0);
            leftMax=Math.max(nums[i],leftMax);
        }
        return sum;
    }
	
	//Two Pointer
	//Time: O(n)
	//Space: O(1)
	public int trap(int[] nums) {
        int left=0,right=nums.length-1;
        int leftMax=0,rightMax=0;
        int sum=0;
        while(left<=right){
            if(nums[left]<=nums[right]){
                if(nums[left]>leftMax){
                    leftMax=nums[left];
                }
                else{
                    sum+=leftMax-nums[left];
                }
                left++;
            }
            else{
                if(nums[right]>rightMax){
                    rightMax=nums[right];
                }
                else{
                    sum+=rightMax-nums[right];
                }
                right--;
            }
        }
        return sum;   
    }
	
}