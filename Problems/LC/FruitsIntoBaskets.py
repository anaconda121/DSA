class FruitsIntoBaskets:
    def totalFruit(self, fruits: List[int]) -> int:
        l, r, ans = 0, 0, 0
        count = defaultdict(int)
        done = False

        while r < len(fruits) and l < len(fruits):
            if (len(count) < 2):
                count[fruits[r]] += 1
                ans = max(ans, r - l + 1)
                r += 1
            elif len(count) == 2:
                if (fruits[r] in count):
                    count[fruits[r]] += 1
                    ans = max(ans, r - l + 1)
                    r += 1
                else: done = True
            
            if done:
                count[fruits[l]] -= 1
                if count[fruits[l]] == 0:
                    del count[fruits[l]]
                l += 1
                if (len(count) <= 2): done = False

        return ans
