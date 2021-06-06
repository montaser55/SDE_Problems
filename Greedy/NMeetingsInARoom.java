//Sort according to end and compare
//Time: O(nlogn)
//Space: O(n)
class Pair{
        
        int first;
        int second;
        
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
}
    

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        if(n==0)return 0;
        if(n==1)return 1;
        List<Pair> pairs=new ArrayList<>();
        for(int i=0;i<n;i++){
            pairs.add(new Pair(start[i],end[i]));
        }
        Collections.sort(pairs,(a,b)->Integer.compare(a.second,b.second));
        int result=1;
        int endPre=pairs.get(0).second;
        int startNew;
        for(int i=1;i<n;i++){
            startNew=pairs.get(i).first;
            if(startNew>endPre){
                result++;
                endPre=pairs.get(i).second;
            }
            
        }
        return result;
    }
    
}