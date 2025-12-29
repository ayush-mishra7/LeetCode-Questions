class Solution {
    public void moveZeroes(int[] nums) {
        // int ans=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         nums[ans]=nums[i];
        //         ans++;
        //     }
        // }
        // for(int i=ans;i<nums.length;i++){
        //     nums[i]=0;
        // }

        int left = 0;

        for(int right=0;right<nums.length;right++){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}