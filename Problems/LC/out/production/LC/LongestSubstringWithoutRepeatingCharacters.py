class LongestSubstringWithoutRepeatingCharacters:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if (s is ""): return 0
        l, r, ans = 0, 0, 1
        char_counts = defaultdict(int)
        char_counts[s[r]] += 1

        while r < len(s) and l < len(s):
            if max(char_counts.values()) == 1:
                ans = max(ans, r - l + 1)
                r += 1
                if r < len(s):
                    char_counts[s[r]] += 1
                    
            else:
                char_counts[s[l]] -= 1
                l += 1

        return ans
