class Solution {
	
	//Sort Triple loop with Binary search for last element
	//Time: O(nlogn+n^3 logn)
	//Space: O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Set<List<Integer>> set=new HashSet<List<Integer>>();
        List<Integer> quad;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n-1;k++){
                    int complement=target-nums[i]-nums[j]-nums[k];
                    if(binarySearch(nums,complement,k+1,n-1)){
                        quad=new ArrayList<Integer>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add(complement);
                        if(!set.contains(quad)){
                            result.add(quad);
                            set.add(quad);
                        }
                    }
                }
            }
        }
        return result;
        
        
    }
    
    public boolean binarySearch(int[] nums, int target, int start,int end){
        if(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target)return true;
            else if(nums[mid]>target) return binarySearch(nums,target,start,mid-1);
            else return binarySearch(nums,target,mid+1,end);
        }
        return false;
    }
	
	//Two loop and two pointer
	//Time: O(n^3)
	//Space: O(1)
	public List<List<Integer>> fourSumTwoPointer(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> quad;
        Arrays.sort(nums);
        int n=nums.length;
        int i=0,j,left,right;
        while(i<n){
            j=i+1;
            while(j<n){
                int complement=target-nums[i]-nums[j];
                left=j+1;
                right=n-1;
                while(left<right){
                    if(nums[left]+nums[right]==complement){
                        quad=new ArrayList<Integer>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        result.add(quad);
                        do{
                            left++;
                        }while(left<right && nums[left-1]==nums[left]);
                        do{
                            right--;
                        }while(left<right &&nums[right+1]==nums[right]);
                        
                    }
                    else if(nums[left]+nums[right]>complement){
                        do{
                            right--;
                        }while(left<right && nums[right+1]==nums[right]);      
                    }
                    else{
                        do{
                            left++;
                        }while(left<right && nums[left-1]==nums[left]);
                    }
                }
                do{
                    j++;
                }while(j<n && nums[j-1]==nums[j]);
            }
            do{
                i++;
            }while(i<n && nums[i-1]==nums[i]);
        }
        return result;
    }
}