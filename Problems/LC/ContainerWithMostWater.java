class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = -1;

        while (l < r) {
            int area = Math.abs(l - r) * Math.min(height[l], height[r]);
            if (area > ans) { ans = area; }
            if (height[l] >= height[r]) { r--; }
            else { l++; }
        }

        return ans;
    }
}
