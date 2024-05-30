class CountAndSay {

    public String generateRLE(String s) {
        StringBuilder rle = new StringBuilder();
        int currCount = 1;
        char currNum = s.charAt(0);

        for (int r = 1; r < s.length(); r++) {
            if (s.charAt(r) == currNum) {
                currCount++;
            } else {
                rle.append(currCount).append(currNum);
                currNum = s.charAt(r);
                currCount = 1;
            }
        }

        rle.append(currCount).append(currNum);
        return rle.toString();
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String ans = "1";
        for (int i = 2; i <= n; i++) {
            ans = generateRLE(ans);
        }
        return ans;
    }   
}
