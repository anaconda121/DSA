class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Math.abs(a - x) == Math.abs(b - x)) return Integer.compare(a, b);
                return Integer.compare(Math.abs(a - x), Math.abs(b - x));
            }
        });

        for (int i = 0; i < arr.length; i++) { pq.add(arr[i]); }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) { ans.add(pq.poll()); }

        Collections.sort(ans);
        return ans;
    }
}
