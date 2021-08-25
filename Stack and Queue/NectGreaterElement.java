class Solution {
	
	//Time: O(2n+2n)
	//Space: O(2n)
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result=new int[n];
        
        for(int i=(n*2)-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i%n]>=stack.peek()){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    result[i]=-1;
                }
                else{
                    result[i]=stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        return result;
    }
}