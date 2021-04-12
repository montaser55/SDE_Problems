class Solution {
	//Using Brute Force
	//Time: O(n!*n)[n! permutation each with n elements]
	//Space: O(n!)
	
	
	//Lexilogical Order Method
	//Time: O(n)
	//Space: O(1)
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n<=1)return;
        int i,k;
        for(i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1])break;    
        }
        if(i>=0){
            for(k=n-1;k>i;k--){
                if(nums[k]>nums[i])break;
            }
            swap(nums,i,k);
        }
        reverse(nums,i+1);
    }
    
    public void swap(int[] nums,int n, int m){
        int temp=nums[n];
        nums[n]=nums[m];
        nums[m]=temp;
    }
    
    public void reverse(int[] nums,int i){
        int n=nums.length-1;
        while(i<n){
            swap(nums,i++,n--);
        }
    }
}