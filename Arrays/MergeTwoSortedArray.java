class Solution
{
    //Sorting
	//Time: O(nlogn)
	//Space: O(n+m)
    public static void mergeExtraArraySort(long arr1[], long arr2[], int n, int m) 
    {
        long[] result=new long[n+m];
        for(int i=0;i<n;i++){
            result[i]=arr1[i];
        }    
        for(int i=0;i<m;i++){
            result[i+n]=arr2[i];
        }
        
        Arrays.sort(result);
        
        for(int i=0;i<n;i++){
            arr1[i]=result[i];
        }
        for(int i=0;i<m;i++){
            arr2[i]=result[i+n];
        }
    }
	
	//Compare arr1 with arr2[0]
	//Time: O(n*m)
	//Space: O(1)
	public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int curr=0;
        while(curr<n){
            if(arr1[curr]<=arr2[0])curr++;
            else{
                long temp=arr2[0];
                arr2[0]=arr1[curr];
                arr1[curr]=temp;
                
                long first=arr2[0];
                int k=1;
                while(k<m && arr2[k]<first){
                    arr2[k-1]=arr2[k];
                    k++;
                }
                arr2[k-1]=first;
            }
        }
    }
	
	//GapMethod
	//Time: O((n+m)log(n+m))
	//Space: O(1)
	public static void mergeGapMethod(long arr1[], long arr2[], int n, int m) 
    {
        int i,j,gap=n+m;
        for(gap=nextgap(gap);gap>0;gap=nextgap(gap)){
           for(i=0;i+gap<n;i++){
               if(arr1[i]>arr1[i+gap]){
                   long temp=arr1[i];
                   arr1[i]=arr1[i+gap];
                   arr1[i+gap]=temp;
               }
           }
           
           for(j=gap>n?gap-n:0;i<n && j<m;i++,j++){
               if(arr1[i]>arr2[j]){
                   long temp=arr2[j];
                   arr2[j]=arr1[i];
                   arr1[i]=temp;
               }
           }
           
           if(j<m){
               for(j=0;j+gap<m;j++){
                   if(arr2[j]>arr2[j+gap]){
                       long temp=arr2[j];
                       arr2[j]=arr2[j+gap];
                       arr2[j+gap]=temp;
                   }
               }
           }
        }
    }
    
    public static int nextgap(int gap){
        if(gap<=1)return 0;
        return (gap/2)+(gap%2);
    }
}
