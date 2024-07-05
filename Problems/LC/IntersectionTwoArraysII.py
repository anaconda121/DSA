class IntersectionTwoArraysII:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        map1 = defaultdict(int)
        map2 = defaultdict(int)

        for i in range(len(nums1)):
            map1[nums1[i]] += 1
        
        for i in range(len(nums2)):
            map2[nums2[i]] += 1

        ans = []
        for k, v in map2.items():
            if k in map1:
                app = min(v, map1[k])
                for i in range(app):
                    ans.append(k)

        return ans
