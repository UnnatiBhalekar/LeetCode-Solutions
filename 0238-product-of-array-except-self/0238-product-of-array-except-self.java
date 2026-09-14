class Solution {
    public int[] productExceptSelf(int[] nums) {
        //creating left and right sub-array
        int[] leftSubArrayProduct = new int[nums.length];
        int[] rightSubArrayProduct = new int[nums.length];

        //calculating the left subarray product
        leftSubArrayProduct[0] = 1;
        for (int i = 1; i < leftSubArrayProduct.length; i++) {
            leftSubArrayProduct[i] = leftSubArrayProduct[i - 1] * nums[i - 1];
        }

        //calculating the right subarrya product
        rightSubArrayProduct[rightSubArrayProduct.length - 1] = 1;
        for (int i = rightSubArrayProduct.length - 2; i > -1; i--) {
            rightSubArrayProduct[i] = rightSubArrayProduct[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = leftSubArrayProduct[i] * rightSubArrayProduct[i];
        }

        return ans;
    }
}