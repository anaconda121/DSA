class GroupAnagrams:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = []
        covered = [False] * len(strs)
        for i in range(len(strs)):
            curr = []
            if (covered[i] == False):
                curr.append(strs[i])
            for j in range(i, len(strs)):
                if (i != j and len(strs[i]) == len(strs[j])):
                    if (sorted(strs[i]) == sorted(strs[j])):
                        if (covered[j] == False):
                            covered[j] = True
                            curr.append(strs[j])
            if (curr != []):
                ans.append(curr)
        return ans
