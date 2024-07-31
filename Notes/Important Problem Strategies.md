Problem: https://leetcode.com/problems/largest-number/
- To identify which numbers go first, can sort with custom comparator being checking which number comes first in the largest concatenation of both numbers. i.e. "9" and "34" - "934" > "349", meaning that "9" should have higher priority than "34". Then you can just go through the sorted list and concatenate the string version of the numbers together

Problem: https://leetcode.com/problems/continuous-subarray-sum/
- To identify good subarrays, keep a hashmap where the key is a mod and the value is the earliest index that's sum has this mod (saving the earliest index will allow us to find subarrays of longest length that have sums divisible by k)
- Iterate through the array, keeping track of the sum. Search the hashmap for the key of `sum % k` and then compute the length of the subarray by subtracting the current index from the value of that entry in the hashmap if it exists

Problem: https://leetcode.com/problems/number-of-zero-filled-subarrays/
- Can solve this by doing similar strategy to above problem, where you look for count of previous subarrays that have same sum as current
- Another way to do this that has O(1) memory and same O(n) time complexity is to go through array and once you find a "0", keep moving until you find a non-zero character - that will determine the length of the current 0-filled subarray you encountered
	- For example, if you just found a subarray that has two "0"
	- Subarrays of length 2 = 3 zero-filled subarrays (0, 0, 00)
	- Subarrays of length 3 = 6 zero-filled subarrays(0, 0, 0, 00, 00, 000)
	- The pattern is that `zerofilledsubarray(n) = zerofilledsubarray(n - 1) + n`
	- You can use to find to find the total number of zero filled subarrays this continuous sequence of 0's just provided

Problem: https://leetcode.com/problems/minimum-penalty-for-a-shop/
- Solve this problem by having two prefix sums that keep track of number of hours when no customers/customers come
	- i.e. `yCount[i]` = number of hours where customers have come up to hour `i`
- At each point in time, compute number of hours where no customers have come using `nCount` array to see penalty for being open without customers (`nCount[i]`) and compute the penalty for being closed when customers come using `yCount[yCount.length - 1] - yCount[i]` (also can use a postfix array for `yCount`)
	- Total penalty is the sum of this, keep hour where smallest penalty occurred

Problem: https://leetcode.com/problems/product-of-array-except-self/
- Solution is similar to above problem
- Maintain a prefix and postfix array, where instead of adding the previous term you multiply it with the current
- Note that the postfix array is populated from the end
- `product_except_self(i) = pref[i - 1] * post[i + 1]`
	- `pref[i - 1]` gives you the product before the current term
	- `post[i + 1]` gives you the product after the current term

Problem: https://leetcode.com/problems/non-decreasing-array/
- Optimal solution is to go pair by pair, and either increase or decrease accordingly to try to ensure array is non-decreasing
	- have a pointer that keeps track of how many changes this takes
	- check final array to ensure it is non-decreasing, and then return whether `numberChanges <= 1`

Problem: https://leetcode.com/problems/majority-element-ii/
- First recognize that max number of elements that can have count greater than $\left\lfloor \frac{n}{3} \right\rfloor$ is 2
- Optimal solution is to have hashmap that can max of size 3
	- keep adding values to hashmap and updating count which size < 3
	- when size = 3, decrement all values and remove values with count = 0
	- after iterating through the entire array, the values that remain in the hashmap are to be returned
	- having hashmap max be size 3 means this algorithm can have O(n) runtime and O(1) space

Problem: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
- Use prefix sums to obtain sum of elements/count after and before current one
- `ans[i] = sumAfter - (nAfter * nums[i]) + (nBefore * nums[i] - sumBefore)`
	- it is guranteed that `sumAfter > nAfter + nums[i]` because array is sorted
	- likewise, `nBefore * nums[i] > sumBefore` because `nums[i]` > each element before it

Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
- Use binary search 
	- to find left most index, every time you find target value, set `r = m - 1` 
	- to find right most index, set `l = m + 1` every time you find target value 

Problem: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
- Can convert this problem into looking for continuous sum of elements that equals `sum(elements) - x`
- Want to maximize the size of this subarray to minimize actual answer
	- iterate through array with for loop as `r` pointer
	- have `l` increment such that the current sum is <= target

Problem: https://leetcode.com/problems/search-suggestions-system/
- First sort the array and note that if 2 words fulfill the conditions, then all the words between them also will fulfill the conditions
- This leads to a two pointer solution, where `l` and `r` are the largest bounds that represent all words that are still eligible
	- for each iteration, return first 3 words or all eligible words

Problem: https://leetcode.com/problems/find-median-from-data-stream/
- Maintain two priority queues - a maxheap that keeps track of all numbers that wld be in the first half of a sorted array, and a minheap that keeps track of the numbers in the second half
- Have to ensure that all elements in minheap are greater than all elements in maxheap (can be done in O(1)) and that two heaps are as balanced as possible so that median computation can be O(1); sizes can differ by at most 1
- Can add every element into small heap initially, and then check above conditions - if they are not true, remove the element just added and put it into the large heap - for balancing, you also want to check that the `minheap > maxheap + 2`

Problem: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
- Traditional DFS to get all paths from root to leaf
- If path is odd length, there can only be one digit with an odd count for the path to be valid
- If path is even length, there can only be digits with even counts

Problem: https://leetcode.com/problems/lucky-numbers-in-a-matrix
- Can be proven that there can be max one lucky number
- Out of all row mins, the max row min is the only one that has a change to be lucky because the other vals in its row (which have to be greater than it), occur in the same columns as the other rows mins, and are going to be greater than it, preventing smaller row mins from having a chance to be lucky
- O(1) space solution involves just tracking max row min and checking all col mins to see if they are equal

Problem: https://leetcode.com/problems/validate-binary-search-tree/
- In-order traversal for BST returns nodes in ascending order; track previous node and ensure current one that is being seen is greater than it; if not, tree is not valid

Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/
- Reverse in order traversal - in order traversal will give all sorted from least to greatest, want to start with greatest node and update its sum first, maintain a counter for the total values added 
	- Start with right subtree since right values will be greatest

Problem: https://leetcode.com/problems/maximum-frequency-stack/
- Have a map of stacks, where key is count, and value is all numbers with that count
- All have a map to keep track of individual counts
- Whenever you pop, maxCount decrements by 1 (if there are no other elements with that count), and you delete the top element from the stack associated with maxCount

Problem: https://leetcode.com/problems/find-all-duplicates-in-an-array/
- Make solution O(1) space by using the array given as input
- Create mapping where since numbers are from 1-n, have number i map to index i - 1
- When you encounter a number, multiply number at `arr[i - 1]` by -1 as a sign that it has been visited (always take `abs(arr[i])`); if number is negative when you are trying to flip it again, add it to your resulting list

Problem: https://leetcode.com/problems/my-calendar-i/
- Maintain sorted list and do binary search to find position where a new interval can be inserted
- Then check with start value if it can be inserted

Problem: https://leetcode.com/problems/reorder-list/description/
- Reverse pointers in second half of list so that you can maintain a start and end pointer (and end can decrement after each iteration)
- Use fast and slow algorithm to find middle point in list
- Insert from the end pointer into start.next

Problem: https://leetcode.com/problems/word-search-ii/
- Use a trie and insert all words in the list
- Then go through the board and start doing floodfill
	- If board character is one of the children of the curr TrieNode you are at, traverse in all four directions, with TrieNode now set to `curr.children`
	- Can also have TrieNode maintain an isWord state, where if you reach a node where `node.isWord = true` then you can add it to the result

Problem: https://leetcode.com/problems/minimum-cost-to-convert-string-i/
- Construct directed graph `original[i] -> changed[i]` with `cost[i]`
- Run dijkstra 26 * 26 times (worst case) to find shortest path from each character in source to all other possible characters it can reach
- Then go through all characters of target to see whether cost exists from `source[i] -> target[i]`; path does not exist then return -1

Problem: https://leetcode.com/problems/palindromic-substrings/
- Go through each character and see how many even and odd palindromes can be formed with that character at the center

Problem: https://leetcode.com/problems/implement-queue-using-stacks/
- Have one stack that you always push onto
- When it is time to pop, if second stack is empty, transfer elements to second stack (notice how the order will get reversed, meaning the value we want to return will be `s2.pop()`)
	- Then for all the following pop operations until s2 is empty again, pop will be O(1)
	- This gives us an amortized O(1) solution for pop instead of O(n)

Problem: https://leetcode.com/problems/maximum-swap/description/
- Create a bucket array that stores the latest position of each digit 1-10
- Iterate through the digits and for each digit, check if a larger digit exists later in the array using the bucket array.
- If a larger digit is found, swap the current digit with the larger digit, convert the character array back to an integer, and return the result.
- If no beneficial swap is found, return the original number.

Problem: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
- Return number of nodes with indegree = 0

Problem: https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
- Standard backtracking problem, split at each possible point and only do recursive call if split ensures descending order with difference one condition
- Can use `BigInteger` java class to convert strings to comparable numbers
	- `BigInteger.valueOf(int i)`, `x.add(BigInteger.ONE)` etc are some helpful methods for this

Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/
- Looks like traditional floodfill, however, 8-directional floodfill will be $8^{nm}$ time complexity, which will definitely not work
- Instead, we can do bfs on the matrix - which has the property that when we reach the desired end point, we will know we have the optimal solution
	- Each queue element has x, y, and current distance - for all valid points 8-directionally, they are added to queue and marked as visited

Problem: https://leetcode.com/problems/prefix-and-suffix-search/
- Can use a trie and search for the prefix (and if it exists), add all word with the prefix to a set
	- Iterate over the set and see if any of the words ends in the desired suffix
- Another way is to add all combinations of prefix and suffix to a hashmap with the index number associated with the word
	- Then query the map for the prefix/suffix combination and return max weight or -1 if the combination is not in the map