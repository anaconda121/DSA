class KClosestPointsOrigin {

    class Point {
        int x, y;
        double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x*x + y*y);
        }

        public double getDistance() {
            return this.distance;
        }
    }

    class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return Double.compare(p1.getDistance(), p2.getDistance());
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pts = new PriorityQueue<>(new PointComparator());

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            pts.add(new Point(x, y));
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point curr = pts.poll();
            ans[i][0] = curr.x;
            ans[i][1] = curr.y;
        }

        return ans;
    }
}
