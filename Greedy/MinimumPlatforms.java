class Solution
{
    //Sort dep and compare ascending way
	//Time: O(nlogn)
	//Space: O(1)
    static int findPlatform(int arr[], int dep[], int n)
    {
        if(n==0||n==1)return n;
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int max=1,curr=1;
        int i=1,j=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                i++;
                curr++;
                max=Math.max(curr,max);
            }
            else{
                j++;
                curr--;
            }
        }
        return max;
    }
}