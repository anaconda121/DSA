class FindMountainArray {
    int peakIdx(MountainArray arr) {
        int l = 0;
        int r = arr.length() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int after = arr.get(m + 1);
            int curr = arr.get(m);
            int before = arr.get(m - 1);
            if (m > 0 && m < arr.length() - 1) {
                if (after < curr && before < curr) return m;
                else if (after > curr && after > before) {
                    l = m;
                } else {
                    r = m;
                }
            }
        }
        return -1;
    }

    int binarySearch(int s, int e, int target, MountainArray arr, boolean beforePeak) {
        int l = s; int r = e;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr.get(m) == target) {
                res = Math.min(res, m);
                if (beforePeak) r = m - 1;
                else l = m + 1;
            } else if (arr.get(m) > target) {
                if (beforePeak) r = m - 1;
                else l = m + 1;
            } else {
                if (beforePeak) l = m + 1;
                else r = m - 1;
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIdx(mountainArr);
        int beforePeak = binarySearch(0, peak, target, mountainArr, true);
        if (beforePeak != -1) return beforePeak;
        int afterPeak = binarySearch(peak + 1, mountainArr.length() - 1, target, mountainArr, false);
        if (afterPeak != -1) return afterPeak;
        return -1;
    }
}
