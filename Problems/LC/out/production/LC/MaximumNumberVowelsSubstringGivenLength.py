class MaximumNumberVowelsSubstringGivenLength:
    def maxVowels(self, s: str, k: int) -> int:

        def is_vowel(c):
            if (c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u'): return True
            return False

        curr_vowels, ans, l, r = 0, -1, 0, k

        for i in range(k):
            if (is_vowel(s[i])): curr_vowels += 1

        ans = max(ans, curr_vowels)

        while r < len(s):
            if (is_vowel(s[l])): curr_vowels -= 1
            if (is_vowel(s[r])): curr_vowels += 1
            l += 1; r += 1
            ans = max(ans, curr_vowels)

        return ans
