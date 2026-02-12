class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freq[c - 'a']++;

                if (isBalanced(freq)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    // Check if all non-zero frequencies are equal
    private boolean isBalanced(int[] freq) {
        int target = 0;

        for (int count : freq) {
            if (count > 0) {
                if (target == 0) {
                    target = count;
                } else if (count != target) {
                    return false;
                }
            }
        }

        return true;
    }
}
