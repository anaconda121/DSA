class MergeStringsAlternately:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        ptr_1 = 0
        ptr_2 = 0
        merge_ptr_1 = True
        res = ""

        while ptr_1 < len(word1) and ptr_2 < len(word2):
            if (merge_ptr_1):
                res += word1[ptr_1]
                ptr_1 += 1
            else:
                res += word2[ptr_2]
                ptr_2 += 1
            merge_ptr_1 = not merge_ptr_1
    
        if (len(word1) > len(word2)):
            res += word1[-(len(word1) - ptr_1):]
        elif (len(word2) > len(word1)):
            res += word2[-(len(word2) - ptr_2):]
        else:
            res += word2[-1:]
        
        return res
