class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //Creating an array for all 26 Characters
        int[] magArr=new int[26];
        //Loading the value According to the accurance in magazine
        for(int i=0;i<magazine.length();i++){
            //iterating value by getting indexes(eg: 'a'-'a'=0, 'b'-'a'=1)
            magArr[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            // Reducing value after each use in ransomNote
            magArr[ransomNote.charAt(i)-'a']--;
            //Check if the chracter overuse returning false in this case
            if(magArr[ransomNote.charAt(i)-'a']<0) return false;
        }
        //If no overuse return true
        return true;
    }
}