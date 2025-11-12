class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int l = 0, r = height.length-1;

        while(l <= r){
            int widht = r - l;
            int min_height = Math.min(height[r], height[l]);
            int area = widht * min_height;

            max_area = Math.max(area, max_area);

            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max_area;
    }
}