class ReorganizeString {

    class Char {
        char character;
        int cnt;
        boolean lastUsed;

        Char(char character, int cnt, boolean l) {
            this.character = character;
            this.cnt = cnt;
            this.lastUsed = l;
        }
    }

    public String reorganizeString(String s) {
        PriorityQueue<Char> pq = new PriorityQueue<>(
            (char1, char2) -> {
                if (char1.cnt == char2.cnt) {
                    return Boolean.compare(char1.lastUsed, char2.lastUsed);
                }
                return char2.cnt - char1.cnt;
            }
        );
        HashMap<Character, Integer> cnt = new HashMap<>();

        for (char c : s.toCharArray()) {
            int cn = cnt.getOrDefault(c, 0);
            cnt.put(c, cn + 1);
        }

        for (Character key : cnt.keySet()) {
            if (cnt.get(key) > (s.length() + 1) / 2) return "";
            pq.add(new Char(key, cnt.get(key), false));
        }

        StringBuilder res = new StringBuilder();
        Char prev = null;

        while (!pq.isEmpty()) {
            Char current = pq.poll();
            if (prev != null && prev.cnt > 0) {
                prev.lastUsed = false;
                pq.add(prev);
            }

            res.append(current.character);
            current.cnt--;
            current.lastUsed = true;

            prev = current;
        }

        return res.toString();
    }
}
