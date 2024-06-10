class MinimumTimeMakeRopeColorful:
    def minCost(self, colors: str, neededTime: List[int]) -> int:

        def delete_rope(dups):
            time_saved = 0
            for interval in dups:
                curr_slice = neededTime[interval[0] : interval[1] + 1]
                time_saved += sum(curr_slice) - max(curr_slice)
            return time_saved

        dups = []
        l, r = 0, 1

        while r < len(colors) and l < len(colors):
            if (colors[l] == colors[r]): r += 1
            else:
                if (l != r - 1): dups.append([l, r - 1])
                l = r
                
        if (l != r -1 and colors[l] == colors[r - 1]): dups.append([l, r - 1])

        return delete_rope(dups)
