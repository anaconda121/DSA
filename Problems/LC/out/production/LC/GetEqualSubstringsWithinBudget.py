class GetEqualSubstringsWithinBudget:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        l, r, curr, ans = 0, 0, 0, 0

        while r < len(s) and l < len(s):
            if curr <= maxCost:
                curr += abs(ord(s[r]) - ord(t[r]))
                if curr <= maxCost: 
                    ans = max(ans, r - l + 1)
                r += 1
            else:
                curr -= abs(ord(s[l]) - ord(t[l]))
                l += 1
        
        return ans
