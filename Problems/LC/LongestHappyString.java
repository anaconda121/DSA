class Solution {

    class Char {
        char character;
        int cnt; int cntTwo; int cntOne;
        boolean lastUsed;

        Char(char ch, int cn, boolean l) {
            character = ch;
            cnt = cn;
            lastUsed = l;
        }
    }

    int[] splitNumber(int n, int m) {
        int numberOfTwos = n - m;
        int numberOfOnes = 2 * m - n;
        return new int[]{numberOfTwos, numberOfOnes};
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Char> pq = new PriorityQueue<>(
            (char1, char2) -> {
                if (char1.cnt == char2.cnt) {
                    return Boolean.compare(char1.lastUsed, char2.lastUsed);
                }
                return char2.cnt - char1.cnt;
            }
        );

        HashMap<Character, Integer> cnt = new HashMap<>();
        cnt.put('a', a);
        cnt.put('b', b);
        cnt.put('c', c);

        int maxCnt = Math.max(a, Math.max(b, c));
        int groups = maxCnt / 2 + maxCnt % 2;

        for (Character key : cnt.keySet()) {
            if (cnt.get(key) > 0) { 
                Char curr = new Char(key, cnt.get(key), false); 
                int[] split = splitNumber(cnt.get(key), groups);
                curr.cntTwo = split[0]; curr.cntOne = split[1];
                pq.add(curr);
            }
        }

        StringBuilder res = new StringBuilder();
        Char prev = null;

        while (!pq.isEmpty()) {
            Char current = pq.poll();

            if (prev != null && prev.cnt > 0) {
                prev.lastUsed = false;
                pq.add(prev);
            }

            if (current.cntTwo > 0) {
                res.append(current.character);
                res.append(current.character);
                current.cnt -= 2; current.cntTwo--;
            } else if (current.cntOne > 0) {
                res.append(current.character);
                current.cnt--; current.cntOne--;
            }

            current.lastUsed = true;
            prev = current;
        }

        return res.toString();
    }
}
