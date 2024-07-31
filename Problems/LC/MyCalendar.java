class MyCalendar {
    List<int[]> times;

    public MyCalendar() {
        times = new ArrayList<>();    
    }
    
    public boolean book(int start, int end) {
        if (times.size() == 0) {
            times.add(new int[]{start, end});
            return true;
        } else if (times.size() == 1) {
            if (times.get(0)[0] >= end) {
                times.add(0, new int[]{start, end});
                return true;
            } else if (times.get(0)[1] <= start) {
                times.add(new int[]{start, end});
                return true;
            }
            return false;
        }

        for (int i = 0; i < times.size(); i++) {
            if (i == times.size() - 1) {
                if (times.get(i)[1] <= start) {
                    times.add(new int[]{start, end});
                    return true;
                }
            } else {
                if (i == 0) {
                    if (times.get(0)[0] >= end) {
                        times.add(0, new int[]{start, end});
                        return true;
                    }
                }
                if (times.get(i)[1] <= start && times.get(i + 1)[0] >= end) {
                    times.add(i + 1, new int[]{start, end});
                    return true;
                }
            }
        }

        return false;
    }
}
