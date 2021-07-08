class Solution {
	
	//Time: O(2^n* n)
	//Space: O(k*x)
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        PalindromeRecursion(s,new ArrayList<>(),0,result);
        return result;
    }
    
    public void PalindromeRecursion(String s, List<String> subset, int start, List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(subset));
            return;
        }
        
        for(int i=start;i<s.length();i++){
            if(checkPalindrome(s,start,i)){
                subset.add(s.substring(start,i+1));
                PalindromeRecursion(s,subset,i+1,result);
                subset.remove(subset.size()-1);
            }
        }
    }
    
    public boolean checkPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))return false;
        }
        return true;
    }
}