class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m > 0 && m < arr.length - 1) {
                if (arr[m + 1] < arr[m] && arr[m - 1] < arr[m]) return m;
                else if (arr[m + 1] > arr[m] && arr[m + 1] > arr[m - 1]) { l = m; } 
                else { r = m; }
            }
        }
        return -1;
    }
}
