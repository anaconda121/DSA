class SortCharactersFrequency {

    class Cnt {
        char character;
        int count;
        Cnt(char c, int cnt) { character = c; count = cnt; }
    }

    public static String sortString(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public String frequencySort(String s) {
        String sorted = sortString(s);
        PriorityQueue<Cnt> pq = new PriorityQueue<>((a, b) -> b.count - a.count);

        int ptr = 0;
        while (ptr < sorted.length()) {
            char c = sorted.charAt(ptr);
            int prevPtr = ptr;
            while (ptr < sorted.length() && sorted.charAt(ptr) == c) {
                ptr++;
            }
            pq.add(new Cnt(c, ptr - prevPtr));
        }

        String ans = "";
        while (pq.size() > 0) {
            Cnt c = pq.poll();
            for (int i = 0; i < c.count; i++) {
                ans += c.character;
            } 
        }

        return ans;
    }
}
