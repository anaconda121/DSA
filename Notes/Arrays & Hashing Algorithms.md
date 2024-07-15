Bucket Sort algorithm
- Problem: https://leetcode.com/problems/top-k-frequent-elements/
- Dictionary, where $k$ is count of number of times a value appeared in array
	- $v$ is a list that stores values which have count $k$
	- Powerful because it indexes entire array and gets counts of all elements in O(N)
		- you just need one pass before hand where you create a dictionary that has $k$ = value in array and $v$ equal to the count of that value