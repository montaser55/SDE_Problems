class Solution {
	
	//Kadane's Algorithm
	//Time: O(n^2)
	//Space: O(n)
    public int lengthOfLongestSubstringKadanes(String s) {
        int max=0,count=0;
		Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.clear();
            count=0;
            for(int j=i;j<s.length();j++){
                if(!set.contains(s.charAt(j))){
                    count++;
                    set.add(s.charAt(j));
                }
                else{
                    break;
                }
            }
            max=Math.max(max,count);
        }
        return max;
    }
	
	//Two Pointer using Hashset
	//Time: O(2n)
	//Space: O(n)
	public int lengthOfLongestSubstringHashSet(String s) {
        int left=0,right=0,max=0;
        Set<Character> set=new HashSet<>();
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
            }
            else{
                max=Math.max(max,right-left);
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            }
            right++;
            
        }
        max=Math.max(max,right-left);
        return max;
    }
	
	//Two pointer using Hashmap
	//Time: O(n)
	//Space: O(n)
	public int lengthOfLongestSubstringHashMap(String s) {
        int left=0,right=0,max=0;
        Map<Character,Integer> map=new HashMap<>();
        while(right<s.length()){
            if(!map.containsKey(s.charAt(right))||map.get(s.charAt(right))<left){
                map.put(s.charAt(right),right);
            }
            else{
                max=Math.max(right-left,max);
                left=map.get(s.charAt(right))+1;
                map.put(s.charAt(right),right);
            }
            right++;
        }
        max=Math.max(right-left,max);
        return max;
    }
}
