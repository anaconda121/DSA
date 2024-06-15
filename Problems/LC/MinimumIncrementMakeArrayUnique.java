public class MinimumIncrementMakeArrayUnique {

    class Number {
        int num; 
        int cnt;
        Number(int n, int c) { num = n; cnt = c; }
    }

    int numberMoves(int n) {
        return (n * (n - 1)) / 2;
    }

    public int minIncrementForUnique(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.putAll(cnt);

        int ans = 0;
        while (!map.isEmpty()) {
            int currentNum = map.firstKey();
            int count = map.get(currentNum);
            map.remove(currentNum);

            ans += numberMoves(count);
            int lastEnding = currentNum + (count - 1);

            for (int i = currentNum + 1; i <= lastEnding; i++) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }

        return ans;
    }
}
