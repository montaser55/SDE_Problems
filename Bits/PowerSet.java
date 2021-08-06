class Solution
{
	//Time: O(2^n * n) 
	//Space: O(1)
    public List<String> AllPossibleStrings(String s)
    {
        List<String> results= new ArrayList<String>();
        int n= s.length();
        double total = Math.pow(2,n);
        for(int i=1;i<total;i++){
            String sub="";
            for(int j=0;j<n;j++){
                if(((i>>j) & 1)==1){
                    sub+=s.charAt(j);
                }                
            }
            results.add(sub);
        }
        return results;
    }
}