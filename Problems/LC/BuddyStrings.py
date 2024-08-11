class BuddyStrings:
    def buddyStrings(self, s: str, goal: str) -> bool:
        def swap(c, i, j):
            c = list(c)
            c[i], c[j] = c[j], c[i]
            return ''.join(c)
        
        if (len(s) != len(goal)): return False
        if (s == goal):
            cnt = defaultdict(int)
            for i in range(len(s)):
                cnt[s[i]] += 1
            for k, v in cnt.items():
                if (v > 1):
                    return True
            return False
        
        diff_chars = []
        for i in range(len(s)):
            if (s[i] != goal[i]): diff_chars.append(i)
                
        if (len(diff_chars) == 1 or len(diff_chars) > 2): return False
        
        return swap(s, diff_chars[0], diff_chars[1]) == goal
