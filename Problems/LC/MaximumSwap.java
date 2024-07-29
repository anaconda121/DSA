public class MaximumSwap {
    String swapPos(String numStr, int i, int j) {
        char[] numArray = numStr.toCharArray();
        char temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
        return new String(numArray);
    }

    public int maximumSwap(int num) {
        int numClone = num;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0])
        );

        int pos = String.valueOf(num).length() - 1;
        while (numClone > 0) {
            int curr = numClone % 10;
            pq.add(new int[]{curr, pos});
            numClone /= 10;
            pos--;
        }

        Set<int[]> valuable = new LinkedHashSet<>();
        while (!pq.isEmpty()) {
            valuable.add(pq.poll());
        }
        String numStr = String.valueOf(num);
        int swapFront = -1;
        int swapBack = -1;
        for (int i = 0; i < numStr.length(); i++) {
            if (!valuable.isEmpty()) {
                Iterator<int[]> iterator = valuable.iterator();
                int[] first = iterator.next();

                if (first[0] > Character.getNumericValue(numStr.charAt(i))) {
                    swapFront = i;
                    swapBack = first[1];
                    break;
                }

                if (first[0] == Character.getNumericValue(numStr.charAt(i)) && i == first[1]) {
                    valuable.remove(first);
                } else {
                    iterator = valuable.iterator();
                    while (iterator.hasNext()) {
                        int[] element = iterator.next();
                        if (element[0] == Character.getNumericValue(numStr.charAt(i)) && element[1] == i) {
                            iterator.remove();
                            break;
                        }
                    }
                }
            }
        }

        if (swapFront != -1 && swapBack != -1) {
            String res = swapPos(numStr, swapFront, swapBack);
            return Integer.parseInt(res);
        }

        return num;
    }
}
