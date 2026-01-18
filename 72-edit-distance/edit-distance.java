class Solution {
    public int minDistance(String word1, String word2) {
        int[][]arr=new int[word1.length()][word2.length()];
        for(int[]row:arr) Arrays.fill(row,-1);
        return helper(word1,word2,arr,word1.length()-1,word2.length()-1);
    }
    public static int helper(String text1,String text2,int[][]dp,int index1,int index2){
        if(index1<0)return index2+1;
        if(index2<0)return index1+1;
        if(dp[index1][index2]!=-1)return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2))return dp[index1][index2]=helper(text1,text2,dp,index1-1,index2-1);//0+f(i-1,j-1)
        return dp[index1][index2]=Math.min(1+helper(text1,text2,dp,index1-1,index2),Math.min(1+helper(text1,text2,dp,index1,index2-1),1+helper(text1,text2,dp,index1-1,index2-1)));
    }
}