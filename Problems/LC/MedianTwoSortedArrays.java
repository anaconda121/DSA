class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Double> pq = new PriorityQueue<>();

        for (int i : nums1) { pq.add((double)i); }
        for (int i : nums2) { pq.add((double)i); }

        if ((nums1.length + nums2.length) % 2 == 0) {
            int medianOne = pq.size() / 2 - 1;
            int medianTwo = pq.size() / 2;
            
            int ctr = 0;
            while (ctr < medianOne) {
                pq.poll();
                ctr++;
            }

            double x = pq.poll();
            double y = pq.poll();
          
            return (x + y) / 2.0;
        }

        int median = pq.size() / 2;
        int ctr = 0;
        while (ctr < median) {
            pq.poll();
            ctr++;
        }

        return (double) pq.poll();
    }
}
