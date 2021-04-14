class Solution
{
	//Brute-Force
	//Time: O(n^2)
	//Space: O(1)
    long inversionCount(long arr[], long N)
    {
        long count=0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(arr[i]>arr[j])count++;
            }
        }
        return count;
    }
	
	//Merge Sort Count
	//Time: O(nlogn)
	//Space: O(n)
    long inversionCountMergeSort(long arr[], int N)
    {
        return mergeSort(arr,0,N-1);
    }
	
	long mergeSort(long[] arr,int start,int end){
        long count=0;
        if(start<end){
            int mid=(start+end)/2;
            count+=mergeSort(arr,start,mid);
            count+=mergeSort(arr,mid+1,end);
            count+=merge(arr,start,mid,end);
        }
        return count;
    }
    
    long merge(long[] arr,int start,int mid,int end){
        long[] left=new long[mid-start+1];
        System.arraycopy(arr,start,left,0,mid-start+1);
        long[] right=new long[end-mid];
        System.arraycopy(arr,mid+1,right,0,end-mid);
        int i=0,j=0,k=start;
        long count=0;
        while(i<left.length && j<right.length){
            if(left[i]>right[j]){
                count+=left.length-i;
                arr[k++]=right[j++];
            }
            else{
                arr[k++]=left[i++];
            }
        }
        if(i<left.length){
            while(i<left.length){
                arr[k++]=left[i++];
            }
        }
        if(j<right.length){
            while(j<right.length){
                arr[k++]=right[j++];
            }
        }
        return count;
    }
}