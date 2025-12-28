import java.util.Arrays;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        
        // brute n^2 
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]==nums[j]) return true;
        //     }
        // }
        // return false;

        // n log n
        // Arrays.sort(nums);
        // for(int i=1;i<n;i++){
        //     if(nums[i] == nums[i-1]) return true;
        // }
        // return false;

        // optimal O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int x:nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}