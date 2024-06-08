class CarPooling {

    class Trip {
        int time; int ppl; char pickOrDrop;
        Trip(int t, int p, char c) { time = t; ppl = p; pickOrDrop = c; }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Trip> q = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.time, t2.time));

        for (int i = 0; i < trips.length; i++) {
            q.add(new Trip(trips[i][1], trips[i][0], 'P')); // pickup
            q.add(new Trip(trips[i][2], trips[i][0], 'D')); // drop off
        }

        int t = 0;
        int curr = 0;
        while (q.size() > 0) {
            Trip next = q.peek();

            while (next != null && t == next.time) {
                if (next.pickOrDrop == 'P') {
                    curr += next.ppl;
                } else {
                    curr -= next.ppl;
                }
                q.poll();
                next = q.peek();
            }

            if (curr > capacity) { return false; }            
            t++;
        }

        return true;
    }
}
