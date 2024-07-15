Power of reversing a directed graph
- let's say you have a node $X$. If you want to determine the if $X$ has reach all other nodes and X can be reached be all other nodes, you can perform the following:
	- if $X$ can reach all other nodes: do dfs on original graph with starting node of $X$ and check if visited array has any false values
	- if $X$ can be reached: reverse the graph (such that if there is a path from $X \to Y$ in the original graph, than the reversed graph has a path from $Y \to X$). then do dfs on this reversed graph with starting node of $X$. and if the visited array has any false values, then you know that $X$ cannot be reached from that particular node. reasoning is this: if there is a path $Y \to X$ in reversed graph, there has to be a path $X \to Y$ in original graph. 
- this can be used to find strongly connected directed graph (in which all nodes can reach all other nodes and can be reached by all other nodes)

Dealing with Overflow in Variables
- condition for safely two numbers $a$ + $b$: ```if (a > INT_MAX - b) break;```
- becomes relevant in binary search / optimization problems

