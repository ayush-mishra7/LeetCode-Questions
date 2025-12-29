class Solution {
    public boolean isHappy(int n) {

        while(n!=1 && n!=4){
            int sum =0;
                    String str= String.valueOf(n);
            for(char ch : str.toCharArray()){
                int digit = Character.getNumericValue(ch);
                int square = digit * digit ;
                sum += square;
            }
            n=sum;
        }
        return n==1;
    }
}