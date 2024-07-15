class ValidPalindrome:
    def isPalindrome(self, s: str) -> bool:
        cleaned = "".join([char.lower() for char in s if char.isalnum()])

        l = 0
        r = len(cleaned) - 1

        while l < r:
            if (cleaned[l] != cleaned[r]): return False
            l += 1
            r -= 1
        
        return True
