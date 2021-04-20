class GFG {
	
	//Kadane's algorithm
	//Time: O(n^2)
	//Space: O(1)
    public static int subarrayXorKadanes(int[] arr,int n,int target){
        int count=0,xor=0;
        for(int i=0;i<n;i++){
            xor=0;
            for(int j=i;j<n;j++){
                xor^=arr[j];
                if(xor==target){
                    count++;
                }
            }
        }
        return count;
    }
	
	//Hashing Xor values
	//Time: O(n)
	//Space: O(1)
	public static int subarrayXorHashing(int[] arr,int n,int target){
        Map<Integer,Integer> map=new HashMap<>();
        int count=0,xor=0,y;
        for(int i=0;i<n;i++){
            xor^=arr[i];
            if(xor==target){
                count++;
            }
            if(!map.containsKey(xor)){
                map.put(xor,1);
            }
            else{
                map.put(xor,map.get(xor)+1);
            }
            y=xor^target;
            if(map.containsKey(y)){
                count+=map.get(y);
            }
        }
        return count;
    }

}