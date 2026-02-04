class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void solve(int[] nums, List<Integer> temp, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp)); // deep copy
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) continue;

            // prune
            if (nums[i] > target) break;

            temp.add(nums[i]);
            solve(nums, temp, target - nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        solve(nums, new ArrayList<>(), target, 0);
        return ans;
    }
}