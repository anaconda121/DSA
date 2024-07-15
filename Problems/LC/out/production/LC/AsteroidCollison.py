class AsteroidCollison:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []

        for asteroid in asteroids:
            stack.append(asteroid)
        
        while True:
            i = len(stack) - 1
            num_changes = 0
            while i > 0 and i < len(stack):
                if (stack[i] < 0 and stack[i - 1] > 0):
                    one = stack[i - 1]
                    two = stack[i]

                    if abs(one) > abs(two):
                        del stack[i]
                    elif abs(two) > abs(one):
                        del stack[i - 1]
                    else:
                        del stack[i - 1:i + 1]
                    num_changes += 1
                i -= 1

            if (num_changes == 0): break

        return stack
