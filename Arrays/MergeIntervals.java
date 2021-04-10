class Solution {
	
	//Brute-Force
	//Time: O(n^2)
	//Space: O(n)
    public int[][] mergeBruteForce(int[][] intervals) {
        List<int[]> result=new ArrayList<int[]>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<intervals.length;i++){
            boolean willMerge=true;
            int start=intervals[i][0];
            int end=intervals[i][1];
            for(int j=0;j<result.size();j++){
                if(start>=result.get(j)[0] && end<=result.get(j)[1]){
                    willMerge=false;
                }
            }
            if(willMerge){
                for(int j=i+1;j<intervals.length;j++){
                    if(start<=intervals[j][0] && end>=intervals[j][0]){
                        end=Math.max(end,intervals[j][1]);
                    }
                }
                result.add(new int[]{start,end});
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
	
	
	//MergingSingleLoop
	//Time: O(nlogn)
	//Space: O(n)
	public int[][] mergeSingleLoop(int[][] intervals) {
        List<int[]> result=new ArrayList<int[]>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0],end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                result.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }
}