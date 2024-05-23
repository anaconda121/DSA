class BeautifulSubsets:
    def beautifulSubsets(self, nums, k):
        nums = sorted(nums)
        ans = 0

        def beautiful(subset):
            s = set(subset)
            for num in subset:
                if (num + k in s) or (num - k in s):
                    return False
            return True
        
        def generate(curr, index):
            nonlocal ans
            if index == len(nums):
                if curr:
                    if beautiful(curr):
                        ans += 1
                return
            
            curr.append(nums[index])
            generate(curr, index + 1)
            
            curr.pop()
            generate(curr, index + 1)

        generate([], 0)
        return ans
