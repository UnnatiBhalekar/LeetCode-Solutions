class Solution {
    public int majorityElement(int[] nums) {

        //using boyer moore's voting algorithm
        //for choosing the candidates
        int candidate = nums[0];
        //for keeping track of number of votes
        int count = 0;

        for(int num: nums){
            if(count == 0){
                candidate = num;
            }

            count += (num == candidate) ? 1:-1;
        }
        return candidate;
    }
}