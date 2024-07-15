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