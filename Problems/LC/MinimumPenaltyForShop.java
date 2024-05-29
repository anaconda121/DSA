class MinimumPenaltyForShop {

    public int bestClosingTime(String customers) {
        int[] yCount = new int[customers.length() + 1];
        int[] nCount = new int[customers.length() + 1];

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                yCount[i + 1] = yCount[i] + 1; 
                nCount[i + 1] = nCount[i];
            } else { 
                nCount[i + 1] = nCount[i] + 1;
                yCount[i + 1] = yCount[i];
            }
        }

        int minPen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < yCount.length; i++) {
            // currently at time i - 1
            int noPen = nCount[i - 1];
            int yesPen = yCount[yCount.length - 1] - yCount[i - 1];
            int totalPen = noPen + yesPen;
            if (totalPen <= minPen) {
                if (totalPen == minPen) { ans = Math.min(ans, i - 1); }
                else { ans = i - 1; }
                minPen = totalPen;
            }
        }

        int noAfter = nCount[nCount.length - 1];
        int yesAfter = 0;
        if (noAfter < minPen) {
            ans = customers.length();
        }

        return ans;
    }
}
