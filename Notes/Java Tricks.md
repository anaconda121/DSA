Convert characters a-z to integer values 0-25: `char c = 'f'; int n = c - 'a', n = 5`

StringBuilder is much more efficient than using default java strings, below is syntax:
```java
StringBuilder res = new StringBuilder();
res.append("string");
res.setCharAt(idx, 'char');
...
return res.toString();
```

