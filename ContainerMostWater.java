public class Solution {
    public int maxArea(int[] height) {
        int max = 0, i = 0, j = height.length-1;
        while (i < j) {
            int size = Math.min(height[i], height[j]) * (j-i);
            max = size > max ? size : max;
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
