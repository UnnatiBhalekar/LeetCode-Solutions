class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int leftpos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (i != leftpos) {
                    int temp = nums[i];
                    nums[i] = nums[leftpos];
                    nums[leftpos] = temp;
                }
                leftpos++;
            }
        }
    }
}