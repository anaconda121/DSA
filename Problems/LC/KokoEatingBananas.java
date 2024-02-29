class KokoEatingBananas {
    
    int f(int[] piles, int possibleK) {
        // return hours it will take to finish eating
        int hrs = 0;
        for (int i = 0; i < piles.length; i++) {
            hrs += Math.ceil((double) piles[i] / possibleK);
        }
        return hrs;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        // Arrays.sort(piles);

        int l = 0;
        int r = (int) (Math.pow(10, 9));
        int ans = (int) (Math.pow(10, 9));

        while (l <= r) {
            int curr = l + (r - l + 1) / 2;
            int currH = f(piles, curr);
            
            if (currH == h) {
                r = curr-1;
                ans = Math.min(ans, curr);
            } else if (currH > h) {
                l = curr + 1;
            } else if (currH < h) {
                r = curr-1;
                ans = Math.min(ans, curr);
            }

            // System.out.println(curr + " " + currH + " " + ans);
        }

        return ans;
    }
}
