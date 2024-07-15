class SequentialDigits:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        
        def generate_all(low, high):
            ans = []
            for i in range(2, 10):
                for j in range(1, 10 - i + 1):
                    curr = ""
                    prev = j-1
                    for k in range(i):
                        curr += str(prev + 1)
                        prev = prev + 1
                    if (int(curr) <= high and int(curr) >= low):
                        ans.append(int(curr))
                    elif (int(curr) > high): return ans
            return ans

        return generate_all(low, high)
