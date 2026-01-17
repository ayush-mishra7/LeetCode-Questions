class MedianFinder {

        int[] nums = new int[(int) Math.pow(10, 4) * 5];
        int start = 0;
        int end = 0;
        int last = Integer.MIN_VALUE;
        boolean isSorted = true;

        public void addNum(int num) {

            nums[end] = num;
            if (isSorted && num >= last) {
                last = num;
            } else {
                isSorted = false;
            }
            end++;
        }


        public double findMedian() {
            if (!isSorted) {
                if (end < 8000) {
                    Arrays.sort(nums, start, end);
                } else {
                    Arrays.parallelSort(nums, start, end);
                }
                isSorted = true;
            }

            int mid1 = end / 2;
            if (end % 2 == 0) {
                int mid2 = mid1 - 1;
                return ((double) nums[mid1] + (double) nums[mid2]) / 2.0;
            }

            return nums[mid1];
        }
    }