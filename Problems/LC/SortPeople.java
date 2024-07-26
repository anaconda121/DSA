class SortPeople {
    class Person {
        String n; int h;
        Person(String _n, int _h) { n = _n; h = _h; }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.h, a.h));
        for (int i = 0; i < names.length; i++) { pq.add(new Person(names[i], heights[i])); }
        String[] res = new String[names.length];
        for (int i = 0; i < res.length; i++) { res[i] = pq.poll().n; }
        return res;
    }
}
