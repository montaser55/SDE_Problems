class Solution {
	
	
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Set<List<Integer>> set=new HashSet<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> triplet=new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        if(!set.contains(triplet)){
                            result.add(triplet);
                            set.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> triplet=new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        result.add(triplet);
                        break;
                    }
                }
                while(j+1<nums.length && nums[j]==nums[j+1]){
                    j++;
                }
            }
            while(i+1<nums.length && nums[i]==nums[i+1]){
                    i++;
                }
        }
        return result;
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else map.put(nums[i],1);
        }
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.get(nums[i])-1);
            for(int j=i+1;j<nums.length;j++){
                map.put(nums[j],map.get(nums[j])-1);
                int sum=nums[i]+nums[j];
                if(map.containsKey(-sum) && map.get(-sum)>0){
                    List<Integer> triplet=new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(-sum);
                    Collections.sort(triplet);
                    if(!set.contains(triplet)){
                        result.add(triplet);
                        set.add(triplet);
                    }
                }
                map.put(nums[j],map.get(nums[j])+1);
            }
            map.put(nums[i],map.get(nums[i])+1);
        }
        return result;
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        int low,high;
        for(int i=0;i<nums.length-2;i++){
            low=i+1;
            high=nums.length-1;
            while(low<high){
                if(nums[i]+nums[low]+nums[high]>0){
                    high--;
                }
                else if(nums[i]+nums[low]+nums[high]<0){
                    low++;
                }
                else if(nums[i]+nums[low]+nums[high]==0){
                    result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low+1<high && nums[low]==nums[low+1]){
                        low++;
                    }
                    while(high-1>low && nums[high]==nums[high-1]){
                        high--;
                    }
                    low++;
                    high--;
                  }
                
            }
            while(i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
        }
        return result;
    }
}