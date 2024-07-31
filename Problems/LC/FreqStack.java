class FreqStack {
    private static class Element {
        int value;
        int frequency;

        Element(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }

    Stack<Element> stack;
    HashMap<Integer, Integer> frequencyMap;
    int maxFrequency;

    public FreqStack() {
        stack = new Stack<>();
        frequencyMap = new HashMap<>();
        maxFrequency = 0;
    }

    public void push(int val) {
        int freq = frequencyMap.getOrDefault(val, 0) + 1;
        frequencyMap.put(val, freq);
        maxFrequency = Math.max(maxFrequency, freq);
        stack.push(new Element(val, freq));
    }

    public int pop() {
        Stack<Element> tempStack = new Stack<>();
        Element mostFrequentElement = null;

        while (!stack.isEmpty()) {
            Element current = stack.pop();
            if (current.frequency == maxFrequency) {
                mostFrequentElement = current;
                break;
            }
            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        if (mostFrequentElement != null) {
            int val = mostFrequentElement.value;
            int freq = frequencyMap.get(val) - 1;
            if (freq == 0) {
                frequencyMap.remove(val);
            } else {
                frequencyMap.put(val, freq);
            }

            if (freq < maxFrequency) {
                maxFrequency = 0;
                for (int value : frequencyMap.values()) {
                    maxFrequency = Math.max(maxFrequency, value);
                }
            }

            return val;
        }

        return -1;
    }
}
