public class NestedIterator implements Iterator<Integer> {
    List<Integer> flatten;
    Stack<Integer> allVals;
    int ptr;

    void recurseNested(List<NestedInteger> l) {
        for (NestedInteger n : l) {
            if (n.isInteger()) allVals.push(n.getInteger());
            else {
                recurseNested(n.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten = new ArrayList<>();
        allVals = new Stack<>();
        
        recurseNested(nestedList);

        while (!allVals.isEmpty()) {
            flatten.add(allVals.pop());
        }
        
        ptr = flatten.size() - 1;
    }

    @Override
    public Integer next() {
        int res = flatten.get(ptr);
        ptr--;
        return res;
    }

    @Override
    public boolean hasNext() {
        return ptr >= 0;
    }
}
