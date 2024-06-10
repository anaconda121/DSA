class KthSymbolGrammar:

    def kthGrammar(self, n: int, k: int) -> int:
        if n == 1: return 0
        
        parent_index = (k + 1) // 2
        parent_value = self.kthGrammar(n - 1, parent_index)

        if k % 2 == 1:
            return parent_value
        return abs(1 - parent_value)
