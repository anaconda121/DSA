class RearrangeArrayElementsSign:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        pos = []
        neg = []

        for i in range(len(nums)):
            if (nums[i] > 0): pos.append(nums[i])
            else: neg.append(nums[i])

        ans = []
        pos_ctr = 0
        neg_ctr = 0
        for i in range(len(nums)):
            if (i % 2 == 0): 
                ans.append(pos[pos_ctr])
                pos_ctr += 1
            else:
                ans.append(neg[neg_ctr])
                neg_ctr += 1
        
        return ans
        
