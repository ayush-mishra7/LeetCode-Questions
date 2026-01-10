class Solution {
    public boolean isPalindrome(String s) {
        String sk=s.toLowerCase();
        String sn="";
        for(int i=0;i<s.length();i++){
            if((int)sk.charAt(i)>=97 && (int)sk.charAt(i)<=122  || sk.charAt(i) >= '0' && sk.charAt(i) <= '9'){
                sn+=sk.charAt(i);
            }
        }
        for(int i=0;i<sn.length()/2;i++){
            if(sn.charAt(i)!=sn.charAt(sn.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}