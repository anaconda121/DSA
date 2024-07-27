class PeekingIterator implements Iterator<Integer> {
  int ptr;
  List<Integer> vals;

	public PeekingIterator(Iterator<Integer> iterator) {
    ptr = 0;
    vals = new ArrayList<>();
    while (iterator.hasNext()) {
      vals.add(iterator.next());
    }
	}
	
  // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
    return vals.get(ptr);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
    int res = vals.get(ptr);
    ptr++;
    return res;
	}
	
	@Override
	public boolean hasNext() {
	  return ptr < vals.size();
	}
}
