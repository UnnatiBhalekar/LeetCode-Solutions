class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //reverse the whole array
        reverse(nums, 0, n-1);
        //reverse the 1st k elements of array
        reverse(nums, 0, k-1);
        //reverse the last elements of array
        reverse(nums, k, n-1);
       
    }
    public static void reverse(int arr[], int s, int e){
        int sp = s;
        int ep = e;
        while(sp<ep){
            int temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;
            sp++;
            ep--;
        }
    }
}