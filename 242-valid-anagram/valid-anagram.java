import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {

        // n log n
        // char[] a = s.toCharArray();
        // char[] b = t.toCharArray();

        // Arrays.sort(a);
        // Arrays.sort(b);
        
        // return Arrays.equals(a, b);
        
        // O(n)
        int[] freq = new int[26];

        for(char c:s.toCharArray()) freq[c-'a']++;
        for(char c:t.toCharArray()) freq[c-'a']--;
        for(int x:freq){
            if(x != 0) return false;
        } 
        return true;
    }
}