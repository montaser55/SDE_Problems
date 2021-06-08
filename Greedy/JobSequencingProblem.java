class Solution
{
    //Take the maximum profits and gove them slot
	//Time: O(nlogn) + O(n*m) [n= total jobs, m= timeslots]
	//Space: O(m)
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));
        
        int maxDeadline=0;
        for(int i=0;i<n;i++){
            maxDeadline=Math.max(arr[i].deadline,maxDeadline);
        }
        int[] timeSlots=new int[maxDeadline];
        int profitSum=0,totalJobs=0;
        
        for(int i=0;i<n;i++){
            int slotWanted=arr[i].deadline-1;
            while(slotWanted>=0){
                if(timeSlots[slotWanted]==0){
                    timeSlots[slotWanted]=arr[i].id;
                    profitSum+=arr[i].profit;
                    totalJobs++;
                    break;
                }
                else{
                    slotWanted--;
                }
            }
        }
        
        return new int[]{totalJobs,profitSum};
        
    }
}