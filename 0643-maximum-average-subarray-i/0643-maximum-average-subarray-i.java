class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            //adding the new element
            sum = sum + nums[i];
            //removing the old element
            sum = sum - nums[i - k];
            //updating max
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}