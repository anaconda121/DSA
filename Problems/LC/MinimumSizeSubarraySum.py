class MinimumSizeSubarraySum:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        curr_sum, l, r, ans = 0, 0, 0, math.pow(10, 9) + 5

        while l < len(nums):
            if curr_sum >= target:
                ans = min(ans, r - l)
                curr_sum -= nums[l]
                l += 1
            else:
                if r < len(nums):
                    curr_sum += nums[r]
                    r += 1
                else:
                    break

        if ans == math.pow(10, 9) + 5: return 0
        return ans
