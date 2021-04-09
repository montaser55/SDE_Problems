class Solve {
	
	//Brute-Force
	//Time: O(n^2)
	//Space: O(1)
    int[] findTwoElementBruteForce(int nums[], int n) {
        int repeating=0,missing=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]==num){repeating=num;break;}
            }
        }
        for(int i=1;i<n+1;i++){
            boolean found=false;
            for(int j=0;j<n;j++){
                if(nums[j]==i){found=true;break;}
            }
            if(found==false)missing=i;
        }
        return new int[]{repeating,missing};
    }
	
	//Sorting
	//Time: O(nlogn)
	//Space: O(1)
	int[] findTwoElementSorting(int nums[], int n) {
        int repeating=0,missing=0;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i+1]>nums[i]+1)missing=nums[i]+1;
            if(nums[i]==nums[i+1])repeating=nums[i];
        }
        if(nums[0]!=1)missing=1;
        else if(nums[n-1]!=n)missing=n;
        return new int[]{repeating,missing};
            
    }
	
	//SumN and SumSquareN Equation
	//Time: O(n)
	//Space: O(1)
	int[] findTwoElementEquation(int nums[], int n) {
        int repeating=0,missing=0;
        int sumN=(n*(n+1))/2;
        int sumSquareN=(n*(n+1)*(2*n+1))/6;
        for(int i=0;i<n;i++){
            sumN-=nums[i];
            sumSquareN-=nums[i]*nums[i];
        }
        missing=((sumSquareN/sumN)+sumN)/2;
        repeating=missing-sumN;
        return new int[]{repeating,missing};
    }
	
	//Count Array
	//Time: O(n)
	//Space: O(1)
	int[] findTwoElementCountArray(int nums[], int n) {
        int repeating=0,missing=0;
        int[] count=new int[n+1];
        for(int i=0;i<n;i++){
            count[nums[i]]++;
        }
        for(int i=1;i<n+1;i++){
            if(count[i]==0)missing=i;
            else if(count[i]==2)repeating=i;
        }
        return new int[]{repeating,missing};
    }
	
	//SeparateByXOR
	//Time: O(n)
	//Space: O(1)
    int[] findTwoElementXOR(int nums[], int n) {
        int xor=0,repeating=0,missing=0;
        for(int i=0;i<n;i++){
            xor=xor^nums[i]^(i+1);
        }
        int set_bit=xor & ~(xor-1);
        int x=0,y=0;
        for(int i=0;i<n;i++){
            if((nums[i] & set_bit)==0)x^=nums[i];
            else y^=nums[i];
                
            if(((i+1) & set_bit)==0)x^=(i+1);
            else y^=(i+1);
        }
        boolean xFound=false;
        for(int i=0;i<n;i++){
            if(nums[i]==x){xFound=true;break;}
        }
        if(xFound){
            repeating=x;
            missing=y;
        }
        else {
            repeating=y;
            missing=x;
        }
          
        return new int[]{repeating,missing};
    }
    
}