class FindCommonCharacters:
    def commonChars(self, words: List[str]) -> List[str]:
        lst = [ [0] * 26 for _ in range(len(words)) ]

        for i in range(len(words)):
            for j in range(len(words[i])):
                lst[i][ord(words[i][j]) - ord('a')] += 1

        ans = []
        for i in range(26):
            min_shared_cnt = 105
            for j in range(len(lst)):
                min_shared_cnt = min(min_shared_cnt, lst[j][i])

            if (min_shared_cnt > 0):
                for _ in range(min_shared_cnt):
                    ans.append(chr(i + ord('a')))
        
        return ans
