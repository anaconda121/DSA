class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            st.push(nums2[i]);
        }


        int[] nums2Greater = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            int res = -1;
            Stack<Integer> stCpy = new Stack<Integer>();
            stCpy.addAll(st);
            if (!stCpy.isEmpty()) {
              int ptr = 0;
              while (ptr < i) { stCpy.pop();  ptr++; }
              while (!stCpy.isEmpty()) {
                  if (stCpy.peek() <= nums2[i]) stCpy.pop();
                  else break;
              }
            }
            
            if (!stCpy.isEmpty()) res = stCpy.pop();
            nums2Greater[i] = res;
        }


        HashMap<Integer, Integer> convert = new HashMap<>();
        for (int i = 0; i < nums2Greater.length; i++) {
            convert.put(nums2[i], nums2Greater[i]);
        }

        int[] finalRes = new int[nums1.length];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i] = convert.get(nums1[i]);
        }

        return finalRes;
    }
}
