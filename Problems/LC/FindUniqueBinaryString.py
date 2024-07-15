class FindUniqueBinaryString:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums[0])
        
        def compute_binary_str(curr):
            if len(curr) == n:
                if curr not in nums: return curr
                return None

            result = compute_binary_str(curr + "0")
            if result: return result

            result = compute_binary_str(curr + "1")
            if result: return result

            return None

        return compute_binary_str("")
