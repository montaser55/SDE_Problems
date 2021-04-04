class Solution {

	//Brute-Force
	//Time: O(n^2)
	//Space: O(1)
    public int majorityElementBruteForce(int[] nums) {
        int n=nums.length;
        int num=0,count=0;
        for(int i=0;i<n;i++){
            num=nums[i];
            count=0;
            for(int j=0;j<n;j++){
                if(nums[j]==num)count++;
                if(count>(n/2))return num;
            }
        }
        return -1;
    }
	
	//Sort and return Middle Index;
	//Time: O(n^2)
	//Space: O(1)
	public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	//HashMap Count
	//Time: O(n)
	//Space: O(1)
	public int majorityElementHashMap(int[] nums) {
        Map<Integer,Integer> counts=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(counts.containsKey(nums[i])){
                counts.put(nums[i],counts.get(nums[i])+1);
            }
            else{
                counts.put(nums[i],1);
            }
        }
        
        for(Map.Entry<Integer,Integer> e:counts.entrySet()){
            if(e.getValue()>nums.length/2)return e.getKey();
        }
        return -1;
    }
	
	//Boyer-Moore Voting Algorithm
	//Time: O(n)
	//Space: O(1)
	public int majorityElementBayerMoore(int[] nums) {
        int num=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                num=nums[i];
                count=1;
            }
            else if(nums[i]==num){
                count++;
            }
            else if(nums[i]!=num){
                count--;
            }
        }
        return num;
    }
}
}