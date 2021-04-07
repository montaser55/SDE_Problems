class Solution {
	
	//Sorting
	//Time: O(nlogn)
	//Space: O(1)
    public void sortColorsSorting(int[] nums) {
        Arrays.sort(nums);
    }
	
	//Count and Add to array
	//Time: O(n)
	//Space: o(1)
	public void sortColorsCount(int[] nums) {
        int count1=0,count2=0,count0=0;
        for(int i=0;i<nums.length;i++){
            switch(nums[i]){
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
            }
        }
        int m=0;
        for(int i=0;i<count0;i++){
            nums[m++]=0;
        }
        for(int i=0;i<count1;i++){
            nums[m++]=1;
        }
        for(int i=0;i<count2;i++){
            nums[m++]=2;
        }
    }
	
	//Two pointer
	//Time: O(n)
	//Space: O(1)
	public void sortColorsTwoPointer(int[] nums) {
        int low=0,high=nums.length-1,curr=0;
        while(curr<=high){
            if(nums[curr]==0){
                int temp=nums[low];
                nums[low++]=0;
                nums[curr++]=temp;
            }
            else if(nums[curr]==1){
                curr++;
            }
            else{
                int temp=nums[high];
                nums[high--]=2;
                nums[curr]=temp;
            }
        }
	
	
}