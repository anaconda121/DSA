class ReverseWordsString {
    public String reverseWords(String s) {
        String[] sp = s.split("\\s+");
        String res = "";
        for (int i = sp.length - 1; i >= 0; i--) {
            if (!sp[i].equals("")) {
            res += sp[i];
            if (i > 0) { res += " "; }
            }
        }

        String[] sp2 = res.split(" ");
        String finalRes = "";
        for (int i = 0; i < sp2.length; i++) {
            if (i < sp2.length - 1) {
                finalRes += sp2[i] + " ";
            } else {
                finalRes += sp2[i];
            }
        }
        return finalRes;
    }
}
