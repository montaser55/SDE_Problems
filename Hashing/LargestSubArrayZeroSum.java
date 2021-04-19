class GfG
{
	//Using Kadane's Algorithm
	//Time: O(n^2)
	//Space: O(1)
    int maxLenKadanes(int arr[], int n)
    {
        int max=0,sum;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==0){
                    max=Math.max(j-i+1,max);
                }
            }
        }
        return max;
    }
	
	//Hashing
	//Time: O(n)
	//Space: O(n)
	int maxLenHashing(int arr[], int n)
    {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0,sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                max=Math.max(i+1,max);
            }
            else if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            else if(map.containsKey(sum)){
                max=Math.max(i-map.get(sum),max);
            }
        }
        return max;
    }
}