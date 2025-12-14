class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      boolean found=false;
        for(int []row:matrix)if(binarySearech(row,target)){
            found=true;
            break;
        }
        return found;
    }
    public boolean binarySearech(int[]arr,int target){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }
            if(arr[mid]>target)end=mid-1;
            else start=mid+1;
        }
        return false;
    }
}