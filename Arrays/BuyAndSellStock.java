class Solution {
	
	//Brute-force
	//Time Complexity: O(n^2)
	//Space Complexity: O(1)

    public int maxProfitBruteForce(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                max=Math.max(prices[j]-prices[i],max);
            }
        }
        return max;
        
    }
	
	//Single loop
	//Time Complexity: O(n)
	//Space Complexity: O(1)	
	
	public int maxProfitSingleLoop(int[] prices) {
        int min=prices[0],max=0;
        for(int i=1;i<prices.length;i++){
            min=Math.min(prices[i],min);
            max=Math.max(prices[i]-min,max);
        }
        return max;
    }
} 

