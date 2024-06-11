class RelativeSortArray:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        cts = [0] * 1005
        ans = []

        for i in range(len(arr1)):
            cts[arr1[i]] += 1

        for i in range(len(arr2)):
            cnt = cts[arr2[i]]
            for j in range(cnt):
                ans.append(arr2[i])
            cts[arr2[i]] = -1

        for i in range(len(cts)):
            if (cts[i] > 0):
                cnt = cts[i]
                for j in range(cnt):
                    ans.append(i)

        return ans
