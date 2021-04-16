class Solution {
	
	//Brute Force
	//Time: O(n^2)
	//Space: O(1)
    public int reversePairsBruteForce(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]*2L)count++;
            }
        }
        return count;
    }
	
	//Merge Sort Count
	//Time: O(nlogn)
	//Space: O(n)
	public int reversePairsMergeSort(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    
    public int mergeSort(int[] nums, int start, int end){
        int count=0;
        if(start<end){
            int mid=start+(end-start)/2;
            count+=mergeSort(nums,start,mid);
            count+=mergeSort(nums,mid+1,end);
            count+=merge(nums,start,mid,end);
        }
        return count;
    }
    
    public int merge(int[] nums, int start,int mid,int end){
        int[] left=new int[mid-start+1];
        System.arraycopy(nums,start,left,0,mid-start+1);
        int[] right=new int[end-mid];
        System.arraycopy(nums,mid+1,right,0,end-mid);
        int i=0,j=0,k=start,count=0;
        for(;i<left.length;i++){
            while(j<right.length && left[i]>right[j]*2L){
                j++;
            }
            count+=j;
        }
        i=0;
        j=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                nums[k++]=left[i++];
            }
            else {
                nums[k++]=right[j++];
            }
        }
        while(i<left.length){
            nums[k++]=left[i++];
        }
        while(j<right.length){
            nums[k++]=right[j++];
        }
        return count;
    }
}