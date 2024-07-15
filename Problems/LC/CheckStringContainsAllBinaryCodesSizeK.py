class CheckStringContainsAllBinaryCodesSizeK:
    def hasAllCodes(self, s: str, k: int) -> bool:
        all_codes = set()
        for i in range(2**k):
            bin_code = bin(i)[2:].zfill(k)
            all_codes.add(bin_code)
        
        for i in range(len(s) - k + 1):
            substring = s[i:i + k]
            if substring in all_codes:
                all_codes.remove(substring)
            
            if not all_codes:
                return True
        
        return len(all_codes) == 0
