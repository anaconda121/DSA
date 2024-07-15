class LongestPalindrome:
    
    def longestPalindrome(self, s: str) -> int:
        counts = defaultdict(int)
        ans = 0
        max_odd = 0

        for i in range(len(s)): counts[s[i]] += 1

        for val in counts.values():
            if (val % 2 == 0): ans += val
            else: ans += val - 1

        if (ans == len(s)): return ans
        return ans + 1
