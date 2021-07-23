public class Main
{
	//Time: O(n*log2^(m*10^6))
	//Auxiliary Space: O(1)
    public static double multiplyNtimes(double v,int n){
        double ans=1;
        for(int i=1;i<=n;i++){
            ans*=v;
        }
        return ans;
    }
    
    public static double FindNthRoot(int m,int n){
        double diff=1e-6;    
        double low=1;
        double high=m;
        double mid=0;
        
        while(high-low>diff){
            mid=low+(high-low)/2;
            //System.out.println(mid);
            double multiplyValue=multiplyNtimes(mid,n);
            if(multiplyValue==m){
                return mid;
            }
            else if(multiplyValue>m){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return mid;
    } 
    
	public static void main(String[] args) {
		int m=89;
		int n=17;
		System.out.println(FindNthRoot(m,n));
	}
}