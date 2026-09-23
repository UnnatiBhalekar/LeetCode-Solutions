class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // nums1 = [1,2,2,1], nums2 = [2,2]
        // Output: [2,2]
        //sort(nums1) & sort(nums2)
        // nums1 = [1,1,2,2], nums2 = [2,2]
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0, r = 0, k = 0;

        while(l < nums1.length && r < nums2.length){
            if(nums1[l] < nums2[r]){
                l++;
            }
            else if(nums1[l] > nums2[r]){
                r++;
            }
            else{
                nums1[k++] = nums1[l++];
                r++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}