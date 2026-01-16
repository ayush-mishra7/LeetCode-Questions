class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int currentMaxSum = 0;
        int maxSubarraySum = Integer.MIN_VALUE;

        int currentMinSum = 0;
        int minSubarraySum = Integer.MAX_VALUE;

        int totalArraySum = 0;

        for (int num : nums) {

            currentMaxSum = Math.max(currentMaxSum + num, num);
            maxSubarraySum = Math.max(maxSubarraySum, currentMaxSum);

            currentMinSum = Math.min(currentMinSum + num, num);
            minSubarraySum = Math.min(minSubarraySum, currentMinSum);

            totalArraySum += num;
        }
        if (totalArraySum == minSubarraySum) {
            return maxSubarraySum;
        }

        return Math.max(maxSubarraySum, totalArraySum - minSubarraySum);
    }
}