import java.util.Arrays;
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int exp = n*(n+1)/2;
        int actualSum = Arrays.stream(nums).sum();
        int me = exp - actualSum;
        return me;
    }
}