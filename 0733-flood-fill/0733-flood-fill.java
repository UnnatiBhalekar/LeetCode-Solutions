class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int originalColor = image[sr][sc];
    
    // guard against the infinite loop case here
    if(color == originalColor)
        return image;
    
    dfs(image, sr, sc, originalColor, color);
    return image;
}

private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
    if (r < 0 || r >= image.length || c < 0 || c >= image[0].length 
            || image[r][c] != originalColor) {
            return;
        }

        image[r][c] = newColor;  // paint it

        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
}
}