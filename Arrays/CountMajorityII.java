class Solution {
	
	//Brute-Force
	//Time: O(n^2)
	//Space: O(1)
    public List<Integer> majorityElementBruteForce(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        int num=0,count=0;
        for(int i=0;i<nums.length;i++){
            num=nums[i];
            count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==num)count++;
            }
            if(count>nums.length/3 && !result.contains(num)){
                result.add(num);
            }
        }
        return result;
        
    }
	
	//HashMap
	//Time: O(n)
	//Space: O(n)
	public List<Integer> majorityElementHashMap(int[] nums) {
        int n=nums.length;
        List<Integer> result=new ArrayList<Integer>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>n/3)result.add(m.getKey());
        }
        return result;
        
    }
	
	//Boyer-Moore
	//Time: O(n)
	//Space: O(1)
	public List<Integer> majorityElementBoyerMoore(int[] nums) {
        int n=nums.length;
        List<Integer> result = new ArrayList<Integer>();
        int num1=-1,num2=-1;
        int count1=0,count2=0;
        for(int i=0;i<n;i++){
            if(num1==nums[i]){
                count1++;
            }
            else if(num2==nums[i]){
                count2++;
            }
            else if(count1==0){
                num1=nums[i];
                count1=1;
            } 
            else if(count2==0){
                num2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==num1){
                count1++;
            }
            else if(nums[i]==num2){
                count2++;
            }
        }
        System.out.println(num1+" "+num2);
        if(count1>n/3)result.add(num1);
        if(count2>n/3)result.add(num2);
        return result;
    }
}