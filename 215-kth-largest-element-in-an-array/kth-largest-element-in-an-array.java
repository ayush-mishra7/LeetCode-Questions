class Solution {
    public int findKthLargest(int[] a, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=a.length;
        for(int i=0;i<n;i++){
            if(i<k)pq.add(a[i]);
            else if(a[i]<pq.peek())continue;
            else{
                pq.poll();
                pq.add(a[i]);
            }
        }
        return pq.peek();
    }
}