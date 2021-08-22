class Solution {
	
	//Time: O(n)
	//Space: O(n)
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())return false;
                char p=stack.pop();
                if(c==')' && p=='('||c=='}' && p=='{'||c==']'&&p=='[')continue;
                else return false;
            }
        }
        if (stack.isEmpty())return true;
        return false;
    }
}