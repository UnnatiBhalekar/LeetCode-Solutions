class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        //int leftpos = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] != 0) {
        //         if (i != leftpos) {
        //             int temp = nums[i];
        //             nums[i] = nums[leftpos];
        //             nums[leftpos] = temp;
        //         }
        //         leftpos++;
        //     }
        // }
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != 0) {
                if(left != right){
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    
                }
                left++;
            }
        }
    }
}