class FindingMKAverage {
    int M;
    int K;
    Queue<Integer> lastM;
    ArrayList<Integer> stream;

    public MKAverage(int m, int k) {
        M = m;
        K = k;
        lastM = new LinkedList<>();
        stream = new ArrayList<>();
    }

    private void insertSortedOrder(int num) {
        if (stream.size() == 0) {
            stream.add(num);
            return;
        } else if (stream.get(0) >= num) {
            stream.add(0, num);
            return;
        }

        int l = 0;
        int r = stream.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (stream.get(m) <= num) {
                if (m == stream.size() - 1 || stream.get(m + 1) >= num) {
                    stream.add(m + 1, num);
                    break;
                } else { l = m + 1; }
            } else if (stream.get(m) > num) { r = m - 1; }
        }
    } 
    
    public void addElement(int num) {
        if (stream.size() + 1 > M) {
            int valRemove = lastM.poll();
            int valPos = Collections.binarySearch(stream, valRemove);
            stream.remove(valPos);
        }
        insertSortedOrder(num);
        lastM.add(num);
    }
    
    public int calculateMKAverage() {
        if (stream.size() < M) return -1;
        int tot = 0;
        int cnt = 0;
        for (int i = K; i <= stream.size() - 1 - K; i++) {
            tot += stream.get(i);
            cnt++;
        }
        return tot / cnt;
    }
}
