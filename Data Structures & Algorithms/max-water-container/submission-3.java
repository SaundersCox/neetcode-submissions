class Solution {
    public int maxArea(int[] heights) {
        // use 2pt
        // height determined by min of l & r
        // width determined by l - r
        // how to find max -- as long as we get height + 1 on an iteration
        // always move the shorter side since it's the limiting factor

        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while (l < r) {
            int cur = Math.min(heights[r], heights[l]) * (r - l);
            if (cur > max) {
                max = cur;
            }
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
