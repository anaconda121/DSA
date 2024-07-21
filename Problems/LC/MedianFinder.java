class MedianFinder {
    List<Integer> data;

    public MedianFinder() {
        data = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if (data.size() == 0) { data.add(num); return; }
        if (num < data.get(0)) {data.add(0, num); return; }

        int l = 0;
        int r = data.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (data.get(m) <= num) {
                if (m == data.size() - 1 || data.get(m + 1) >= num) {
                    data.add(m+1, num);
                    break;
                } else { l = m + 1; }
            } else if (data.get(m) > num) { r = m - 1; }
        }
    }
    
    public double findMedian() {
        int m = (data.size() - 1 )/ 2;
        if (data.size() % 2 == 0) {
            double v = (double) (data.get(m) + data.get(m + 1));
            return v / 2;
        }
        return data.get(m);
    }
}
