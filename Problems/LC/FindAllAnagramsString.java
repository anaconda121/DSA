import java.util.*;

public class FindAllAnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        Map<Character, Integer> pCount = new HashMap<>();
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sCount = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }

        if (sCount.equals(pCount)) {
            ans.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - p.length());

            sCount.put(newChar, sCount.getOrDefault(newChar, 0) + 1);

            if (sCount.get(oldChar) == 1) { sCount.remove(oldChar);
            } else { sCount.put(oldChar, sCount.get(oldChar) - 1); }

            if (sCount.equals(pCount)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }
}
