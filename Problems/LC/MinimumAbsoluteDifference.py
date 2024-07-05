class MinimumAbsoluteDifference:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        diffs = defaultdict(list)
        for i in range(0, len(arr) - 1, 1):
            diffs[abs(arr[i + 1] - arr[i])].append([arr[i], arr[i+1]])
        return diffs[min(diffs.keys())]
