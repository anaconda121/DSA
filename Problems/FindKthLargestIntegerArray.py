class FindKthLargestIntegerArray:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:
        int_nums = []
        for i in range(len(nums)): int_nums.append(int(nums[i]))
        int_nums.sort()
        return str(int_nums[len(nums) - k])
