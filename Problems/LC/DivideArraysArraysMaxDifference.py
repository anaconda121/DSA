class DivideArraysArraysMaxDifference:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        nums.sort()
        res = []
        ctr = 0
        while ctr < len(nums):
            res.append(nums[ctr : ctr + 3])
            ctr += 3
        
        for i in range(len(res)):
            if (res[i][2] - res[i][0] > k):
                return []
        return res
