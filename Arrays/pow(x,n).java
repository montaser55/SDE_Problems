class Solution {

	//Brute-force
	//Time: O(n)
	//Space: O(1)
    public double myPowBruteForce(double x, int n) {
        double result=1.0;
        long nn=n;
        if(nn<0){
            nn=(-1)*nn;
        }
        for(int i=0;i<nn;i++){
            result=result*x;
        }
        if(n<0){
            return 1.0/result;
        }
        return result;
    }
	
	
	//Logarithmic method
	//Time: O(log n)
	//Space: O(1)
	public double myPowLogarithmic(double x, int n) {
        long nn=n;
        double result=1.0;
        if(nn<0)nn=-1*nn;
        while(nn>0){
            if(nn%2==1){
                result=result*x;
                nn--;
            }
            else{
                x=x*x;
                nn=nn/2;
            }
        }
        if(n<0)return 1.0/result;
        return result;
    }
}