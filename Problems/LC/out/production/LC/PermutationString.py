class PermutationString:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        len_window = len(s1)
        ss1 = sorted(s1)

        i = 0
        while i < len(s2):
            curr_slice = s2[i : i + len_window]
            if (sorted(curr_slice) == ss1): return True
            i += 1
        return False
