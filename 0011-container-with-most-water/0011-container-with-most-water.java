class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max_area = 0;

        while(i < j){
            int b = j - i;
            int h = Math.min(height[i], height[j]);
            int area = b * h;
            max_area = Math.max(area, max_area);

            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max_area;
    }
}