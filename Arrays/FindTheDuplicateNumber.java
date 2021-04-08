class Solution {
	
	//Brute-Force
	//Time: O(n^2)
	//Space: O(1)
    public int findDuplicateBruteForce(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=i+1;j<n;j++){
                if(num==nums[j])return num;
            }
        }
        return -1;
    }
	
	//Sorting
	//Time: O(nlogn)
	//Space: O(1)
	public int findDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])return nums[i];
        }
        return -1;
    }
	
	//Count Array
	//Time: O(n)
	//Space: O(n)
	public int findDuplicateCountArray(int[] nums) {
        int n=nums.length;
        int[] count=new int[n+1];
        for(int i=0;i<n;i++){
            count[nums[i]]++;
            if(count[nums[i]]>1)return nums[i];
        }
        return -1;
    }
	
	//Tortoise and Hare
	//Time: O(n)
	//Space: O(1)
	public int findDuplicateTortoiseHare(int[] nums) {
        int hare=nums[0];
        int tortoise=nums[0];
        do{
            tortoise=nums[tortoise];
            hare=nums[nums[hare]];
        }while(hare!=tortoise);
        hare=nums[0];
        while(hare!=tortoise){
            hare=nums[hare];
            tortoise=nums[tortoise];
        }
        return hare;
    }
	
}