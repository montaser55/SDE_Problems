class Solution {

	//Brute-Force (start, end, doSum. Three loops)
	//Time: O(n^3)
	//Space: O(1)
    public int maxSubArrayThreeLoop(int[] nums) {
        int n=nums.length;
        int maxSum=nums[0];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=nums[k];
                }
                maxSum=Math.max(sum,maxSum);
            }
        }
        return maxSum;
    }
	
	
	//Brute-Force (Start and end loop)
	//Time: O(n^2)
	//Space: O(1)
	public int maxSubArrayTwoLoop(int[] nums) {
        int n=nums.length,sum=0,maxSum=nums[0];
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                maxSum=Math.max(sum,maxSum);
            } 
        }
        return maxSum;
    }
	
	//Kadane's Algorithm
	//Time: O(n)
	//Space: O(1)
	public int maxSubArrayKadanesAlgorithm(int[] nums) {
        int n=nums.length,maxSum=nums[0],sum=nums[0];
        for(int i=1;i<n;i++){
            sum=Math.max(nums[i],sum+nums[i]);
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
	
}