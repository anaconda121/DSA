class PolygonLargestPerimeter:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        pref = [0 for _ in range(len(nums) + 1)]

        ctr = 1
        for i in range(len(nums)):
            pref[ctr] = pref[ctr - 1] + nums[i]
            ctr += 1

        for i in range(len(pref) - 1, -1, -1):
            if (pref[i] - nums[i - 1] > nums[i - 1]):
                return pref[i]

        return -1
