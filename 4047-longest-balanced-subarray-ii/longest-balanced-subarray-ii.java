import java.util.*;

class Solution {

    static class SegmentTree {
        int[] min, max, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            min = new int[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
        }

        // Apply range addition to node
        void apply(int node, int val) {
            min[node] += val;
            max[node] += val;
            lazy[node] += val;
        }

        void pushDown(int node) {
            if (lazy[node] != 0) {
                apply(node * 2, lazy[node]);
                apply(node * 2 + 1, lazy[node]);
                lazy[node] = 0;
            }
        }

        void pushUp(int node) {
            min[node] = Math.min(min[node * 2], min[node * 2 + 1]);
            max[node] = Math.max(max[node * 2], max[node * 2 + 1]);
        }

        // Range add [l, r]
        void update(int node, int start, int end, int l, int r, int val) {
            if (l > end || r < start) return;

            if (l <= start && end <= r) {
                apply(node, val);
                return;
            }

            pushDown(node);

            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);

            pushUp(node);
        }

        // Find earliest index where prefix value == target
        int query(int node, int start, int end, int target) {
            if (start == end) {
                return start;
            }

            pushDown(node);

            int mid = (start + end) / 2;

            if (min[node * 2] <= target && target <= max[node * 2]) {
                return query(node * 2, start, mid, target);
            }
            return query(node * 2 + 1, mid + 1, end, target);
        }
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;

        SegmentTree st = new SegmentTree(n);
        Map<Integer, Integer> lastPosition = new HashMap<>();

        int currentBalance = 0;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int value = nums[i - 1];

            // odd contributes +1, even contributes -1
            int contribution = (value % 2 == 1) ? 1 : -1;

            // If seen before, remove previous contribution
            if (lastPosition.containsKey(value)) {
                int prevIndex = lastPosition.get(value);
                st.update(1, 0, n, prevIndex, n, -contribution);
                currentBalance -= contribution;
            }

            lastPosition.put(value, i);

            // Add new contribution from this position onward
            st.update(1, 0, n, i, n, contribution);
            currentBalance += contribution;

            // Find earliest position where prefix balance equals currentBalance
            int earliest = st.query(1, 0, n, currentBalance);

            answer = Math.max(answer, i - earliest);
        }

        return answer;
    }
}
