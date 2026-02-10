import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Fix the left boundary of the subarray
        for (int i = 0; i < n; i++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();

            // Expand the right boundary
            for (int j = i; j < n; j++) {
                int x = nums[j];

                // Track distinct evens and odds in the current subarray
                if (x % 2 == 0) {
                    evenSet.add(x);
                } else {
                    oddSet.add(x);
                }

                // Balanced subarray condition
                if (evenSet.size() == oddSet.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
