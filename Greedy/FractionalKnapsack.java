class Solution
{
    
    //Time: O(nlogn)+ O(n)
	//Space: O(1)
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr,(a,b)->Double.compare((b.value*1.0)/b.weight,(a.value*1.0)/a.weight));
        int totalWeight=0;
        double totalValue=0;
        for(int i=0;i<n;i++){
            int remaining=W-totalWeight;
            if(remaining==0)break;
            if(remaining>=arr[i].weight){
                totalWeight+=arr[i].weight;
                totalValue+=arr[i].value;
            }else{
                totalWeight+=remaining;
                totalValue+=remaining*(arr[i].value*1.0)/arr[i].weight;
            }
        }
        return totalValue;
    }
}