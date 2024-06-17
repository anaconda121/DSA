class StringCompression {
    public int compress(char[] chars) {
        int l = 0;
        int r = 0;
        int currCount = 0;
        String res = "";
        char prev = chars[l];

        while (r < chars.length) {
            if (chars[r] == prev) {
                currCount++;
                r++;
            } else {
                if (currCount > 1) { res += prev + String.valueOf(currCount); } 
                else {  res += prev; }
                prev = chars[r];
                currCount = 1;
                l = r;
                r++;
            }
        }

        if (currCount > 1) { res += prev + String.valueOf(currCount); } 
        else { res += prev; }

        char[] resArr = res.toCharArray();
        for (int i = 0; i < resArr.length; i++) { chars[i] = resArr[i]; }

        return res.length(); 
    }
}
