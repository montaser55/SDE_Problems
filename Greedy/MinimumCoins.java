class Solution
{
    //Time: O(v) 
	//Space: O(1)
    List<Integer> MinCoins(int[] coins,int v) 
    {
        List<Integer> result=new ArrayList<>();
		
		for(int i=coins.length-1;i>=0;i--){
			
			while(v>=coins[i]){
				v-=coins[i];
				result.add(coins[i]);
			}
		}
		return result;
    }
}